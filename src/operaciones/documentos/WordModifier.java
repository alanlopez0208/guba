package operaciones.documentos;

import org.apache.poi.xwpf.usermodel.*;
import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import modelos.CalificacionModelo;
import modelos.EstudianteModelo;
import operaciones.Config;
import operaciones.OpCalificaciones;
import operaciones.OpCarreras;
import operaciones.OpPeriodo;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

public class WordModifier {

    public void modifyDocument(Documentos documento, EstudianteModelo estudiante, String fecha) {

        Config config = new Config();
        String rutaBD = config.obtenerConfiguracion("06 RUTA Documentos");

        String folderPath = rutaBD;
        String filePath = folderPath + "\\" + documento.getNombre() + ".docx";

        try {

            FileInputStream fis = new FileInputStream(filePath);
            XWPFDocument document = new XWPFDocument(fis);

            switch (documento) {
                case Boleta -> {
                    rellenarBoleta(document, estudiante, fecha);
                }
                case Certificado -> {
                    rellenarCertificado(document, estudiante, fecha);
                }
                case Constancia -> {
                    rellenarConstancia(document, estudiante, fecha);
                }
                case Kardex -> {
                    rellenarKardek(document, estudiante, fecha);
                }
            }

            String generatedFolderPath = folderPath + "\\Generados";
            new File(generatedFolderPath).mkdirs();

            String modifiedFilePath = generatedFolderPath + "\\" + estudiante.getMatricula() + "_" + documento.getNombre() + ".docx";
            FileOutputStream fos = new FileOutputStream(modifiedFilePath);
            document.write(fos);
            fos.close();
            document.close();

            System.out.println("Documento modificado guardado en: " + modifiedFilePath);

            openModifiedDocument(modifiedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void replaceInDocument(XWPFDocument document, String placeholder, String newValue) {
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            replaceText(paragraph, placeholder, newValue);

            XmlCursor cursor = paragraph.getCTP().newCursor();
            cursor.selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//*/w:txbxContent/w:p/w:r");

            List<XmlObject> ctrsintxtbx = new ArrayList<XmlObject>();

            while (cursor.hasNextSelection()) {
                cursor.toNextSelection();
                XmlObject obj = cursor.getObject();
                ctrsintxtbx.add(obj);
            }
            for (XmlObject obj : ctrsintxtbx) {
                try {
                    CTR ctr = CTR.Factory.parse(obj.xmlText());
                    //CTR ctr = CTR.Factory.parse(obj.newInputStream());
                    XWPFRun bufferrun = new XWPFRun(ctr, (IRunBody) paragraph);
                    String text = bufferrun.getText(0);
                    if (text != null && text.contains(placeholder)) {
                        text = text.replace(placeholder, newValue);
                        bufferrun.setText(text, 0);
                    }
                    obj.set(bufferrun.getCTR());
                } catch (XmlException ex) {
                    Logger.getLogger(WordModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private static void replaceText(XWPFParagraph paragraph, String placeholder, String newValue) {
        for (XWPFRun run : paragraph.getRuns()) {
            String text = run.getText(0);
            if (text != null && text.contains(placeholder)) {
                text = text.replace(placeholder, newValue);
                run.setText(text, 0);
            }

        }
    }

    private void rellenarBoleta(XWPFDocument document, EstudianteModelo modelo, String fecha) {
        OpCalificaciones opCalificaciones = new OpCalificaciones();
        ArrayList<CalificacionModelo> calificaciones = opCalificaciones.obtenerCalificaciones(modelo.getId());
        OpPeriodo opPeriodo = new OpPeriodo();
        int totalMaterias = (int) calificaciones.stream().count();
        double promedio = calificaciones.stream().mapToDouble((cal) -> {
            cal.establecerPromedioFinal();
            return cal.getPromedioFinal() != null ? cal.getPromedioFinal() : 0.0;
        }).average().orElse(0.0);
        String promedioFormato = String.format("%.1f", promedio);
        int totalCredtios = calificaciones.stream().mapToInt((cal) -> {
            return Integer.valueOf(cal.getMateria().getCreditos());
        }).sum();
        String[] fechaArray = fecha.split("de");

        replaceInDocument(document, "name", modelo.toString());
        replaceInDocument(document, "career", modelo.getCarrera().getNombre() + ". " + modelo.getCarrera().getModalidad());
        replaceInDocument(document, "ciclo-escolar", opPeriodo.getUltimoPeriodo().getNombre());
        replaceInDocument(document, "classmate", Integer.toString(totalMaterias));
        replaceInDocument(document, "average", promedioFormato);
        replaceInDocument(document, "credtis", Integer.toString(totalCredtios));
        replaceInDocument(document, "date", fecha);
        replaceInDocument(document, "dd", fechaArray[0]);
        replaceInDocument(document, "MM", fechaArray[1]);
        replaceInDocument(document, "yyyy", fechaArray[2]);

        calificaciones.forEach((cal) -> {
            rellenarFilaCalificacion(document, cal, "Calibri Light", "15", "325", "2", "188", "196", "217", "2", "2");
        });
    }

    private void rellenarConstancia(XWPFDocument document, EstudianteModelo modelo, String fecha) {
        OpPeriodo opPeriodo = new OpPeriodo();
        String nombreCarrera = Arrays.stream(modelo.getCarrera().getNombre().split(" ")).map((palabra) -> {

            return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();

        }).collect(Collectors.joining(" "));

        replaceInDocument(document, "name", modelo.toString());
        replaceInDocument(document, "career", "\"" + nombreCarrera + "\"");
        replaceInDocument(document, "modality", modelo.getCarrera().getModalidad());
        replaceInDocument(document, "tuition", modelo.getMatricula());
        replaceInDocument(document, "ciclo-inicio", opPeriodo.getUltimoPeriodo().getInicio());
        replaceInDocument(document, "date", fecha);
    }

    private void rellenarCertificado(XWPFDocument document, EstudianteModelo modelo, String fecha) {
        OpCalificaciones opCalificaciones = new OpCalificaciones();
        ArrayList<CalificacionModelo> calificaciones = opCalificaciones.obtenerCalificaciones(modelo.getId());
        double promedio = calificaciones.stream().mapToDouble((CalificacionModelo cal) -> {
            cal.establecerPromedioFinal();
            return cal.getPromedioFinal() != null ? cal.getPromedioFinal() : 0.0;
        }).average().orElse(0.0);
        String promedioFinal = String.format("%.1f", promedio);

        String genero = modelo.getSexo().equals("Hombre") ? "el alumno" : "la alumna";
        String[] fechaArray = fecha.split("de");

        replaceInDocument(document, "name", modelo.toString().toUpperCase());
        replaceInDocument(document, "date", fecha);
        replaceInDocument(document, "tuition", modelo.getMatricula());
        replaceInDocument(document, "gener", genero);
        replaceInDocument(document, "career", modelo.getCarrera().getNombre().toUpperCase());
        replaceInDocument(document, "totalAsignaturas", modelo.getCarrera().getTotalAsignaturas());
        replaceInDocument(document, "averaje", promedioFinal);
        replaceInDocument(document, "letter", numeroAString(promedioFinal));
        replaceInDocument(document, "credits", modelo.getCarrera().getCreditos());
        replaceInDocument(document, "dd", fechaArray[0].trim());
        replaceInDocument(document, "MM", fechaArray[1].trim());
        replaceInDocument(document, "yyyy", fechaArray[2].trim());

        calificaciones.forEach((cal) -> {
            rellenarFilaCalificacion(document, cal, "Arial", "188", "325", "225", "125", "175", "225", "275", "225");
        });
    }

    private void rellenarFilaCalificacion(XWPFDocument document, CalificacionModelo cal, String fontFamily, String... array) {
        cal.establecerPromedioFinal();
        XWPFTable tabla = document.getTables().get(0);

        XWPFTableRow filaCalificacion = tabla.createRow();

        XWPFTableCell celda1 = filaCalificacion.getCell(0);
        celda1.setWidth(array[0]);
        celda1.setText(cal.getMateria().getClave());

        XWPFTableCell celda2 = filaCalificacion.getCell(1);
        celda2.setWidth(array[1]);
        celda2.setText(cal.getMateria().getNombre());

        XWPFTableCell celda3 = filaCalificacion.getCell(2);
        celda3.setWidth(array[2]);
        celda3.setText(cal.getMateria().getCreditos());

        XWPFTableCell celda4 = filaCalificacion.getCell(3);
        celda4.setWidth(array[3]);

        String resultado = String.format("%.1f", cal.getPromedioFinal() != null ? cal.getPromedioFinal() : 0.0);

        celda4.setText(resultado);

        XWPFTableCell celda5 = filaCalificacion.getCell(4);
        celda5.setWidth(array[4]);
        celda5.setText(numeroAString(resultado));

        XWPFTableCell celda6 = filaCalificacion.getCell(5);

        celda6.setWidth(array[5]);

        XWPFTableCell celda7 = filaCalificacion.getCell(6);
        celda7.setText(cal.getMateria().getClave());
        celda7.setWidth(array[6]);

        XWPFTableCell celda8 = filaCalificacion.createCell();
        celda8.setWidth(array[7]);

        for (int i = 0; i < 8; i++) {
            XWPFTableCell celda = filaCalificacion.getCell(i);

            CTTcPr tcPr = celda.getCTTc().addNewTcPr();
            CTTcBorders borders = tcPr.addNewTcBorders();

            borders.addNewTop().setVal(STBorder.SINGLE);
            borders.addNewBottom().setVal(STBorder.SINGLE);
            borders.addNewLeft().setVal(STBorder.SINGLE);
            borders.addNewRight().setVal(STBorder.SINGLE);

            borders.getTop().setSz(BigInteger.valueOf(10));
            borders.getBottom().setSz(BigInteger.valueOf(10));
            borders.getLeft().setSz(BigInteger.valueOf(10));
            borders.getRight().setSz(BigInteger.valueOf(10));

            celda.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

            XWPFParagraph parrafo = celda.addParagraph();
            parrafo.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = parrafo.createRun();
            run.setFontFamily(fontFamily);

            run.setFontSize(10);
            run.setText(celda.getText());
            celda.removeParagraph(0);
        }

    }

    private void rellenarKardek(XWPFDocument document, EstudianteModelo modelo, String fecha) {
        OpCalificaciones opCalificaciones = new OpCalificaciones();
        ArrayList<CalificacionModelo> calificaciones = opCalificaciones.obtenerCalificaciones(modelo.getId());
        double promedio = calificaciones.stream().mapToDouble((CalificacionModelo cal) -> {
            cal.establecerPromedioFinal();
            return cal.getPromedioFinal() != null ? cal.getPromedioFinal() : 0.0;
        }).average().orElse(0.0);
        String promedioFinal = String.format("%.1f", promedio);
        int totalCredtios = calificaciones.stream().mapToInt((cal) -> {
            return Integer.valueOf(cal.getMateria().getCreditos());
        }).sum();

        String genero = modelo.getSexo().equals("Hombre") ? "el alumno" : "la alumna";
        String[] fechaArray = fecha.split("de");

        replaceInDocument(document, "peter", promedioFinal);
        replaceInDocument(document, "name", modelo.toString().toUpperCase());
        replaceInDocument(document, "date", fecha);
        replaceInDocument(document, "birth", modelo.getNacimiento());
        replaceInDocument(document, "addres", modelo.getDireccion());
        replaceInDocument(document, "tuition", modelo.getMatricula().toLowerCase());
        replaceInDocument(document, "career", modelo.getCarrera().getNombre().toUpperCase());
        replaceInDocument(document, "totalAsignaturas", Integer.toString(calificaciones.size()));

        replaceInDocument(document, "origin", modelo.getEscProcedencia());
        replaceInDocument(document, "phone", modelo.getNumCelular());
        replaceInDocument(document, "credits", Integer.toString(totalCredtios));
        replaceInDocument(document, "dd", fechaArray[0].trim());
        replaceInDocument(document, "MM", fechaArray[1].trim());
        replaceInDocument(document, "yyyy", fechaArray[2].trim());

        calificaciones.forEach((cal) -> {
            rellenarFilaCalificacion(document, cal, "Times New Roman", "188", "325", "225", "125", "175", "225", "275", "225");
        });
    }

    public void rellarTitulo(EstudianteModelo modelo, String acuerdo, String tipoExamen, String fechaAcuerdo, String fechaAplicacion, String horaAp, String duracion, String horaFil, String presidente, String secretario, String vocal, String acta, String libro, String hoja, String nombreTesis) {
        Config config = new Config();
        String rutaBD = config.obtenerConfiguracion("06 RUTA Documentos");
        String folderPath = rutaBD;
        String filePath = folderPath + "\\Acta de Examen\\" + "acta" + ".docx";

        try {

            FileInputStream fis = new FileInputStream(filePath);
            XWPFDocument document = new XWPFDocument(fis);

            String genero = modelo.getSexo().equals("Hombre") ? "de el" : "de la";
            String carrera = Arrays.stream(modelo.getCarrera().toString().split(" ")).map(palabra -> palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase()).collect(Collectors.joining(" "));

            replaceInDocument(document, "date", fechaAcuerdo);
            replaceInDocument(document, "tezt", tipoExamen);
            replaceInDocument(document, "hoursI", horaAp);
            replaceInDocument(document, "date", fechaAcuerdo);
            replaceInDocument(document, "tesispresident", presidente);
            replaceInDocument(document, "tesissecretario", secretario);
            replaceInDocument(document, "tesisvocal", vocal);
            replaceInDocument(document, "gener", genero);
            replaceInDocument(document, "name", modelo.toString());
            replaceInDocument(document, "career", carrera);
            replaceInDocument(document, "thesis", nombreTesis);
            replaceInDocument(document, "duration", duracion);
            replaceInDocument(document, "fhoras", horaFil);
            replaceInDocument(document, "record", acta);
            replaceInDocument(document, "book", libro);
            replaceInDocument(document, "sheet", hoja);

            String generatedFolderPath = folderPath + "\\Generados";
            new File(generatedFolderPath).mkdirs();

            String modifiedFilePath = generatedFolderPath + "\\" + modelo.getMatricula() + "_" + "acta" + ".docx";
            FileOutputStream fos = new FileOutputStream(modifiedFilePath);
            document.write(fos);
            fos.close();
            document.close();

            System.out.println("Documento modificado guardado en: " + modifiedFilePath);

            openModifiedDocument(modifiedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String numeroAString(String resultado) {

        double calficacion = Double.parseDouble(resultado);
        String[] letrasNumero = {
            "CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE", "DIEZ"
        };

        int parteEntera = (int) calficacion;
        int parteDecimal = (int) ((calficacion - parteEntera) * 10);

        return letrasNumero[parteEntera] + " PUNTO " + letrasNumero[parteDecimal];
    }

    // Método para abrir el documento modificado automáticamente
    private void openModifiedDocument(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("El archivo no existe: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

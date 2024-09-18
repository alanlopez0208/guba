package operaciones.documentos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import modelos.EstudianteModelo;
import operaciones.Config;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

public class PPTModifier {

    public void modificarPPT(EstudianteModelo estudiante, String horasDuracion, String tipoCurso, String nombreCurso, String fechaInicio, String fechaFinalizacion, String fehcaHoy, String modalidad, String nombre, String puesto, String esc) {

        Config config = new Config();
        String rutaBD = config.obtenerConfiguracion("06 RUTA Documentos");

        String filePath = rutaBD + "\\" + "Constancias" + "\\" + "constancia.pptx";

        File presentacion = new File(filePath);

        try {

            FileInputStream inputstream = new FileInputStream(presentacion);
            XMLSlideShow ppt = new XMLSlideShow(inputstream);

            XSLFSlide diapositiva = ppt.getSlides().get(0);

            remplazarTexto(diapositiva, "boss", nombre);
            remplazarTexto(diapositiva, "puest", puesto);
            remplazarTexto(diapositiva, "place", esc);
            remplazarTexto(diapositiva, "person", estudiante.toString());
            remplazarTexto(diapositiva, "mood", tipoCurso);
            remplazarTexto(diapositiva, "name", nombreCurso);
            remplazarTexto(diapositiva, "hours", horasDuracion);
            remplazarTexto(diapositiva, "init", fechaInicio);
            remplazarTexto(diapositiva, "enda", fechaFinalizacion);
            remplazarTexto(diapositiva, "today", fehcaHoy);
            remplazarTexto(diapositiva, "covid", modalidad);

            String rutaDelDocumentoCreado = rutaBD + "\\Generados" + "\\" + "" + "_" + "constancia.pptx";
            File documentoGenerado = new File(rutaDelDocumentoCreado);
            FileOutputStream out = new FileOutputStream(documentoGenerado);
            ppt.write(out);
            out.close();
            openModifiedDocument(rutaDelDocumentoCreado);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void remplazarTexto(XSLFSlide diapositiva, String placeholder, String newvalue) {
        for (XSLFShape shape : diapositiva.getShapes()) {
            if (shape instanceof XSLFTextShape) {
                XSLFTextShape textShape = (XSLFTextShape) shape;

                for (XSLFTextParagraph paragraph : textShape.getTextParagraphs()) {
                    for (XSLFTextRun run : paragraph.getTextRuns()) {

                        String text = run.getRawText();
                        if (text != null && text.contains(placeholder)) {

                            text = text.replace(placeholder, newvalue);
                            run.setText(text);
                        }
                    }
                }
            }
        }
    }

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

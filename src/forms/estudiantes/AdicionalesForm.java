package forms.estudiantes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import operaciones.web.InsertWebpass;
import operaciones.OpAlumno;
import modelos.EstudianteModelo;
import modelos.TitulacionModelo;
import operaciones.OpTitulacion;
import operaciones.documentos.FileOpener;
import operaciones.documentos.Documentos;
import operaciones.documentos.PPTModifier;
import operaciones.documentos.WordModifier;
import operaciones.web.ApiClient;
import operaciones.web.InsertWebpass;

import org.json.JSONArray;

public class AdicionalesForm extends javax.swing.JPanel {

    boolean bandera;
    EstudianteModelo estudiante;
    private OpAlumno opAlumno;
    private FileOpener fileOpener;
    private WordModifier modificador;
    private PPTModifier pptModifacador;
    private OpTitulacion opTitulacion;
    private TitulacionModelo titulacion;

    public AdicionalesForm(EstudianteModelo estudiante) {
        initComponents();
        this.estudiante = estudiante;
        bandera = false;
        opAlumno = new OpAlumno();
        fileOpener = new FileOpener();
        opTitulacion = new OpTitulacion();
        init();
    }

    private void init() {
        modificador = new WordModifier();
        pptModifacador = new PPTModifier();
        txtFechaAcuerdo.setDateFormatString("dd/MMMM/yyyy");
        txtFechaAplicacion.setDateFormatString("dd/MMMM/yyyy");
        txtFechaGenerado.setDateFormatString("dd/MMMM/yyyy");
        txtFechaInicio.setDateFormatString("dd/MMMM/yyyy");
        txtFechaFinalizacion.setDateFormatString("dd/MMMM/yyyy");
        txtUsuario.setText(estudiante.getMatricula());
        txtPass.setText(estudiante.getPasswordTemporal());

        for (Documentos documento : Documentos.values()) {
            comboReporte.addItem(documento);
        }

        titulacion = opTitulacion.getTitulacionByIdAlumno(estudiante.getMatricula());

        if (titulacion != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaAcuerdo = null;
            Date fechaAplicacion = null;
            try {
                System.out.println(titulacion.getFechaAcuerdo());
                System.out.println(titulacion.getFechaAplicacion());
                fechaAcuerdo = sdf.parse(titulacion.getFechaAcuerdo());
                fechaAplicacion = sdf.parse(titulacion.getFechaAplicacion());
                txtFechaAcuerdo.setDate(fechaAcuerdo);
                txtFechaAplicacion.setDate(fechaAplicacion);
            } catch (ParseException ex) {
                System.out.println("Error ");
            }

            String[] aplicacion = titulacion.getHoraAplicacion().split(":");
            int horaAplicacion = Integer.parseInt(aplicacion[0]);
            int minutoAplicacion = Integer.parseInt(aplicacion[1]);

            String[] finalizacion = titulacion.getHoraFinalizacion().split(":");
            int horaFinalizacion = Integer.parseInt(finalizacion[0]);
            int minutoFinalizacion = Integer.parseInt(finalizacion[1]);

            txtHoraAplicacion.setValue(horaAplicacion);
            txtMinutoAplicacion.setValue(minutoAplicacion);

            txtHoraFinalizacion.setValue(horaFinalizacion);
            txtMinutoFinalizacion.setValue(minutoFinalizacion);

            txtMinutoDuracion.setValue(Integer.parseInt(titulacion.getDuracion()));

            txtPresidente.setText(String.valueOf(titulacion.getPresidente()));
            txtSecretario.setText(String.valueOf(titulacion.getSecretario()));
            txtVocal.setText(String.valueOf(titulacion.getVocal()));

            txtActa.setText(String.valueOf(titulacion.getRegistro()));
            txtLibro.setText(String.valueOf(titulacion.getLibro()));
            txtHoja.setText(String.valueOf(titulacion.getFoja()));
            txtAcuerdo.setText(titulacion.getAcuerdo());
            txtTipoExamen.setText(titulacion.getTipoExamen());
            txtNombreTesis.setText(String.valueOf(titulacion.getNombre()));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myPanel1 = new swim.panel.MyPanel();
        myPanel2 = new swim.panel.MyPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnShowPass = new javax.swing.JButton();
        myPanel3 = new swim.panel.MyPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonRounded2 = new swim.botones.ButtonRounded();
        txtAcuerdo = new swim.text.TextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaAcuerdo = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtTipoExamen = new swim.text.TextField();
        jLabel10 = new javax.swing.JLabel();
        txtHoraAplicacion = new com.toedter.components.JSpinField();
        jLabel11 = new javax.swing.JLabel();
        txtMinutoAplicacion = new com.toedter.components.JSpinField();
        jLabel12 = new javax.swing.JLabel();
        txtFechaAplicacion = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txtPresidente = new swim.text.TextField();
        txtSecretario = new swim.text.TextField();
        txtVocal = new swim.text.TextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtActa = new swim.text.TextField();
        jLabel30 = new javax.swing.JLabel();
        txtLibro = new swim.text.TextField();
        jLabel31 = new javax.swing.JLabel();
        txtHoja = new swim.text.TextField();
        jLabel32 = new javax.swing.JLabel();
        txtNombreTesis = new swim.text.TextField();
        jLabel34 = new javax.swing.JLabel();
        txtMinutoDuracion = new com.toedter.components.JSpinField();
        jLabel35 = new javax.swing.JLabel();
        txtHoraFinalizacion = new com.toedter.components.JSpinField();
        jLabel36 = new javax.swing.JLabel();
        txtMinutoFinalizacion = new com.toedter.components.JSpinField();
        myPanel4 = new swim.panel.MyPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        buttonRounded3 = new swim.botones.ButtonRounded();
        txtTipoCurso = new swim.text.TextField();
        jLabel20 = new javax.swing.JLabel();
        txtNombreCurso = new swim.text.TextField();
        jLabel37 = new javax.swing.JLabel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        txtFechaFinalizacion = new com.toedter.calendar.JDateChooser();
        jLabel40 = new javax.swing.JLabel();
        txtHorasDuracion = new com.toedter.components.JSpinField();
        jLabel41 = new javax.swing.JLabel();
        fechaCreacion = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNombreImpartidor = new swim.text.TextField();
        jLabel22 = new javax.swing.JLabel();
        txtPuestoImpartidor = new swim.text.TextField();
        txtEscuelaProcRepartidor = new swim.text.TextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtModalidad = new swim.text.TextField();
        myPanel5 = new swim.panel.MyPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboReporte = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtFechaGenerado = new com.toedter.calendar.JDateChooser();
        buttonRounded1 = new swim.botones.ButtonRounded();

        jScrollPane1.setBorder(null);

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Usuario: ");

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña: ");

        txtUsuario.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Portal Web");

        txtPass.setText("jPasswordField1");

        btnShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btnShowPass.setContentAreaFilled(false);
        btnShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel5)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel6.setText("Acuerdo:");

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        jLabel8.setText("Informacion de Titulación");

        buttonRounded2.setBackground(new java.awt.Color(20, 90, 95));
        buttonRounded2.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded2.setText("Crear Documento");
        buttonRounded2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded2ActionPerformed(evt);
            }
        });

        txtAcuerdo.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de Acuerdo: ");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Tipo de Examen:");

        txtTipoExamen.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel11.setText("Hora de Aplicación:");

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel12.setText("Fecha de Aplicación:");

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Información Titulo:");

        txtPresidente.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtSecretario.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtVocal.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel14.setText("Presidente");

        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel15.setText("Vocal");

        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel16.setText("Secretario");

        jLabel28.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel28.setText("Sinodales:");

        jLabel29.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel29.setText("Acta:");

        txtActa.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel30.setText("Libro:");

        txtLibro.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel31.setText("Hoja:");

        txtHoja.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel32.setText("Nombre de Tesis:");

        txtNombreTesis.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel34.setText("Duración:");

        jLabel35.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel35.setText("Hora de finalización:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText(":");

        javax.swing.GroupLayout myPanel3Layout = new javax.swing.GroupLayout(myPanel3);
        myPanel3.setLayout(myPanel3Layout);
        myPanel3Layout.setHorizontalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel3Layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(21, 21, 21)
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(txtHoraFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMinutoFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMinutoDuracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myPanel3Layout.createSequentialGroup()
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTipoExamen, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(txtAcuerdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(myPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFechaAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(myPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(23, 23, 23)
                                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(txtFechaAcuerdo, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(21, 21, 21)
                                .addComponent(txtHoraAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMinutoAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanel3Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(txtSecretario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(169, 169, 169))
            .addGroup(myPanel3Layout.createSequentialGroup()
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, myPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(myPanel3Layout.createSequentialGroup()
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel32))
                                .addGap(42, 42, 42)
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreTesis, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(myPanel3Layout.createSequentialGroup()
                                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16)
                                            .addGroup(myPanel3Layout.createSequentialGroup()
                                                .addComponent(txtActa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel30)
                                                .addGap(51, 51, 51)
                                                .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel31)))
                                        .addGap(51, 51, 51)
                                        .addComponent(txtHoja, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, myPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel28)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel3Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addComponent(txtVocal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(306, 306, 306))))
            .addGroup(myPanel3Layout.createSequentialGroup()
                .addGap(594, 594, 594)
                .addComponent(buttonRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanel3Layout.setVerticalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel3Layout.createSequentialGroup()
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel3Layout.createSequentialGroup()
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtAcuerdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(myPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaAcuerdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(29, 29, 29)
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtTipoExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanel3Layout.createSequentialGroup()
                                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(txtFechaAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMinutoAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addGap(16, 16, 16)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addComponent(txtMinutoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoraFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMinutoFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPresidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecretario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)))
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(29, 29, 29)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtActa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtHoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtNombreTesis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(buttonRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        myPanel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Tipo del Curso:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setText("Diplomas");

        buttonRounded3.setBackground(new java.awt.Color(20, 90, 95));
        buttonRounded3.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded3.setText("Crear Documento");
        buttonRounded3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded3ActionPerformed(evt);
            }
        });

        txtTipoCurso.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Nombre del Curso:");

        txtNombreCurso.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Fecha de Inicio:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Fecha de Finalización:");

        jLabel40.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel40.setText("Horas de Duración:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Fecha de Creación:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Datos de quien impartio el Curso");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Nombre:");

        txtNombreImpartidor.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Puesto:");

        txtPuestoImpartidor.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtEscuelaProcRepartidor.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Escuela Procedencia:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText(" Modalidad;");

        txtModalidad.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        javax.swing.GroupLayout myPanel4Layout = new javax.swing.GroupLayout(myPanel4);
        myPanel4.setLayout(myPanel4Layout);
        myPanel4Layout.setHorizontalGroup(
            myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel4Layout.createSequentialGroup()
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGap(671, 671, 671)
                        .addComponent(jLabel18))
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGap(624, 624, 624)
                        .addComponent(buttonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(myPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(myPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(22, 22, 22)
                                .addComponent(txtTipoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24)
                                .addGap(21, 21, 21)
                                .addComponent(txtModalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addGap(21, 21, 21)
                                .addComponent(txtNombreCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(txtHorasDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(23, 23, 23)
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel38)
                                .addGap(23, 23, 23)
                                .addComponent(txtFechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41)
                                .addGap(23, 23, 23)
                                .addComponent(fechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(22, 22, 22)
                                .addComponent(txtNombreImpartidor, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPuestoImpartidor, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEscuelaProcRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        myPanel4Layout.setVerticalGroup(
            myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtTipoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel40)
                        .addComponent(txtHorasDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(txtFechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(fechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(41, 41, 41)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(txtEscuelaProcRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtPuestoImpartidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtNombreImpartidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(buttonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Documentos Generales:");

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Reporte: ");

        comboReporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------------------" }));

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fecha: ");

        buttonRounded1.setBackground(new java.awt.Color(20, 90, 95));
        buttonRounded1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded1.setText("Crear Reporte");
        buttonRounded1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel5Layout = new javax.swing.GroupLayout(myPanel5);
        myPanel5.setLayout(myPanel5Layout);
        myPanel5Layout.setHorizontalGroup(
            myPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(197, 197, 197))
            .addGroup(myPanel5Layout.createSequentialGroup()
                .addGroup(myPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(myPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(myPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaGenerado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(myPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(myPanel5Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        myPanel5Layout.setVerticalGroup(
            myPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaGenerado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(myPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(myPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(myPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(myPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPassActionPerformed

        if (bandera) {
            btnShowPass.setIcon(new ImageIcon((getClass().getResource("/icon/close.png"))));
            txtPass.setEchoChar('*');
            bandera = false;
            return;
        }
        JTextField txtUsuario = new JTextField(10);
        JPasswordField txtPassword = new JPasswordField(10);

        // Crear el JOptionPane con el JTextField como componente
        Object[] message = {
            "Ingrese el Usuario padre:", txtUsuario,
            "Ingrese la contraseña:", txtPassword,};

        int option = JOptionPane.showConfirmDialog(null, message, "Ingresa los datos", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            String usuario = txtUsuario.getText();
            char[] charPassword = txtPassword.getPassword();

            String contraseña = new String(charPassword);

            if (usuario.equals("subir@gubaescolares.com") && contraseña.equals("p_WyU)p}&shG")) {
                btnShowPass.setIcon(new ImageIcon((getClass().getResource("/icon/abierto.png"))));
                txtPass.setEchoChar('\0');
                bandera = true;

                InsertWebpass pass = new InsertWebpass();
                JSONArray alumnos = ApiClient.getAlumnos();
                pass.upsertDataToLocalDB("Alumnos", alumnos, "IdAlumno", "Password");

                txtPass.setText(opAlumno.getEstudiante(estudiante.getMatricula()).getPassword());
            } else {
                JOptionPane.showInternalMessageDialog(null, "Contraseña Incorrecta");
            }
        }


    }//GEN-LAST:event_btnShowPassActionPerformed

    private void buttonRounded1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded1ActionPerformed
        if (comboReporte.getSelectedIndex() > 0) {
            Documentos documento = (Documentos) comboReporte.getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
            String fechaDeGeneracion = sdf.format(txtFechaGenerado.getDate());
            modificador.modifyDocument(documento, estudiante, fechaDeGeneracion);
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado algun Reporte a generar");
        }

    }//GEN-LAST:event_buttonRounded1ActionPerformed

    private void buttonRounded2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded2ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        String acuerdo = txtAcuerdo.getText().trim();
        String tipoExamen = txtTipoExamen.getText().trim();
        // Formatear las fechas usando sdf
        String fechaAcuerdo = sdf.format(txtFechaAcuerdo.getDate());
        String fechaAplicacion = sdf.format(txtFechaAplicacion.getDate());
        String horaAplicacion = Integer.toString(txtHoraAplicacion.getValue());
        String minutoAplicacion = Integer.toString(txtMinutoAplicacion.getValue());
        String minutoDuracion = Integer.toString(txtMinutoDuracion.getValue());
        String horaFinalizacion = Integer.toString(txtHoraFinalizacion.getValue());
        String minutoFinalizacion = Integer.toString(txtMinutoFinalizacion.getValue());

        String presidente = txtPresidente.getText().trim();
        String secretario = txtSecretario.getText().trim();
        String vocal = txtVocal.getText().trim();
        String acta = txtActa.getText().trim();
        String libro = txtLibro.getText().trim();
        String hoja = txtHoja.getText().trim();
        String nombreTesis = txtNombreTesis.getText().trim();

        if (!acuerdo.isEmpty() && !tipoExamen.isEmpty()
                && !fechaAcuerdo.isEmpty() && !fechaAplicacion.isEmpty()
                && !horaAplicacion.isEmpty() && !minutoAplicacion.isEmpty()
                && !minutoDuracion.isEmpty()
                && !horaFinalizacion.isEmpty() && !minutoFinalizacion.isEmpty()
                && !presidente.isEmpty() && !secretario.isEmpty()
                && !vocal.isEmpty() && !acta.isEmpty() && !libro.isEmpty()
                && !hoja.isEmpty() && !nombreTesis.isEmpty()) {

            if (titulacion == null) {
                titulacion = new TitulacionModelo();
                titulacion.setAcuerdo(acuerdo);
                titulacion.setTipoExamen(tipoExamen);
                SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
                fechaAcuerdo = s.format(txtFechaAcuerdo.getDate());
                fechaAplicacion = s.format(txtFechaAplicacion.getDate());

                titulacion.setFechaAcuerdo(fechaAcuerdo);
                titulacion.setFechaAplicacion(fechaAplicacion);

                titulacion.setHoraAplicacion(horaAplicacion + ":" + minutoAplicacion);
                titulacion.setDuracion(minutoDuracion);

                titulacion.setHoraFinalizacion(horaFinalizacion + ":" + minutoFinalizacion);

                titulacion.setPresidente(presidente);
                titulacion.setSecretario(secretario);
                titulacion.setVocal(vocal);
                titulacion.setFolio(acta);
                titulacion.setLibro(libro);
                titulacion.setFoja(hoja);
                titulacion.setNombre(nombreTesis);
                titulacion.setIdAlumno(estudiante.getMatricula());
                titulacion.setActa(txtActa.getText());
                opTitulacion.crearTitulacion(titulacion);

            } else {
                SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
                fechaAcuerdo = s.format(txtFechaAcuerdo.getDate());
                fechaAplicacion = s.format(txtFechaAplicacion.getDate());
                titulacion.setAcuerdo(acuerdo);
                titulacion.setTipoExamen(tipoExamen);
                titulacion.setFechaAcuerdo(fechaAcuerdo);
                titulacion.setFechaAplicacion(fechaAplicacion);

                titulacion.setHoraAplicacion(horaAplicacion + ":" + minutoAplicacion);
                titulacion.setDuracion(minutoDuracion);

                titulacion.setHoraFinalizacion(horaFinalizacion + ":" + minutoFinalizacion);

                titulacion.setPresidente(presidente);
                titulacion.setSecretario(secretario);
                titulacion.setVocal(vocal);
                titulacion.setFolio(acta);
                titulacion.setLibro(libro);
                titulacion.setFoja(hoja);
                titulacion.setNombre(nombreTesis);
              
                opTitulacion.updateTitulacionByIdAlumno(titulacion);
            }

            modificador.rellarTitulo(estudiante, acuerdo, tipoExamen, fechaAcuerdo,
                    fechaAplicacion, horaAplicacion + ":" + minutoAplicacion,
                    minutoDuracion,
                    horaFinalizacion + ":" + minutoFinalizacion,
                    presidente, secretario, vocal, acta, libro, hoja, nombreTesis);
        } else {

            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de continuar.");
        }


    }//GEN-LAST:event_buttonRounded2ActionPerformed

    private void buttonRounded3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded3ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        String acuerdo = txtTipoCurso.getText().trim();
        String tipoExamen = txtNombreCurso.getText().trim();
        String fehchaInicio = sdf.format(txtFechaInicio.getDate());

        String duracionHoras = Integer.toString(txtHorasDuracion.getValue());

        String fecha = sdf.format(fechaCreacion.getDate());
        String fechaFinalizacion = sdf.format(txtFechaFinalizacion.getDate());
        String nombreRepartidor = txtNombreImpartidor.getText();
        String puesto = txtPuestoImpartidor.getText();
        String escuelaProcedencia = txtEscuelaProcRepartidor.getText();
        String modalidad = txtModalidad.getText().trim();

        if (!acuerdo.isEmpty() && !tipoExamen.isEmpty() && fehchaInicio != null && fechaFinalizacion != null && !nombreRepartidor.isEmpty() && !puesto.isEmpty() && !escuelaProcedencia.isEmpty()) {

            PPTModifier pptModifier = new PPTModifier();

            pptModifier.modificarPPT(estudiante, duracionHoras, acuerdo, tipoExamen, fehchaInicio, fechaFinalizacion, fecha, modalidad, nombreRepartidor, puesto, escuelaProcedencia);

        } else {

            System.out.println("Por favor, complete todos los campos.");
        }
    }//GEN-LAST:event_buttonRounded3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowPass;
    private swim.botones.ButtonRounded buttonRounded1;
    private swim.botones.ButtonRounded buttonRounded2;
    private swim.botones.ButtonRounded buttonRounded3;
    private javax.swing.JComboBox comboReporte;
    private com.toedter.calendar.JDateChooser fechaCreacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private swim.panel.MyPanel myPanel1;
    private swim.panel.MyPanel myPanel2;
    private swim.panel.MyPanel myPanel3;
    private swim.panel.MyPanel myPanel4;
    private swim.panel.MyPanel myPanel5;
    private swim.text.TextField txtActa;
    private swim.text.TextField txtAcuerdo;
    private swim.text.TextField txtEscuelaProcRepartidor;
    private com.toedter.calendar.JDateChooser txtFechaAcuerdo;
    private com.toedter.calendar.JDateChooser txtFechaAplicacion;
    private com.toedter.calendar.JDateChooser txtFechaFinalizacion;
    private com.toedter.calendar.JDateChooser txtFechaGenerado;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private swim.text.TextField txtHoja;
    private com.toedter.components.JSpinField txtHoraAplicacion;
    private com.toedter.components.JSpinField txtHoraFinalizacion;
    private com.toedter.components.JSpinField txtHorasDuracion;
    private swim.text.TextField txtLibro;
    private com.toedter.components.JSpinField txtMinutoAplicacion;
    private com.toedter.components.JSpinField txtMinutoDuracion;
    private com.toedter.components.JSpinField txtMinutoFinalizacion;
    private swim.text.TextField txtModalidad;
    private swim.text.TextField txtNombreCurso;
    private swim.text.TextField txtNombreImpartidor;
    private swim.text.TextField txtNombreTesis;
    private javax.swing.JPasswordField txtPass;
    private swim.text.TextField txtPresidente;
    private swim.text.TextField txtPuestoImpartidor;
    private swim.text.TextField txtSecretario;
    private swim.text.TextField txtTipoCurso;
    private swim.text.TextField txtTipoExamen;
    private javax.swing.JTextField txtUsuario;
    private swim.text.TextField txtVocal;
    // End of variables declaration//GEN-END:variables
}

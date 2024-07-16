package forms.estudiantes;

import dialogs.CamaraDialog;
import event.EventoCerrarForm;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelos.GrupoModelo;
import modelos.EstudianteModelo;
import operaciones.OpGrupo;
import operaciones.OpAlumno;
import swim.Imagen;

public class AgregarAlumnoForm extends javax.swing.JPanel {

    private EventoCerrarForm evento;
    private OpAlumno opAlumno;
    private OpGrupo opGrupo;
    private Imagen imagen;
    private BufferedImage img;
    private String path;

    public AgregarAlumnoForm(EventoCerrarForm evento) {
        initComponents();
        this.evento = evento;
        opGrupo = new OpGrupo();
        init();

    }

    private void init() {
        imagen = new Imagen();
        InputStream input = this.getClass().getResourceAsStream("/icon/fotografia.png");
        Image iconoBack = imagen.toImageResizable(input, 40, 40);
        btnCamara.setIcon(new ImageIcon(iconoBack));

        input = this.getClass().getResourceAsStream("/icon/carpeta.png");
        iconoBack = imagen.toImageResizable(input, 40, 40);
        btnArchivos.setIcon(new ImageIcon(iconoBack));
        ArrayList<GrupoModelo> allGrupos = opGrupo.getGrupos();
        allGrupos.forEach((grupo) -> {
            comboGrupo.addItem(grupo);
        });
    }

    public void addEvento(EventoCerrarForm evento) {
        this.evento = evento;
    }

    public boolean esValido() {

        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Nombre");
            return false;
        }
        if (txtApPat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Apellido Paterno");
            return false;
        }
        if (txtMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la Matricula");
            return false;
        }
        if (txtApMat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese  el Apellido Materno");
            return false;
        }
        if (txtEscuelaProc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese  la Escuela de Procedencia");
            return false;
        }
        if (!esValidoCorreo(txtCorreoPer.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese  el Correo Personal");
            return false;
        }
        if (!esValidoCorreo(txtCorreoIns.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese  correctamente el Correo Electronico Institucional");
            return false;
        }
        if (!esValidoNumero(txtCelular.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese  correctamente el numero telefonico");
            return false;
        }
        if (txtEstado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese  el Estado de Procedencia");
            return false;
        }
        if (txtMunicipio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese  el Municipo de Procedencia");
            return false;
        }
        if(comboGrupo.getSelectedIndex() <= 0){
                JOptionPane.showMessageDialog(null, "Selecciona el grupo que debe de estar el alumno");
            return false;
        }
         if(comboSexo.getSelectedIndex() <= 0){
                JOptionPane.showMessageDialog(null, "Selecciona el sexo del alumno");
            return false;
        }
        return true;
    }

    private boolean esValidoNumero(String numero) {
        String numeroRegex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(numeroRegex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }

    private boolean esValidoCorreo(String correo) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(correo);

        System.out.println(matcher.matches());
        return matcher.matches();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonRounded1 = new swim.botones.ButtonRounded();
        btnArchivos = new swim.botones.ButtonRounded();
        btnCamara = new swim.botones.ButtonRounded();
        txtFoto = new javax.swing.JLabel();
        myPanel1 = new swim.panel.MyPanel();
        txtMatricula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtApPat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtEscuelaProc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtCorreoPer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtCorreoIns = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtApMat = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtGrado = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        comboGrupo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        txtGeneracion = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();

        buttonRounded1.setBackground(new java.awt.Color(104, 108, 133));
        buttonRounded1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar alumno.png"))); // NOI18N
        buttonRounded1.setText("Agregar Alumno");
        buttonRounded1.setToolTipText("");
        buttonRounded1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded1ActionPerformed(evt);
            }
        });

        btnArchivos.setBackground(new java.awt.Color(20, 90, 95));
        btnArchivos.setForeground(new java.awt.Color(255, 255, 255));
        btnArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar alumno.png"))); // NOI18N
        btnArchivos.setToolTipText("");
        btnArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivosActionPerformed(evt);
            }
        });

        btnCamara.setBackground(new java.awt.Color(20, 90, 95));
        btnCamara.setForeground(new java.awt.Color(255, 255, 255));
        btnCamara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar alumno.png"))); // NOI18N
        btnCamara.setToolTipText("");
        btnCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamaraActionPerformed(evt);
            }
        });

        txtFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        txtFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 5));

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMatricula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApPat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Grado:");

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Generacion:");

        txtEscuelaProc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEscuelaProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEscuelaProcActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Escuela Procedencia: ");

        txtCorreoPer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCorreoPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoPerActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Correo Personal: ");

        txtCorreoIns.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCorreoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoInsActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Correo Institucional:");

        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Celular: ");

        txtCelular.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Municipio:");

        txtEstado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Estado: ");

        txtMunicipio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipioActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Status:");

        comboStatus.setEditable(true);
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Dado de Baja" }));
        comboStatus.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Matricula:");

        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Nombre:");

        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Apellido Paterno:");

        jLabel17.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Apellido Materno:");

        txtApMat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtGrado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Grupo:");

        comboGrupo.setEditable(true);
        comboGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------------" }));
        comboGrupo.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Sexo: ");

        comboSexo.setEditable(true);
        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "Hombre", "Mujer" }));
        comboSexo.setToolTipText("");

        txtGeneracion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtGeneracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel13)
                        .addGap(17, 17, 17)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                        .addGap(34, 34, 34)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16)
                                    .addComponent(txtApPat, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17)
                                    .addComponent(txtApMat, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(38, 38, 38))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(66, 66, 66)))
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEscuelaProc, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator9)
                                .addComponent(txtCorreoIns, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCelular)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMunicipio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jLabel3))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEscuelaProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorreoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(txtCorreoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 247, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCamara, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(118, 118, 118)
                        .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnCamara, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRounded1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded1ActionPerformed
        if (esValido()) {
            int option = JOptionPane.showConfirmDialog(null, "¿Estas seguro de añadir al alumno : " + txtNombre.getText() + " con matricula: " + txtMatricula.getText() + " ?");

            if (option == JOptionPane.OK_OPTION) {
                EstudianteModelo estudiante = new EstudianteModelo();

                estudiante.setMatricula(txtMatricula.getText().trim());
                estudiante.setNombre(txtNombre.getText().trim());
                estudiante.setApPaterno(txtApPat.getText().trim());
                estudiante.setApMaterno(txtApMat.getText().trim());
                estudiante.setEmailPersonal(txtCorreoPer.getText().trim());
                estudiante.setEmailInstitucional(txtCorreoIns.getText().trim());
                estudiante.setGeneracion(txtGeneracion.getText().trim());
                estudiante.setNumCelular(txtCelular.getText().trim());
                estudiante.setEstado(txtEstado.getText().trim());
                estudiante.setMunicipio(txtMunicipio.getText().trim());
                estudiante.setEscProcedencia(txtEscuelaProc.getText().trim());

                estudiante.setGrado(txtGrado.getText().trim());
                estudiante.setGrupo("0");
                estudiante.setStatus("Activo");
                estudiante.setPassword("-----");
                estudiante.setPasswordTemporal(txtMatricula.getText().trim());
                GrupoModelo grupo = (GrupoModelo) comboGrupo.getSelectedItem();
                estudiante.setGrupo(grupo.getId());
                estudiante.setSexo(comboSexo.getSelectedItem().toString());
                
             
                if (img != null) {
                    try {
                        File outputFile = new File("C:\\Guba\\Alumnos\\Fotos" + txtMatricula.getText() + ".jpg");
                        ImageIO.write(img, "jpg", outputFile);
                        estudiante.setFoto(outputFile.getPath());
                    } catch (IOException ex) {
                        Logger.getLogger(AgregarAlumnoForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                opAlumno = new OpAlumno();
                boolean agregar = opAlumno.crearAlumno(estudiante);

                if (agregar) {
                    JOptionPane.showMessageDialog(null, "Alumno Correctamente Agregado");
                    evento.cerrarForm();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar");
                }

            }
        }

    }//GEN-LAST:event_buttonRounded1ActionPerformed

    private void btnArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivosActionPerformed
        if (!txtMatricula.getText().isEmpty()) {
            JFileChooser fotoChooser = new JFileChooser();

            FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                    "Imagen jpg",  "jpg");
            fotoChooser.setFileFilter(filtro);

            int returnVal = fotoChooser.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fotoChooser.getSelectedFile();

                txtFoto.setIcon(null);
                txtFoto.setText("Cargando foto espere porfavor....");
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        ImageIcon foto = new ImageIcon(file.getPath());
                        Icon iconoBack = new ImageIcon(foto.getImage().getScaledInstance(txtFoto.getWidth(), txtFoto.getHeight(), Image.SCALE_SMOOTH));
                        txtFoto.setIcon(iconoBack);

                        try {
                            //       BufferedImage bufferedImage = null;
                            img = ImageIO.read(file);
                            
                            //       ImageIO.write(bufferedImage, "jpg", outputFile);
                            //       path = outputFile.getAbsolutePath();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                };
                t.setDaemon(true);
                t.start();
                t.setUncaughtExceptionHandler((Thread t1, Throwable e) -> {
                    JOptionPane.showMessageDialog(null, "Hubo un error al insertar la foto intente de nuevo porfavor " + e.getMessage());
                });


            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes de Ingresar la matricula del alumno para tomarle la foto");
        }

    }//GEN-LAST:event_btnArchivosActionPerformed

    private void btnCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamaraActionPerformed
        if (!txtMatricula.getText().isEmpty()) {

            CamaraDialog dialogo = new CamaraDialog(null, true, txtMatricula.getText().trim());
            dialogo.setVisible(true);

            if (dialogo.getImg() != null) {

                //       BufferedImage bufferedImage = null;
                img = dialogo.getImg();
                //       ImageIO.write(bufferedImage, "jpg", outputFile);
                //       path = outputFile.getAbsolutePath();

                ImageIcon foto = new ImageIcon(img);
                Icon iconoBack = new ImageIcon(foto.getImage().getScaledInstance(txtFoto.getWidth(), txtFoto.getHeight(), Image.SCALE_SMOOTH));
                txtFoto.setIcon(iconoBack);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes de Ingresar la matricula del alumno para tomarle la foto");
        }
    }//GEN-LAST:event_btnCamaraActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEscuelaProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEscuelaProcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEscuelaProcActionPerformed

    private void txtCorreoPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoPerActionPerformed

    private void txtCorreoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoInsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoInsActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioActionPerformed

    private void txtGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradoActionPerformed

    private void txtGeneracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded btnArchivos;
    private swim.botones.ButtonRounded btnCamara;
    private swim.botones.ButtonRounded buttonRounded1;
    private javax.swing.JComboBox comboGrupo;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private swim.panel.MyPanel myPanel1;
    private javax.swing.JTextField txtApMat;
    private javax.swing.JTextField txtApPat;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreoIns;
    private javax.swing.JTextField txtCorreoPer;
    private javax.swing.JTextField txtEscuelaProc;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JTextField txtGeneracion;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

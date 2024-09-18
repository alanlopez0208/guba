package forms.estudiantes;

import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.EstudianteModelo;
import modelos.GrupoModelo;
import operaciones.Config;
import operaciones.OpCarreras;
import operaciones.OpGrupo;

public class EstudianteDatosForm extends javax.swing.JPanel {

    EstudianteModelo modelo;
    private OpGrupo opGrupo;
    private OpCarreras opCarrera;
    private Config config;

    public EstudianteDatosForm(EstudianteModelo modelo) {
        initComponents();

        opGrupo = new OpGrupo();
        opCarrera = new OpCarreras();
        config = new Config();
        this.modelo = modelo;
        init();
    }

    private void init() {
        this.txtMatricula.setText(modelo.getMatricula());
        this.txtNombre.setText(modelo.getNombre());
        this.txtApPat.setText(modelo.getApPaterno());
        this.txtApMat.setText(modelo.getApMaterno());

        this.txtGrado.setText(modelo.getGrado());

        this.txtEscuelaProc.setText(modelo.getEscProcedencia());
        this.txtCorreoInst.setText(modelo.getEmailInstitucional());
        this.txtCorreoPer.setText(modelo.getEmailPersonal());

        this.txtCelular.setText(modelo.getNumCelular());
        this.txtEstado.setText(modelo.getEstado());
        this.txtMunicipio.setText(modelo.getMunicipio());
        this.txtGeneracion.setText(modelo.getGeneracion());

        if (modelo.getFoto() != null) {

            String path = modelo.getFoto();
            ImageIcon foto = new ImageIcon(config.obtenerConfiguracion("03 RUTA IMAGENES ESTUDIANTES") + "/" + path + ".jpg");
            Icon iconoBack = new ImageIcon(foto.getImage().getScaledInstance(280, 450, Image.SCALE_SMOOTH));
            txtFoto.setIcon(iconoBack);
        }

        opCarrera.getAllCarreras().forEach((carreraModelo) -> {
            comboCarrera.addItem(carreraModelo);
        });
        comboCarrera.setSelectedItem(modelo.getCarrera());
        comboSemestre.setSelectedItem(modelo.getSemestre());

        comboStatus.setSelectedItem(modelo.getStatus());
        comboSexo.setSelectedItem(modelo.getSexo());
        txtDireccion.setText(modelo.getDireccion());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaSeleccionada = null;
        try {
            fechaSeleccionada = sdf.parse(modelo.getNacimiento());
        } catch (ParseException ex) {
            System.out.println("Error ");
        }
        nacimiento.setDate(fechaSeleccionada);
  
    }

    public boolean esCorrecto() {
        if (txtMatricula.getText().trim().isEmpty()) {
            return false;
        }
        if (txtNombre.getText().trim().isEmpty()) {
            return false;
        }
        if (txtMatricula.getText().trim().isEmpty()) {
            return false;
        }
        if (txtNombre.getText().trim().isEmpty()) {
            return false;
        }
        if (txtApPat.getText().trim().isEmpty()) {
            return false;
        }
        if (txtEscuelaProc.getText().trim().isEmpty()) {
            return false;
        }
        if (esValidoCorreo(txtCorreoPer.getText().trim())) {
            return false;
        }
        if (esValidoCorreo(txtCorreoInst.getText().trim())) {
            return false;
        }
        if (esValidoNumero(txtCelular.getText().trim())) {
            return false;
        }
        if (txtEstado.getText().trim().isEmpty()) {
            return false;
        }
        if (txtEstado.getText().trim().isEmpty()) {
            return false;
        }
        if (txtMunicipio.getText().trim().isEmpty()) {
            return false;
        }
        if (comboSemestre.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecciona el grupo que debe de estar el alumno");
            return false;
        }
        if (comboCarrera.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecciona la carrera que debe de estar el alumno");
            return false;
        }
        if (comboSexo.getSelectedIndex() <= 0) {
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
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFoto = new javax.swing.JLabel();
        myPanel1 = new swim.panel.MyPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        comboCarrera = new javax.swing.JComboBox();
        txtMatricula = new swim.text.TextField();
        txtNombre = new swim.text.TextField();
        txtApPat = new swim.text.TextField();
        txtApMat = new swim.text.TextField();
        txtGrado = new swim.text.TextField();
        txtGeneracion = new swim.text.TextField();
        txtCorreoPer = new swim.text.TextField();
        txtEscuelaProc = new swim.text.TextField();
        txtCorreoInst = new swim.text.TextField();
        txtCelular = new swim.text.TextField();
        txtEstado = new swim.text.TextField();
        txtMunicipio = new swim.text.TextField();
        jLabel19 = new javax.swing.JLabel();
        txtDireccion = new swim.text.TextField();
        jLabel20 = new javax.swing.JLabel();
        nacimiento = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        comboSemestre = new javax.swing.JComboBox<>();

        txtFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        txtFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 5));

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Último Grado de Estudios:");

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Generacion:");

        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Escuela Procedencia: ");

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Correo Personal: ");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Correo Institucional:");

        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Celular: ");

        jLabel11.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Municipio:");

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Estado: ");

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Status:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Baja", "Baja Temporal" }));
        comboStatus.setToolTipText("");
        comboStatus.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Matricula:");

        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Nombre:");

        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Apellido Paterno:");

        jLabel17.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Apellido Materno:");

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Sexo: ");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "Hombre", "Mujer" }));
        comboSexo.setToolTipText("");
        comboSexo.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Carrera:");

        comboCarrera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------------" }));
        comboCarrera.setToolTipText("");
        comboCarrera.setEnabled(false);

        txtMatricula.setEditable(false);
        txtMatricula.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtApPat.setEditable(false);
        txtApPat.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtApMat.setEditable(false);
        txtApMat.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtGrado.setEditable(false);
        txtGrado.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtGeneracion.setEditable(false);
        txtGeneracion.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtCorreoPer.setEditable(false);
        txtCorreoPer.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtEscuelaProc.setEditable(false);
        txtEscuelaProc.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtCorreoInst.setEditable(false);
        txtCorreoInst.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtCelular.setEditable(false);
        txtCelular.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtMunicipio.setEditable(false);
        txtMunicipio.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Direccion:");

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Nacimiento:");

        jLabel21.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Semestre:");

        comboSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        comboSemestre.setToolTipText("");
        comboSemestre.setEnabled(false);

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
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(37, 37, 37)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(33, 33, 33)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel20))
                        .addGap(140, 140, 140)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGeneracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreoPer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEscuelaProc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreoInst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(37, 37, 37)
                        .addComponent(comboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(253, 253, 253)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(502, 502, 502))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(comboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(comboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEscuelaProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorreoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCorreoInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCarrera;
    private javax.swing.JComboBox<String> comboSemestre;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private swim.panel.MyPanel myPanel1;
    private com.toedter.calendar.JDateChooser nacimiento;
    private swim.text.TextField txtApMat;
    private swim.text.TextField txtApPat;
    private swim.text.TextField txtCelular;
    private swim.text.TextField txtCorreoInst;
    private swim.text.TextField txtCorreoPer;
    private swim.text.TextField txtDireccion;
    private swim.text.TextField txtEscuelaProc;
    private swim.text.TextField txtEstado;
    private javax.swing.JLabel txtFoto;
    private swim.text.TextField txtGeneracion;
    private swim.text.TextField txtGrado;
    private swim.text.TextField txtMatricula;
    private swim.text.TextField txtMunicipio;
    private swim.text.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

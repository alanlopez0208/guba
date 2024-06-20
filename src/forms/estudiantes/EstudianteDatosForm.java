package forms.estudiantes;

import java.awt.Image;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.EstudianteModelo;
import modelos.GrupoModelo;
import operaciones.OpGrupo;

public class EstudianteDatosForm extends javax.swing.JPanel {

    EstudianteModelo modelo;
    private OpGrupo opGrupo;

    public EstudianteDatosForm(EstudianteModelo modelo) {
        initComponents();
        comboGeneracion.setEnabled(false);
        opGrupo = new OpGrupo();
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
        this.txtCorreoIns.setText(modelo.getEmailInstitucional());
        this.txtCorreoPer.setText(modelo.getEmailPersonal());

        this.txtCelular.setText(modelo.getNumCelular());
        this.txtEstado.setText(modelo.getEstado());
        this.txtMunicipio.setText(modelo.getMunicipio());

        if (modelo.getFoto() != null) {

            String path = modelo.getFoto();
            ImageIcon foto = new ImageIcon(path);
            Icon iconoBack = new ImageIcon(foto.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH));
            txtFoto.setIcon(iconoBack);
        }

      
        ArrayList<GrupoModelo> allGrupos = opGrupo.getGrupos();
        allGrupos.forEach((grupo) -> {
            comboGrupo.addItem(grupo);
        });
        
        GrupoModelo grupo = opGrupo.seleccionarGrupo(Integer.parseInt(modelo.getGrupo()));
        System.out.println(grupo);
        comboGrupo.setSelectedItem(grupo);
        
        comboStatus.setSelectedItem(modelo.getStatus());
        comboSexo.setSelectedItem(modelo.getSexo());
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
        if (esValidoCorreo(txtCorreoIns.getText().trim())) {
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
        if (comboGrupo.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecciona el grupo que debe de estar el alumno");
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

        myPanel1 = new swim.panel.MyPanel();
        txtMatricula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtApPat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboGeneracion = new javax.swing.JComboBox<>();
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
        txtFoto = new javax.swing.JLabel();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMatricula.setEditable(false);
        txtMatricula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApPat.setEditable(false);
        txtApPat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Grado:");

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Generacion:");

        comboGeneracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        comboGeneracion.setToolTipText("");

        txtEscuelaProc.setEditable(false);
        txtEscuelaProc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEscuelaProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEscuelaProcActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Escuela Procedencia: ");

        txtCorreoPer.setEditable(false);
        txtCorreoPer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCorreoPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoPerActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Correo Personal: ");

        txtCorreoIns.setEditable(false);
        txtCorreoIns.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCorreoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoInsActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Correo Insitutcional: ");

        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Celular: ");

        txtCelular.setEditable(false);
        txtCelular.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Municipio:");

        txtEstado.setEditable(false);
        txtEstado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Estado: ");

        txtMunicipio.setEditable(false);
        txtMunicipio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipioActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Status:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Dado de Baja" }));
        comboStatus.setToolTipText("");
        comboStatus.setEnabled(false);

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

        txtApMat.setEditable(false);
        txtApMat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtGrado.setEditable(false);
        txtGrado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Grupo:");

        comboGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------------" }));
        comboGrupo.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Sexo: ");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "Hombre", "Mujer" }));
        comboSexo.setToolTipText("");
        comboSexo.setEnabled(false);

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(jSeparator1))
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jSeparator2))
                                .addGap(191, 191, 191)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtApMat)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtApPat)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(109, 109, 109)
                                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEscuelaProc, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCorreoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCorreoIns, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(myPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator5)
                                        .addComponent(txtGrado, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                    .addGap(422, 422, 422))))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMunicipio)
                                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(27, 27, 27)
                                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(31, 31, 31))))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(myPanel1Layout.createSequentialGroup()
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(myPanel1Layout.createSequentialGroup()
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(myPanel1Layout.createSequentialGroup()
                                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(myPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEscuelaProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCorreoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(145, 145, 145)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        txtFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboGeneracion;
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
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

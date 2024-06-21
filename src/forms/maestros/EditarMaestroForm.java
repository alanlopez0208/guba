package forms.maestros;

import dialogs.CamaraDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import event.EventoCerrarForm;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelos.MaestroModelo;
import operaciones.OpMaestro;
import swim.Imagen;

public class EditarMaestroForm extends javax.swing.JPanel {

    private MaestroModelo modelo;
    private EventoCerrarForm evento;
    private OpMaestro opMaestro;
    private BufferedImage img;
    private Imagen imagen;
    private File pdf;

    public EditarMaestroForm(MaestroModelo modelo) {
        initComponents();
        this.modelo = modelo;
        init();
    }

    private void init() {
        opMaestro = new OpMaestro();
        this.txtRfc.setText(modelo.getRfc());
        this.txtNombre.setText(modelo.getNombre());
        this.txtApPat.setText(modelo.getApPat());
        this.txtApMat.setText(modelo.getApMat());

        this.txtGrado.setText(modelo.getGrado());
        this.txtDomicilio.setText(modelo.getDomicilio());
        this.txtCurp.setText(modelo.getCurp());
        this.txtCorreoIns.setText(modelo.getCorreoIns());
        this.txtCorreoPer.setText(modelo.getCorreoPer());

        this.txtCelular.setText(modelo.getCelular());
        this.txtEstado.setText(modelo.getEstado());
        this.txtMunicipio.setText(modelo.getMunicipio());

        if (modelo.getFoto() != null) {

            String path = modelo.getFoto();

            ImageIcon foto = new ImageIcon(path);

            Icon iconoBack = new ImageIcon(foto.getImage().getScaledInstance(200, 200, Image.SCALE_REPLICATE));
            txtFoto.setIcon(iconoBack);
        }

        imagen = new Imagen();
        InputStream input = this.getClass().getResourceAsStream("/icon/fotografia.png");
        Image iconoBack = imagen.toImageResizable(input, 40, 40);
        btnCamara.setIcon(new ImageIcon(iconoBack));

        input = this.getClass().getResourceAsStream("/icon/carpeta.png");
        iconoBack = imagen.toImageResizable(input, 40, 40);
        btnArchivos.setIcon(new ImageIcon(iconoBack));
        comboSexo.setSelectedItem(modelo.getGenero());
    }

    public boolean esValido() {
        if (txtRfc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el RFC");
            return false;
        }
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Nombre");
            return false;
        }

        if (txtApMat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Apellido Materno");
            return false;
        }
        if (txtApPat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Apellido Paterno");
            return false;
        }
        if (txtDomicilio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Domicilio");
            return false;
        }
        if (txtCurp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la CURP");
            return false;
        }
        if (!esValidoCorreo(txtCorreoPer.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo personal valido");
            return false;
        }
        if (!esValidoCorreo(txtCorreoIns.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo institucional valido");
            return false;
        }
        if (!esValidoNumero(txtCelular.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese su numero telefonico");
            return false;
        }
        if (txtEstado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Estado");
            return false;
        }
        if (txtGrado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el grado de estudios");
            return false;
        }
        if (txtMunicipio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Municipio");
            return false;
        }
        if (comboSexo.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecciona el sexo del maestro");
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

        myPanel1 = new swim.panel.MyPanel();
        txtRfc = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtApPat = new javax.swing.JTextField();
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
        txtApMat = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtCv = new javax.swing.JTextField();
        buscarCv = new swim.botones.ButtonRounded();
        jLabel18 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        txtCurp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        buttonRounded1 = new swim.botones.ButtonRounded();
        Editar = new swim.botones.ButtonRounded();
        txtFoto = new javax.swing.JLabel();
        btnCamara = new swim.botones.ButtonRounded();
        btnArchivos = new swim.botones.ButtonRounded();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtRfc.setEditable(false);
        txtRfc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRfcActionPerformed(evt);
            }
        });

        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApPat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
        jLabel9.setText("Correo Insitutcional: ");

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

        txtApMat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("RFC:");

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Nombre:");

        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Apellido Paterno:");

        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Apellido Materno:");

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Grado:");

        txtGrado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Sexo:");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------", "Hombre", "Mujer" }));
        comboSexo.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("C.V:");

        txtCv.setEditable(false);

        buscarCv.setBackground(new java.awt.Color(0, 51, 51));
        buscarCv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/14.png"))); // NOI18N
        buscarCv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCvActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("CURP:");

        txtCurp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurpActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Domicilio:");

        txtDomicilio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarCv, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(myPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorreoIns, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorreoPer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(myPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(109, 109, 109)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)))
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtRfc, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addComponent(jSeparator2))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtApPat)
                            .addComponent(jSeparator3))
                        .addGap(18, 18, 18)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtApMat, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addComponent(jSeparator4)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(3, 3, 3)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscarCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorreoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        buttonRounded1.setBackground(new java.awt.Color(255, 204, 204));
        buttonRounded1.setForeground(new java.awt.Color(51, 51, 51));
        buttonRounded1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        buttonRounded1.setText("Cancelar");
        buttonRounded1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded1ActionPerformed(evt);
            }
        });

        Editar.setBackground(new java.awt.Color(255, 255, 153));
        Editar.setForeground(new java.awt.Color(51, 51, 51));
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        txtFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N

        btnCamara.setBackground(new java.awt.Color(20, 90, 95));
        btnCamara.setForeground(new java.awt.Color(255, 255, 255));
        btnCamara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar alumno.png"))); // NOI18N
        btnCamara.setToolTipText("");
        btnCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamaraActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCamara, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnArchivos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCamara, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRounded1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded1ActionPerformed
        this.evento.cerrarForm();
    }//GEN-LAST:event_buttonRounded1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        if (esValido()) {
            int option = JOptionPane.showConfirmDialog(null, "¿Estas seguro de actualizar al alumno : " + txtNombre.getText() + " con matricula: " + txtRfc.getText() + " ?");

            if (option == JOptionPane.OK_OPTION) {

                modelo.setRfc(txtRfc.getText().trim());
                modelo.setNombre(txtNombre.getText().trim());
                modelo.setApPat(txtApPat.getText().trim());
                modelo.setApMat(txtApMat.getText().trim());
                modelo.setCorreoPer(txtCorreoPer.getText().trim());
                modelo.setCorreoIns(txtCorreoIns.getText().trim());
                modelo.setCv("------");
                modelo.setCelular(txtCelular.getText().trim());
                modelo.setEstado(txtEstado.getText().trim());
                modelo.setMunicipio(txtMunicipio.getText().trim());
                modelo.setDomicilio(txtDomicilio.getText().trim());
                modelo.setCurp(txtCurp.getText().trim());
                modelo.setGrado(txtGrado.getText().trim());
                modelo.setPasswordTemp(txtRfc.getText().trim());
                modelo.setGenero(comboSexo.getSelectedItem().toString());
                if (img != null) {
                    try {
                        File outputFile = new File("C:\\Guba\\" + txtRfc.getText() + ".jpg");
                        ImageIO.write(img, "jpg", outputFile);
                        modelo.setFoto(outputFile.getPath());

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al querer insertar Imagen: " + ex.getMessage());
                    }
                }
                if (pdf != null) {
                    String destino = "C:\\Guba\\CV\\" + pdf.getName();
                    Path pathDestino = Paths.get(destino);

                    String origen = pdf.getPath();
                    Path pathOrigen = Paths.get(origen);
                    
                    
                    
                    modelo.setCv(destino);

                    try {
                        Files.copy(pathOrigen, pathDestino);
                    } catch (IOException ex) {
                        Logger.getLogger(AgregarMaestroForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                boolean agregar = opMaestro.updateDocente(modelo);
                if (agregar) {
                    JOptionPane.showMessageDialog(null, "Docente Correctamente Actualizado");
                    evento.cerrarForm();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar");
                }
            }
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void buscarCvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCvActionPerformed
        // TODO add your handling code here:

        JFileChooser cvChooser = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "PDF", "pdf");
        cvChooser.setFileFilter(filtro);

        int returnVal = cvChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            txtCv.setText(cvChooser.getSelectedFile().getName());
            pdf = cvChooser.getSelectedFile();
        }
    }//GEN-LAST:event_buscarCvActionPerformed

    private void txtGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradoActionPerformed

    private void txtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCorreoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoInsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoInsActionPerformed

    private void txtCorreoPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoPerActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRfcActionPerformed

    private void txtCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurpActionPerformed

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed

    private void btnCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamaraActionPerformed
        if (!txtRfc.getText().isEmpty()) {

            CamaraDialog dialogo = new CamaraDialog(null, true, txtRfc.getText().trim());
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
            JOptionPane.showMessageDialog(null, "Debes de Ingresar el RFC del docente para tomarle la foto");
        }
    }//GEN-LAST:event_btnCamaraActionPerformed

    private void btnArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivosActionPerformed
        if (!txtRfc.getText().isEmpty()) {
            JFileChooser fotoChooser = new JFileChooser();

            FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                    "Imagen jpg", "jpg");
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

    public void addEvento(EventoCerrarForm evento) {
        this.evento = evento;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded Editar;
    private swim.botones.ButtonRounded btnArchivos;
    private swim.botones.ButtonRounded btnCamara;
    private swim.botones.ButtonRounded buscarCv;
    private swim.botones.ButtonRounded buttonRounded1;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
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
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtCv;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}

package forms.grupos;

import event.EventoCerrarForm;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.InputStream;
import javax.swing.ImageIcon;
import modelos.GrupoModelo;
import operaciones.OpGrupo;
import operaciones.OpMaterias;
import swim.Imagen;

public class VerGrupo extends javax.swing.JPanel {

    private EventoCerrarForm eventoCerrar;
    private Imagen imagen;
    private final GrupoModelo grupoModelo;
    private final OpGrupo opGrupo;
    private final OpMaterias opMaterias;
    private MateriasGruposForm materiasGruposForm;
    private AlumnosGruposForm alumnosGruposForm;
    private Color colorSelected = new Color(20, 90, 95);
    private Color colorUnselected = new Color(104, 108, 133);

    public VerGrupo(GrupoModelo grupoModelo) {
        initComponents();
        this.grupoModelo = grupoModelo;
        opGrupo = new OpGrupo();
        opMaterias = new OpMaterias();
        materiasGruposForm = new MateriasGruposForm(this.grupoModelo);

        init();

    }

    private void init() {
        imagen = new Imagen();
        InputStream input = this.getClass().getResourceAsStream("/icon/back.png");
        Image iconoBack = imagen.toImageResizable(input, 40, 40);
        btnCerrar.setIcon(new ImageIcon(iconoBack));

        txtGrupo.setText(grupoModelo.getNombre());
        txtSemestre.setText(grupoModelo.getSemestre());
        comboCarrera.addItem(grupoModelo.getCarrera());

        panelCambio.add(materiasGruposForm);
    }

    public void addEventoCerrar(EventoCerrarForm eventoCerrar) {
        this.eventoCerrar = eventoCerrar;
    }

    public void showForm(Component form) {
        panelCambio.removeAll();
        panelCambio.add(form);
        panelCambio.repaint();
        panelCambio.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        panelCambio = new javax.swing.JPanel();
        btnMaterias = new swim.botones.ButtonRounded();
        btnAlumnos = new swim.botones.ButtonRounded();
        jLabel5 = new javax.swing.JLabel();
        comboCarrera = new javax.swing.JComboBox();
        txtSemestre = new swim.text.TextField();
        txtGrupo = new swim.text.TextField();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Semestre: ");

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Grupo:");

        btnCerrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        panelCambio.setBackground(new java.awt.Color(255, 255, 255));
        panelCambio.setLayout(new java.awt.BorderLayout());

        btnMaterias.setBackground(new java.awt.Color(0, 102, 102));
        btnMaterias.setForeground(new java.awt.Color(255, 255, 255));
        btnMaterias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9.png"))); // NOI18N
        btnMaterias.setText("Ver materias");
        btnMaterias.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriasActionPerformed(evt);
            }
        });

        btnAlumnos.setBackground(new java.awt.Color(104, 108, 133));
        btnAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/5.png"))); // NOI18N
        btnAlumnos.setText("Ver alumnos");
        btnAlumnos.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Carrera:");

        comboCarrera.setEnabled(false);

        txtSemestre.setEditable(false);

        txtGrupo.setEditable(false);

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelCambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, myPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(502, 502, 502)
                                .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 616, Short.MAX_VALUE))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(comboCarrera, 0, 352, Short.MAX_VALUE)
                                .addGap(601, 601, 601)))))
                .addContainerGap())
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnCerrar)
                .addGap(17, 17, 17)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(comboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        this.eventoCerrar.cerrarForm();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        // TODO add your handling code here:
        btnMaterias.setBackground(this.colorUnselected);
        btnAlumnos.setBackground(this.colorSelected);
        alumnosGruposForm = new AlumnosGruposForm(this.grupoModelo);
        showForm(this.alumnosGruposForm);

    }//GEN-LAST:event_btnAlumnosActionPerformed


    private void btnMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriasActionPerformed
        btnMaterias.setBackground(this.colorSelected);
        btnAlumnos.setBackground(this.colorUnselected);
        showForm(this.materiasGruposForm);
    }//GEN-LAST:event_btnMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded btnAlumnos;
    private javax.swing.JButton btnCerrar;
    private swim.botones.ButtonRounded btnMaterias;
    private javax.swing.JComboBox comboCarrera;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private swim.panel.MyPanel myPanel1;
    private javax.swing.JPanel panelCambio;
    private swim.text.TextField txtGrupo;
    private swim.text.TextField txtSemestre;
    // End of variables declaration//GEN-END:variables
}

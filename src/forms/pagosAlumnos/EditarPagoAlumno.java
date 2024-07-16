package forms.pagosAlumnos;

import forms.carreras.*;
import event.EventoCerrarForm;
import java.awt.Image;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.EstudianteModelo;
import modelos.PagoAlumnosModelo;
import operaciones.OpAlumno;
import operaciones.OpPagoAlumnos;
import swim.Imagen;

public class EditarPagoAlumno extends javax.swing.JPanel {

    private EventoCerrarForm eventoCerrar;
    private Imagen imagen;
    private OpPagoAlumnos opPago;
    private OpAlumno opAlumno;
    private PagoAlumnosModelo modelo;

    public EditarPagoAlumno(PagoAlumnosModelo modelo) {
        initComponents();
        this.modelo = modelo;
        opPago = new OpPagoAlumnos();
        opAlumno = new OpAlumno();

        init();
    }

    private void init() {

        imagen = new Imagen();
        InputStream input = this.getClass().getResourceAsStream("/icon/guardar.png");
        Image icono = imagen.toImageResizable(input, 20, 20);
        btnGuardar.setIcon(new ImageIcon(icono));
        input = this.getClass().getResourceAsStream("/icon/back.png");
        Image iconoBack = imagen.toImageResizable(input, 40, 40);
        btnBack.setIcon(new ImageIcon(iconoBack));

        ArrayList<EstudianteModelo> alumnos = opAlumno.getEstudiantes();

        alumnos.forEach((alumno) -> {
            comboAlumno.addItem(alumno);
        });

        comboAlumno.setSelectedItem((EstudianteModelo) modelo.getEstudiante());

        txtCantidad.setText(modelo.getCantidad());
        txtConcepto.setText(modelo.getConcepto());
        txtFactura.setText(modelo.getFactura());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaSeleccionada = null;
        try {
            fechaSeleccionada = sdf.parse(modelo.getFecha());
        } catch (ParseException ex) {
            Logger.getLogger(EditarPagoAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecha.setDate(fechaSeleccionada);

    }

    public void addEventoCerrar(EventoCerrarForm eventoCerrar) {
        this.eventoCerrar = eventoCerrar;
    }

    private boolean esValido() {

        if (txtConcepto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el concepto");
            return false;
        }
        if (!esValidoNumero(txtCantidad.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese correctamente la cantidad");
            return false;
        }
        if (comboAlumno.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese correctamente un Alumno");
            return false;
        }
        if (fecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha");
            return false;
        }

        return true;
    }

    private boolean esValidoNumero(String numero) {
        String numeroRegex = "^[0-9]+(?:\\.[0-9]*)?$";

        Pattern pattern = Pattern.compile(numeroRegex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        btnBack = new javax.swing.JButton();
        btnGuardar = new swim.botones.ButtonRounded();
        jSeparator8 = new javax.swing.JSeparator();
        txtFactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtConcepto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        comboAlumno = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(20, 90, 95));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Actualizar Pago");
        btnGuardar.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jSeparator8.setVerifyInputWhenFocusTarget(false);

        txtFactura.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Factura: ");

        jSeparator7.setVerifyInputWhenFocusTarget(false);

        txtConcepto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConceptoActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Concepto :");

        jSeparator5.setVerifyInputWhenFocusTarget(false);

        txtCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Cantidad:");

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fecha:");

        comboAlumno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------------" }));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Alumno:");

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("$");

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtConcepto)
                    .addComponent(jSeparator7)
                    .addComponent(jLabel8)
                    .addComponent(txtCantidad)
                    .addComponent(jSeparator5)
                    .addComponent(jLabel5)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFactura)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1347, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (esValido()) {
            int option = JOptionPane.showConfirmDialog(null, "¿Estas seguro de agregar el pago : ?");

            if (option == JOptionPane.OK_OPTION) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = sdf.format(fecha.getDate());

                modelo.setFecha(fechaFormateada);

                EstudianteModelo estudiante = (EstudianteModelo) comboAlumno.getSelectedItem();
                modelo.setIdAlumno(estudiante.getMatricula());
                modelo.setCantidad(txtCantidad.getText().trim());
                modelo.setConcepto(txtConcepto.getText().trim());
                modelo.setFactura(txtFactura.getText().trim());

                boolean estaAgregado = opPago.updatePago(modelo);

                if (estaAgregado) {
                    JOptionPane.showMessageDialog(null, "Pago actualizado");

                    this.eventoCerrar.cerrarForm();
                    return;
                }
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.eventoCerrar.cerrarForm();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void txtConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConceptoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private swim.botones.ButtonRounded btnGuardar;
    private javax.swing.JComboBox comboAlumno;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private swim.panel.MyPanel myPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtFactura;
    // End of variables declaration//GEN-END:variables
}

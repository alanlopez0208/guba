package forms.pagosAlumnos;

import event.EventoCerrarForm;
import java.awt.Image;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.EstudianteModelo;
import modelos.PagoAlumnosModelo;
import operaciones.OpAlumno;
import operaciones.OpPagoAlumnos;
import swim.Imagen;

public class AgregarPagoAlumno extends javax.swing.JPanel {

    private EventoCerrarForm eventoCerrar;
    private Imagen imagen;
    private OpPagoAlumnos opPago;
    private OpAlumno opAlumno;

    public AgregarPagoAlumno() {
        initComponents();
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

        fecha.setDateFormatString("MM/dd/yyyy");

    }

    private boolean esValido() {

        if (txtConcepto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el concepto");
            return false;
        }
          if (txtFactura.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la factura");
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
        if(fecha.getDate() == null){
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

    public void addEventoCerrar(EventoCerrarForm eventoCerrar) {
        this.eventoCerrar = eventoCerrar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        btnGuardar = new swim.botones.ButtonRounded();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        fecha = new com.toedter.calendar.JDateChooser();
        comboAlumno = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardar.setBackground(new java.awt.Color(20, 90, 95));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Agregar Pago");
        btnGuardar.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBack.setToolTipText("");
        btnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Alumno:");

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fecha:");

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Cantidad:");

        txtCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jSeparator5.setVerifyInputWhenFocusTarget(false);

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Concepto :");

        txtConcepto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConceptoActionPerformed(evt);
            }
        });

        jSeparator7.setVerifyInputWhenFocusTarget(false);

        comboAlumno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------------" }));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Factura: ");

        txtFactura.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });

        jSeparator8.setVerifyInputWhenFocusTarget(false);

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("$");

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1468, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
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
                    .addComponent(comboAlumno, 0, 283, Short.MAX_VALUE)
                    .addComponent(txtFactura)
                    .addComponent(jSeparator8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
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
                .addContainerGap(345, Short.MAX_VALUE))
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        this.eventoCerrar.cerrarForm();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (esValido()) {
            int option = JOptionPane.showConfirmDialog(null, "¿Estas seguro de agregar el pago ?");

            if (option == JOptionPane.OK_OPTION) {
                PagoAlumnosModelo modelo = new PagoAlumnosModelo();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = sdf.format(fecha.getDate());
                
                
                modelo.setFecha(fechaFormateada);

                EstudianteModelo estudiante = (EstudianteModelo) comboAlumno.getSelectedItem();
                modelo.setIdAlumno(estudiante.getMatricula());
                modelo.setCantidad(txtCantidad.getText().trim());
                modelo.setConcepto(txtConcepto.getText().trim());
                modelo.setFactura(txtFactura.getText().trim());

                boolean estaAgregado = opPago.crearPago(modelo);

                if (estaAgregado) {
                    JOptionPane.showMessageDialog(null, "Pago Agregado Correctamente");

                    this.eventoCerrar.cerrarForm();
                    return;
                }
                JOptionPane.showMessageDialog(null, "No se pudo Agregar");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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

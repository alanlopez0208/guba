package forms.configuraciones;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.Periodo;
import operaciones.OpPeriodo;

public class ConfiguracionesForm extends javax.swing.JPanel {
    
    private OpPeriodo opPeriodo;

    public ConfiguracionesForm() {
        initComponents();
        init();
    }

    public void init() {
        opPeriodo = new OpPeriodo();
        Periodo periodo = opPeriodo.getUltimoPeriodo();
        txtNombre.setText(periodo.getNombre());
        txtInicio.setText(periodo.getInicio());
        txtFin.setText(periodo.getFin());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        buttonRounded1 = new swim.botones.ButtonRounded();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new swim.text.TextField();
        txtFin = new swim.text.TextField();
        txtInicio = new swim.text.TextField();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Nombre del Ciclo;");

        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Inicio del Ciclo;");

        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Fin del Ciclo;");

        buttonRounded1.setBackground(new java.awt.Color(0, 102, 102));
        buttonRounded1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        buttonRounded1.setText("Cambiar Ciclo");
        buttonRounded1.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        buttonRounded1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ciclo Escolar");

        txtNombre.setEditable(false);

        txtFin.setEditable(false);

        txtInicio.setEditable(false);

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(myPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, myPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(myPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(myPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(myPanel1Layout.createSequentialGroup()
                                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel14))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(1141, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRounded1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded1ActionPerformed

        JTextField txtNombre = new JTextField();
        JTextField txtInicio = new JTextField();
        JTextField txtFin = new JTextField();

        Object[] message = {
            "Ingrese el Nombre del Ciclo:", txtNombre,
            "Ingrese el Inicio del Ciclo:", txtInicio,
            "Ingrese el Fin de vacaciones:", txtFin
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ingresa los datos", JOptionPane.OK_CANCEL_OPTION);
        
        
       if (option == JOptionPane.OK_OPTION) {
           if(txtNombre.getText().length() > 0 && txtInicio.getText().length() > 0 && txtFin.getText().length() > 0  ){
               Periodo periodo = new Periodo();
               periodo.setNombre(txtNombre.getText().trim());
               periodo.setInicio(txtInicio.getText().trim());
               periodo.setFin(txtFin.getText().trim());
               boolean seCambioPerido = opPeriodo.crearPeriodo(periodo);
               if(seCambioPerido){
                     JOptionPane.showMessageDialog(null, "Se ha Cambio de Ciclo");
                     init();
               }else{
                      JOptionPane.showMessageDialog(null, "Hubo un error al cambiar de Ciclo");
               }
               
           }
       }
    }//GEN-LAST:event_buttonRounded1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded buttonRounded1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private swim.panel.MyPanel myPanel1;
    private swim.text.TextField txtFin;
    private swim.text.TextField txtInicio;
    private swim.text.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

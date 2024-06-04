package swim.tabla;

public class AccionColumna extends javax.swing.JPanel {

    private AccionModelo accionModelo;

    public AccionColumna(AccionModelo accionModelo) {
        initComponents();
        this.accionModelo = accionModelo;
        init();
    }

    private void init() {
        btn1.setContentAreaFilled(false);
        btn2.setContentAreaFilled(false);
         btn3.setContentAreaFilled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eliminar.png"))); // NOI18N
        btn3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ver.png"))); // NOI18N
        btn1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        btn2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn1)
                .addGap(26, 26, 26)
                .addComponent(btn2)
                .addGap(18, 18, 18)
                .addComponent(btn3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn2)
                    .addComponent(btn1)
                    .addComponent(btn3))
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
         this.accionModelo.getAccion().borrar(this.accionModelo.getModelo());
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        this.accionModelo.getAccion().ver(this.accionModelo.getModelo());
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
          this.accionModelo.getAccion().editar(this.accionModelo.getModelo());
    }//GEN-LAST:event_btn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    // End of variables declaration//GEN-END:variables
}

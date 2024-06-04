package componentes;

import event.EventButtonsHeader;
import event.EventoCerrarForm;
import java.awt.Color;

public class ButtonsHeader extends javax.swing.JPanel {

    private Color colorSelected = new Color(20, 90, 95);
    private Color colorUnselected = new Color(104, 108, 133);
    EventButtonsHeader eventButtonsHeader;
    EventoCerrarForm eventoCerrar;

    public ButtonsHeader() {
        initComponents();
        buttonBack.setContentAreaFilled(false);
        buttonBack.setBackground(new Color(0, 0, 0, 0));
    }

    public void addEventButtonsHeader(EventButtonsHeader eventButtonsHeader) {
        this.eventButtonsHeader = eventButtonsHeader;
    }

    public void addEventoCerrar(EventoCerrarForm eventoCerrar) {
        System.out.println("Hola soy la cabecera");
        this.eventoCerrar = eventoCerrar;
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new swim.botones.ButtonRounded();
        btn2 = new swim.botones.ButtonRounded();
        btn3 = new swim.botones.ButtonRounded();
        buttonBack = new javax.swing.JButton();

        setOpaque(false);

        btn1.setBackground(new java.awt.Color(20, 90, 95));
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("Generales");
        btn1.setToolTipText("Genrales");
        btn1.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 14)); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(104, 108, 133));
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("Calificaciones");
        btn2.setToolTipText("Genrales");
        btn2.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 14)); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(104, 108, 133));
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("Adicionales");
        btn3.setToolTipText("Genrales");
        btn3.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 14)); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        buttonBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonBack.setOpaque(true);
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(buttonBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBack))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        btn3.setBackground(this.colorSelected);
        btn2.setBackground(this.colorUnselected);
        btn1.setBackground(this.colorUnselected);
        eventButtonsHeader.onSelectButton(2);

    }//GEN-LAST:event_btn3ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        btn1.setBackground(this.colorSelected);
        btn2.setBackground(this.colorUnselected);
        btn3.setBackground(this.colorUnselected);
        eventButtonsHeader.onSelectButton(0);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        btn2.setBackground(this.colorSelected);
        btn3.setBackground(this.colorUnselected);
        btn1.setBackground(this.colorUnselected);
        eventButtonsHeader.onSelectButton(1);
    }//GEN-LAST:event_btn2ActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
      this.eventoCerrar.cerrarForm();
    }//GEN-LAST:event_buttonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded btn1;
    private swim.botones.ButtonRounded btn2;
    private swim.botones.ButtonRounded btn3;
    private javax.swing.JButton buttonBack;
    // End of variables declaration//GEN-END:variables
}

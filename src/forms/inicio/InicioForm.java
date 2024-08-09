
package forms.inicio;

import swim.text.CustomTextField;


public class InicioForm extends javax.swing.JPanel {

   
    public InicioForm() {
        initComponents();
        init();
        
    }
    
    public void init(){
      CustomTextField imagen = new CustomTextField("src\\icon\\fondo.jpg");
      this.add(imagen);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

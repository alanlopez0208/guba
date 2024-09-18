package forms.maestros;

import componentes.ButtonsHeader;
import event.EventButtonsHeader;
import event.EventoCerrarForm;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import modelos.MaestroModelo;
import net.miginfocom.swing.MigLayout;

public class MaestroForm extends javax.swing.JPanel {

    MaestroModelo modelo;
    MigLayout layout;
    MaestroDatosForm maestroDatos;
    ButtonsHeader header;
    EventButtonsHeader eventButtonsHeader;
    EventoCerrarForm eventoCerrar;

    public MaestroForm(MaestroModelo modelo, EventoCerrarForm eventoCerrar) {
        this.eventoCerrar = eventoCerrar;
        initComponents();
        this.modelo = modelo;
        init();
    }

    private void init() {
        layout = new MigLayout("fill");
        this.setLayout(layout);

        header = new ButtonsHeader();
        header.getBtn2().setVisible(false);
        JPanel menu = new JPanel();
        menu.setOpaque(false);
        menu.setLayout(new BorderLayout());
      
        maestroDatos = new MaestroDatosForm(modelo);

        eventButtonsHeader = new EventButtonsHeader() {
            @Override
            public void onSelectButton(int index) {
                switch (index) {
                    case 0:
                        showForm(maestroDatos);
                        break;
                    case 1:
                        showForm(new MateriasForm(modelo));
                        break;
                    case 2:
                        showForm(new AdicionalesForm(modelo));
                        break;
                    default:
                        break;
                }

            }
        };

        header.addEventButtonsHeader(eventButtonsHeader);
        header.addEventoCerrar(eventoCerrar);

        this.add(header, "h 50!, wrap");
        this.add(menu, "w 100%, h 100%");
        menu.add(maestroDatos);
    }

    public void showForm(Component form) {
        removeAll();
        this.add(header, "h 50!, wrap");
        this.add(form, "w 100%, h 100%");
        repaint();
        revalidate();
    }

    public void addEventoCerrar(EventoCerrarForm eventoCerrar) {
        this.eventoCerrar = eventoCerrar;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

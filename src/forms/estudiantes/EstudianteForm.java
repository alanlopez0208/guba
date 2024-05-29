package forms.estudiantes;

import componentes.ButtonsHeader;
import event.EventButtonsHeader;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import modelos.EstudianteModelo;
import net.miginfocom.swing.MigLayout;

public class EstudianteForm extends javax.swing.JPanel {

    EstudianteModelo modelo;
    MigLayout layout;
    EstudianteDatosForm estudianteDatos;
    ButtonsHeader header;
    EventButtonsHeader eventButtonsHeader;

    public EstudianteForm(EstudianteModelo modelo) {
        initComponents();
        this.modelo = modelo;
        init();
    }

    private void init() {
        layout = new MigLayout("fill");
        this.setLayout(layout);

        header = new ButtonsHeader();
        JPanel menu = new JPanel();
        menu.setOpaque(false);
        menu.setLayout(new BorderLayout());

        estudianteDatos = new EstudianteDatosForm(modelo);
        eventButtonsHeader = new EventButtonsHeader() {
            @Override
            public void onSelectButton(int index) {
                switch (index) {
                    case 0:
                        showForm(estudianteDatos);
                        break;
                    case 1:
                        showForm(new CalificacionesForm());
                        break;
                    case 2:
                        showForm(new AdicionalesForm());
                        break;
                    default:
                        break;
                }

            }
        };

        header.addEventButtonsHeader(eventButtonsHeader);

        this.add(header, "h 50!, wrap");
        this.add(menu, "w 100%, h 100%");
        menu.add(estudianteDatos);
    }

    public void showForm(Component form) {
        removeAll();
        this.add(header, "h 50!, wrap");
        this.add(form, "w 100%, h 100%");
        repaint();
        revalidate();
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

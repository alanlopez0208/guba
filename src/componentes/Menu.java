package componentes;

import event.EventMenu;
import event.EventMenuSelected;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import modelos.ModelMenu;

import net.miginfocom.swing.MigLayout;
import swim.MenuAnimation;
import swim.MenuItem;
import swim.scrollbar.ScrollBarCustom;

public class Menu extends javax.swing.JPanel {

    public void addEventMenuSelected(EventMenuSelected eventMenuSelected) {
        this.eventMenuSelected = eventMenuSelected;
    }

    public void setEnabledMenu(boolean enabledMenu) {
        this.enabledMenu = enabledMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    private final MigLayout layout;

    private EventMenuSelected eventMenuSelected;
    private boolean enabledMenu = true;
    private boolean showMenu = true;

    public Menu() {
        initComponents();
        this.setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setOpaque(false);
        panel.setBackground(new Color(0,0,0,0));
        panel.setLayout(layout);

    }

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/1.png")), "Inicio"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/6.png")), "Estudiantes", "Ver Estudiantes", "Agregar Alumno"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/5.png")), "Maestros", "Ver Docentes", "Agregar Docentes"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/grupo.png")), "Grupos", "Ver Grupos"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/materia.png")), "Materias", "Ver Materias", "Añadir Materias"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/9.png")), "Carreras", "Ver Carreras", "Añadir Carreras"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Calificaciones"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/5.png")), "Personal","Ver Personal", "Añadir Personal"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Pagos Alumnos", "Ver Pagos", "Añadir Pago"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Pagos Maestros", "Ver Pagos", "Añadir Pago"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/2.png")), "Sistema Web","Subir información"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/settings.png")), "Configuracion"));
    }

    private void addMenu(ModelMenu modelMenu) {
        panel.add(new MenuItem(modelMenu, getEventMenu(), eventMenuSelected, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component compent, boolean open) {

                if (enabledMenu) {
                    if (showMenu) {
                        if (open) {
                            new MenuAnimation(layout, compent).openMenu();
                        } else {
                            new MenuAnimation(layout, compent).closeMenu();
                        }
                        return true;
                    } else {
                        System.out.println("Show pop up menu (Menu is close)");
                    }
                }

                return false;
            }

        };
    }

    ;

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panel.setBackground(new java.awt.Color(255, 102, 102));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panel.setFocusable(false);
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        jLabel1.setText("School Sync");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint = new GradientPaint(0, 0, new Color(21, 50, 89), this.getWidth(), 0, new Color(26, 65, 115));

        g2.setPaint(gradientPaint);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());

        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}

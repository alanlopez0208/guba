package componentes;

import event.EventMenu;
import event.EventMenuSelected;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelos.ModelMenu;

import net.miginfocom.swing.MigLayout;
import operaciones.Config;
import swim.MenuAnimation;
import swim.MenuItem;
import swim.scrollbar.ScrollBarCustom;

public class Menu extends javax.swing.JPanel {

    private Config config;

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
        config = new Config();
        this.setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setOpaque(false);
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.setLayout(layout);

        BufferedImage imagenOriginal;
        try {
            imagenOriginal = ImageIO.read(new File(config.obtenerConfiguracion("07 RUTA Logo")));
            Icon iconoBack = new ImageIcon(imagenOriginal.getScaledInstance(220, 150, Image.SCALE_SMOOTH));
            jLabel1.setIcon(iconoBack);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/1.png")), "Inicio"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/6.png")), "Estudiantes", "Ver Estudiantes", "Agregar Alumno"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/5.png")), "Maestros", "Ver Docentes", "Agregar Docentes"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/grupo.png")), "Grupos", "Ver Grupos"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/materia.png")), "Materias", "Ver Materias", "Añadir Materias"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/9.png")), "Carreras", "Ver Carreras", "Añadir Carreras"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/5.png")), "Personal", "Ver Personal", "Añadir Personal"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Pagos Alumnos", "Ver Pagos", "Añadir Pago"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Pagos Maestros", "Ver Pagos", "Añadir Pago"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/2.png")), "Sistema Web", "Subir información", "Bajar Información"));
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
            .addGap(0, 293, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1149, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE))
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

package swim;

import event.EventMenu;
import event.EventMenuSelected;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.ModelMenu;
import net.miginfocom.swing.MigLayout;

public class MenuItem extends javax.swing.JPanel {
    
    public float getAlpha() {
        return alpha;
    }
    
    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
    
    public ModelMenu getModel() {
        return model;
    }
    
    public void setModel(ModelMenu model) {
        this.model = model;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    public EventMenuSelected getEventMenuSelected() {
        return eventMenuSelected;
    }
    
    public void setEventMenuSelected(EventMenuSelected eventMenuSelected) {
        this.eventMenuSelected = eventMenuSelected;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    private float alpha;
    ModelMenu model;
    private boolean open;
    private EventMenuSelected eventMenuSelected;
    private int index;
    
    public MenuItem(ModelMenu menu, EventMenu eventMenu, EventMenuSelected eventMenuSelected, int index) {
        initComponents();
        
        this.model = menu;
        this.eventMenuSelected = eventMenuSelected;
        this.index = index;
        this.setOpaque(false);
        
        this.setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 35!]"));
        
        MenuButton firstItem = new MenuButton(menu.getIcon(), "     " + menu.getMenuName());
        firstItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu.getSubMenu().length > 0) {
                    if (eventMenu.menuPressed(MenuItem.this, !open)) {
                        open = !open;
                    }
                }
                
                eventMenuSelected.menuSelected(index, -1);
            }
            
        });
        this.add(firstItem);
        int subMenuIndex = 1;
        
        for (String st : menu.getSubMenu()) {
            MenuButton item = new MenuButton(st);
            item.setIndex(++subMenuIndex);
            item.addActionListener((ActionEvent e) -> {
                eventMenuSelected.menuSelected(index, item.getIndex());
            });
            this.add(item);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(new Color(50, 50, 50));
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        
        g2.fillRect(0, 2, this.getWidth(), 38);
        g2.setComposite(AlphaComposite.SrcOver);
        
        g2.fillRect(0, 40, this.getWidth(), this.getPreferredSize().height - 40);
        g2.setColor(new Color(100, 100, 100));
        g2.drawLine(30, 40 , 30, this.getPreferredSize().height - 17);
        
        
        for (int i = 0; i < model.getSubMenu().length; i++) {
            int y = ((i+ 1) * 35 + 40) - 17;
            g2.drawLine(30, y, 38, y);
        }
        
        if(model.getSubMenu().length > 0){
            this.createArrowButton(g2);
        }
        super.paintComponent(g);
        
    }
    
    private void createArrowButton( Graphics2D g2 ){
        int size = 4;
        int y = 19;
        int x = 205;
        g2.setColor(new Color(230,230,230));
        float ay = alpha*size;
        float ay1 = (1f - alpha) * size;
        g2.drawLine(x, (int )(y + ay), x + 4,(int )( y + ay1));
         g2.drawLine(x + 4, (int )(y + ay1), x + 8,(int )( y +ay ));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

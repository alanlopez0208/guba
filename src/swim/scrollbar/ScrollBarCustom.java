package swim.scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;


public class ScrollBarCustom extends JScrollBar {
    
    public ScrollBarCustom(){
        this.setUI(new ModernScrollBarUi());
        this.setPreferredSize(new Dimension(5,5));
        this.setForeground(new Color(94,139,231));
        this.setUnitIncrement(20);
        this.setOpaque(false);
    }
    
}

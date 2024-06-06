
package swim;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Imagen {
    
    
    public Image toImageResizable(InputStream input, int width, int heigth){
        
   
        try {
            
            
            BufferedImage buffered = ImageIO.read(input);
            
            Image image = buffered.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
          
            
            return image;
            
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

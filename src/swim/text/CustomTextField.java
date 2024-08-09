package swim.text;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

public class CustomTextField extends JLabel {

    private Image backgroundImage;

    public CustomTextField(String imagePath) {
        // Carga la imagen desde el sistema de archivos
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: No se pudo cargar la imagen en la ruta especificada.");
        }
        setOpaque(false); // Hacer que el fondo sea transparente para ver la imagen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            int width = getWidth();
            int height = getHeight();
            g.drawImage(backgroundImage, 0, 0, width, height, this);
        }
    }
}

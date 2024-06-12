package operaciones;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import operaciones.conexion.Conexion;

public class FotoAlumno {

    private Connection conn;

    public FotoAlumno() {
        conn = new Conexion().connect();
    }

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    // Método para capturar una foto desde la cámara
    public static byte[] capturarFotoDesdeCamara() {
        VideoCapture camera = new VideoCapture(0); // 0 es el ID de la cámara (por defecto la cámara primaria)
        if (!camera.isOpened()) {
            System.out.println("Error al abrir la cámara.");
            return null;
        }

        Mat frame = new Mat();
        camera.read(frame);
        camera.release();

        // Convierte el Mat a BufferedImage
        BufferedImage image = (BufferedImage) HighGui.toBufferedImage(frame);
        byte[] imageBytes = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "jpg", baos);
            imageBytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageBytes;
    }

    // Método para seleccionar una imagen desde el sistema de archivos
    public static byte[] seleccionarFotoDesdeArchivos() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                return Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // Método para guardar la foto en la base de datos
    public static boolean guardarFotoEnBaseDeDatos(String matricula, byte[] foto) {
        String sql = "UPDATE Alumnos SET Foto = ? WHERE Matricula = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBytes(1, foto);
            pstmt.setString(2, matricula);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    

    // Método principal para demostrar la funcionalidad
    public static void main(String[] args) {
        String matricula = "12345"; // Ejemplo de matrícula del alumno

        // Menú para elegir si capturar desde la cámara o seleccionar desde los archivos
        Object[] options = {"Capturar desde Cámara", "Seleccionar desde Archivos"};
        int choice = JOptionPane.showOptionDialog(null,
                "Selecciona cómo deseas cargar la foto",
                "Opciones de Carga de Foto",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        byte[] foto = null;
        if (choice == JOptionPane.YES_OPTION) {
            // Captura la foto desde la cámara
            foto = capturarFotoDesdeCamara();
        } else if (choice == JOptionPane.NO_OPTION) {
            // Selección de una foto desde el sistema de archivos
            foto = seleccionarFotoDesdeArchivos();
        }

        if (foto != null) {
            boolean guardado = guardarFotoEnBaseDeDatos(matricula, foto);
            if (guardado) {
                System.out.println("Foto guardada en la base de datos.");
            } else {
                System.out.println("Error al guardar la foto en la base de datos.");
            }
        } else {
            System.out.println("No se capturó ni seleccionó ninguna foto.");
        }
    }
}

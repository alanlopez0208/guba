package operaciones;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FTPDownloader {

    private static final Logger LOGGER = Logger.getLogger(FTPDownloader.class.getName());

    // Configuración del servidor FTP
    private String ftpServer = "ftp.gubaescolares.com";
    private String user = "subir@gubaescolares.com";
    private String password = "p_WyU)p}&shG";
    private String remoteDir = "BDGUBA - copia.db";
    private String localDir = "C:\\Users\\jesus\\Documents\\NetBeansProjects\\guba\\BD\\";
    private boolean useBinary = true;

    public FTPDownloader() {
        // Constructor por defecto
    }

    public void downloadFile() {
        FTPClient ftpClient = new FTPClient();
        boolean success = false;
        try {
            // Conectar al servidor FTP
            ftpClient.connect(ftpServer);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                LOGGER.log(Level.SEVERE, "Connection failed. Server reply code: " + replyCode);
                JOptionPane.showMessageDialog(null, "Error al conectar al servidor FTP. Código de respuesta: " + replyCode, "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!ftpClient.login(user, password)) {
                LOGGER.log(Level.SEVERE, "Login failed.");
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión en el servidor FTP.", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Configurar el tipo de archivo
            if (useBinary) {
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            } else {
                ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
            }

            // Cambiar a modo pasivo
            ftpClient.enterLocalPassiveMode();

            // Verificar y crear el directorio local si no existe
            File localDirFile = new File(localDir);
            if (!localDirFile.exists()) {
                if (!localDirFile.mkdirs()) {
                    LOGGER.log(Level.SEVERE, "Failed to create local directory: " + localDir);
                    JOptionPane.showMessageDialog(null, "No se pudo crear el directorio local: " + localDir, "Error de Directorio", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Cambiar al directorio remoto
            String remoteFileName = new File(remoteDir).getName();
            String remoteDirectory = new File(remoteDir).getParent();
            if (remoteDirectory != null && !ftpClient.changeWorkingDirectory(remoteDirectory)) {
                LOGGER.log(Level.SEVERE, "Failed to change working directory to: " + remoteDirectory);
                JOptionPane.showMessageDialog(null, "No se pudo cambiar al directorio remoto: " + remoteDirectory, "Error de Directorio", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Descargar el archivo
            File downloadFile = new File(localDir + File.separator + remoteFileName);
            try (OutputStream outputStream = new FileOutputStream(downloadFile)) {
                success = ftpClient.retrieveFile(remoteFileName, outputStream);
                if (success) {
                    LOGGER.log(Level.INFO, "File downloaded successfully: " + remoteFileName);
                } else {
                    LOGGER.log(Level.SEVERE, "File download failed: " + remoteFileName);
                }
            }

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error occurred during FTP operation.", ex);
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Error closing FTP connection.", ex);
            }

            // Mostrar mensaje al usuario sobre el resultado de la operación
            if (success) {
                JOptionPane.showMessageDialog(null, "Archivo descargado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La descarga del archivo falló.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso desde el main para pruebas independientes
        FTPDownloader downloader = new FTPDownloader();
        downloader.downloadFile();
    }
}

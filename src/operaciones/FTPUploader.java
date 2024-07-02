import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FTPUploader {

    private static final Logger LOGGER = Logger.getLogger(FTPUploader.class.getName());

    /**
     * @param ftpServer Servidor FTP
     * @param user Usuario
     * @param password Contraseña
     * @param remoteDir Directorio donde se subirá el archivo
     * @param localFile Archivo local que se va a subir
     * @param useBinary Usar modo de transferencia binaria
     */
    public static void uploadFile(String ftpServer, String user, String password, String remoteDir, File localFile, boolean useBinary) {
        FTPClient ftpClient = new FTPClient();
        try {
            // Conectar al servidor FTP
            ftpClient.connect(ftpServer);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                LOGGER.log(Level.SEVERE, "Connection failed. Server reply code: " + replyCode);
                return;
            }

            if (!ftpClient.login(user, password)) {
                LOGGER.log(Level.SEVERE, "Login failed.");
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

            // Cambiar al directorio remoto
            if (!ftpClient.changeWorkingDirectory(remoteDir)) {
                LOGGER.log(Level.SEVERE, "Failed to change working directory to: " + remoteDir);
                return;
            }

            // Subir el archivo
            try (FileInputStream inputStream = new FileInputStream(localFile)) {
                String remoteFileName = localFile.getName();
                boolean done = ftpClient.storeFile(remoteFileName, inputStream);
                if (done) {
                    LOGGER.log(Level.INFO, "File uploaded successfully: " + remoteFileName);
                } else {
                    LOGGER.log(Level.SEVERE, "File upload failed: " + remoteFileName);
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
        }
    }

    public static void main(String[] args) {
        // Archivo a subir
        File fileToUpload = new File("C:\\Users\\jesus\\Documents\\NetBeansProjects\\guba\\BD\\BDGUBA - copia.db");

        // Configuración del servidor FTP y credenciales
        String ftpServer = "ftp.gubaescolares.com";
        String user = "subir@gubaescolares.com";
        String password = "p_WyU)p}&shG";
        String remoteDir = "";

        // Subir el archivo en modo binario
        uploadFile(ftpServer, user, password, remoteDir, fileToUpload, true);
    }
}

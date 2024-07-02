import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FTPDownloader {

    private static final Logger LOGGER = Logger.getLogger(FTPDownloader.class.getName());

    /**
     * 
     *
     * @param ftpServer Servidor FTP
     * @param user Usuario
     * @param password Contraseña
     * @param remoteFilePath Ruta del archivo en el servidor FTP
     * @param localDir Directorio local donde se guardará el archivo descargado
     * @param useBinary Usar modo de transferencia binaria
     */
    public static void downloadFile(String ftpServer, String user, String password, String remoteFilePath, String localDir, boolean useBinary) {
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

            // Verificar y crear el directorio local si no existe
            File localDirFile = new File(localDir);
            if (!localDirFile.exists()) {
                if (!localDirFile.mkdirs()) {
                    LOGGER.log(Level.SEVERE, "Failed to create local directory: " + localDir);
                    return;
                }
            }

            // Cambiar al directorio remoto
            String remoteFileName = new File(remoteFilePath).getName();
            if (!ftpClient.changeWorkingDirectory(new File(remoteFilePath).getParent())) {
                LOGGER.log(Level.SEVERE, "Failed to change working directory to: " + new File(remoteFilePath).getParent());
                return;
            }

            // Descargar el archivo
            File downloadFile = new File(localDir + File.separator + remoteFileName);
            try (OutputStream outputStream = new FileOutputStream(downloadFile)) {
                boolean success = ftpClient.retrieveFile(remoteFilePath, outputStream);
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
        }
    }

    public static void main(String[] args) {
        // Configuración del servidor FTP y credenciales
        String ftpServer = "ftp.gubaescolares.com";
        String user = "subir@gubaescolares.com";
        String password = "p_WyU)p}&shG";
        String remoteDir = "BDGUBA - copia.db";
        String localDir = "C:\\Users\\jesus\\Documents\\NetBeansProjects\\guba\\BD\\";          

        // Descargar el archivo en modo binario
        downloadFile(ftpServer, user, password, remoteDir, localDir, true);
    }
}

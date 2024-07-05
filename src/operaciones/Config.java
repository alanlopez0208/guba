package operaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {
    
    private FileReader archivo;
    private BufferedReader lector;

    public String obtenerRutaBD() {
        String rutaBD = null;
        try {
            archivo = new FileReader("src\\operaciones\\Configuraciones.txt");
            lector = new BufferedReader(archivo);

            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.startsWith("01 RUTA BD")) {
                    // Obtener la ruta de la base de datos desde la línea
                    rutaBD = linea.substring(linea.indexOf("=") + 2); // Sumar 2 para omitir el espacio y el =
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al intentar leer el archivo de configuración: " + e.getMessage());
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
                if (archivo != null) {
                    archivo.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de configuración: " + e.getMessage());
            }
        }
        return rutaBD;
    }

    public static void main(String[] args) {
        Config config = new Config();
        String rutaBD = config.obtenerRutaBD();
        System.out.println("Ruta de la base de datos obtenida: " + rutaBD);

   
    }
    
}

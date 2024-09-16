package operaciones.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {

    private static final String BASE_URL = "http://www.gubaescolares.com/api.php?query=";

    static class Calificacion {

        int idCalificacion;
        int idAlumno;
        int idDocente;
        int idMateria;
        int idPeriodo;
        Integer p1u1, p2u1, p3u1, p4u1, p1u2, p2u2, p3u2, p4u2;
        Integer p1u3, p2u3, p3u3, p4u3, p1u4, p2u4, p3u4, p4u4;
        Integer tb;

        Calificacion(JSONObject json) {
            this.idCalificacion = json.getInt("IdCalificacion");
            this.idAlumno = json.getInt("IdAlumno");
            this.idDocente = json.getInt("IdDocente");
            this.idMateria = json.getInt("IdMateria");
            this.idPeriodo = json.getInt("IdPeriodo");
            this.p1u1 = json.optInt("P1U1", 0);
            this.p2u1 = json.optInt("P2U1", 0);
            this.p3u1 = json.optInt("P3U1", 0);
            this.p4u1 = json.optInt("P4U1", 0);
            this.p1u2 = json.optInt("P1U2", 0);
            this.p2u2 = json.optInt("P2U2", 0);
            this.p3u2 = json.optInt("P3U2", 0);
            this.p4u2 = json.optInt("P4U2", 0);
            this.p1u3 = json.optInt("P1U3", 0);
            this.p2u3 = json.optInt("P2U3", 0);
            this.p3u3 = json.optInt("P3U3", 0);
            this.p4u3 = json.optInt("P4U3", 0);
            this.p1u4 = json.optInt("P1U4", 0);
            this.p2u4 = json.optInt("P2U4", 0);
            this.p3u4 = json.optInt("P3U4", 0);
            this.p4u4 = json.optInt("P4U4", 0);
            this.tb = json.optInt("TB", 0);
        }

        @Override
        public String toString() {
            return "Calificacion{"
                    + "idCalificacion=" + idCalificacion
                    + ", idAlumno=" + idAlumno
                    + ", idDocente=" + idDocente
                    + ", idMateria=" + idMateria
                    + ", idPeriodo=" + idPeriodo
                    + ", p1u1=" + p1u1
                    + ", p2u1=" + p2u1
                    + ", p3u1=" + p3u1
                    + ", p4u1=" + p4u1
                    + ", p1u2=" + p1u2
                    + ", p2u2=" + p2u2
                    + ", p3u2=" + p3u2
                    + ", p4u2=" + p4u2
                    + ", p1u3=" + p1u3
                    + ", p2u3=" + p2u3
                    + ", p3u3=" + p3u3
                    + ", p4u3=" + p4u3
                    + ", p1u4=" + p1u4
                    + ", p2u4=" + p2u4
                    + ", p3u4=" + p3u4
                    + ", p4u4=" + p4u4
                    + ", tb=" + tb
                    + '}';
        }
    }

    static class Alumno {

        int idAlumno;
        String password;

        Alumno(JSONObject json) {
            this.idAlumno = json.getInt("IdAlumno");
            this.password = json.optString("Password", "");
        }

        @Override
        public String toString() {
            return "Alumno{"
                    + "idAlumno=" + idAlumno
                    + ", password='" + password + '\''
                    + '}';
        }
    }

    static class Docente {

        int idDocente;
        String password;

        Docente(JSONObject json) {
            this.idDocente = json.getInt("IdDocente");
            this.password = json.optString("Password", "");
        }

        @Override
        public String toString() {
            return "Docente{"
                    + "idDocente=" + idDocente
                    + ", password='" + password + '\''
                    + '}';
        }
    }

    private static JSONArray getData(String query) {
        JSONArray jsonArray = null;
        HttpURLConnection conn = null;
        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            URL url = new URL(BASE_URL + encodedQuery);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);

            if (responseCode == 200) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder content = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    jsonArray = new JSONArray(content.toString());
                }
            } else {
                System.out.println("Error en la respuesta del servidor.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return jsonArray;
    }

    public static JSONArray getCalificaciones() {
        return getData("SELECT * FROM Calificaciones");
    }

    public static JSONArray getAlumnos() {
        return getData("SELECT IdAlumno, Password FROM Alumnos");
    }

    public static JSONArray getDocentes() {
        return getData("SELECT IdDocente, Password FROM Docentes");
    }
    
    
    
}

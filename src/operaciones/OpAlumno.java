package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.EstudianteModelo;
import operaciones.conexion.Conexion;

public class OpAlumno {
    
    private Connection conn;
    
    public OpAlumno() {
        conn = new Conexion().connect();
    }
    
    public ArrayList<EstudianteModelo> getEstudiantes() {
        ArrayList<EstudianteModelo> lista = new ArrayList<>();
<<<<<<< HEAD
<<<<<<< Updated upstream

        // Crear 5 instancias de EstudianteModelo
        EstudianteModelo estudiante1 = new EstudianteModelo("2023001", "Juan", "Perez", "Lopez",
                "juan.perez@gmail.com", "jperez@institucional.edu", "2021", "5551234567",
                "Estado 1", "Municipio 1", "Escuela 1", "Grado 1", "Grupo A", "Semestre 1", "Activo");

        EstudianteModelo estudiante2 = new EstudianteModelo("2023002", "Maria", "Gomez", "Rodriguez",
                "maria.gomez@gmail.com", "mgomez@institucional.edu", "2021", "5551234568",
                "Estado 2", "Municipio 2", "Escuela 2", "Grado 2", "Grupo B", "Semestre 2", "Activo");

        EstudianteModelo estudiante3 = new EstudianteModelo("2023003", "Carlos", "Garcia", "Martinez",
                "carlos.garcia@gmail.com", "cgarcia@institucional.edu", "2021", "5551234569",
                "Estado 3", "Municipio 3", "Escuela 3", "Grado 3", "Grupo C", "Semestre 3", "Activo");

        EstudianteModelo estudiante4 = new EstudianteModelo("2023004", "Ana", "Lopez", "Hernandez",
                "ana.lopez@gmail.com", "alopez@institucional.edu", "2021", "5551234570",
                "Estado 4", "Municipio 4", "Escuela 4", "Grado 4", "Grupo D", "Semestre 4", "Activo");

        EstudianteModelo estudiante5 = new EstudianteModelo("2023005", "Luis", "Martinez", "Gonzalez",
                "luis.martinez@gmail.com", "lmartinez@institucional.edu", "2021", "5551234571",
                "Estado 5", "Municipio 5", "Escuela 5", "Grado 5", "Grupo E", "Semestre 5", "Activo");

        // Agregar las instancias a la lista
        lista.add(estudiante1);
        lista.add(estudiante2);
        lista.add(estudiante3);
        lista.add(estudiante4);
        lista.add(estudiante5);
        /**
         * //Aqui hay un ejemplo de for for (int i = 0; i < 10; i++) {
         * EstudianteModelo estudiante = new EstudianteModelo();
         * estudiante.setNombre(....); estudiante.setApMaterno(....); //y asi
         * sucesivamente }
         *
         */
        return lista;
    }

    //Metodo para actualizar alumno
=======
        String sql = "SELECT IdAlumno, Matricula, Nombre, ApellidoPaterno, ApellidoMaterno, CorreoPersonal, CorreoInstitucional, "
                + "Generacion, Celular, Estado, Municipio, EscuelaProcedencia, GradoEstudios, Grupo, Status "
                + "FROM Alumnos";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                EstudianteModelo estudiante = mapResultSetToEstudiante(rs);
                lista.add(estudiante);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar estudiantes", e);
        }
        return lista;
    }
=======
        String sql = "SELECT IdAlumno, Matricula, Nombre, ApellidoPaterno, ApellidoMaterno, CorreoPersonal, CorreoInstitucional, "
                + "Generacion, Celular, Estado, Municipio, EscuelaProcedencia, GradoEstudios, Grupo, status "
                + "FROM Alumnos";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                EstudianteModelo estudiante = mapResultSetToEstudiante(rs);
                lista.add(estudiante);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar estudiantes", e);
        }
        return lista;
    }
>>>>>>> master
    
    public ArrayList<EstudianteModelo> buscarEstudiantes(String filtro) {
        ArrayList<EstudianteModelo> resultados = new ArrayList<>();
        String sql = "SELECT IdAlumno, Matricula, Nombre, ApellidoPaterno, ApellidoMaterno, CorreoPersonal, CorreoInstitucional, "
                + "Generacion, Celular, Estado, Municipio, EscuelaProcedencia, GradoEstudios, Grupo, status "
                + "FROM Alumnos WHERE Matricula LIKE ? OR Nombre LIKE ? OR ApellidoPaterno LIKE ? OR ApellidoMaterno LIKE ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String likeParam = "%" + filtro + "%";
            for (int i = 1; i <= 4; i++) {
                pstmt.setString(i, likeParam);
            }
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    EstudianteModelo estudiante = mapResultSetToEstudiante(rs);
                    resultados.add(estudiante);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar estudiantes", e);
        }
        return resultados;
<<<<<<< HEAD
    }
    
    private EstudianteModelo mapResultSetToEstudiante(ResultSet rs) throws SQLException {
        return new EstudianteModelo(
                rs.getString("Matricula"),
                rs.getString("Nombre"),
                rs.getString("ApellidoPaterno"),
                rs.getString("ApellidoMaterno"),
                rs.getString("CorreoPersonal"),
                rs.getString("CorreoInstitucional"),
                rs.getString("Generacion"),
                rs.getString("Celular"),
                rs.getString("Estado"),
                rs.getString("Municipio"),
                rs.getString("EscuelaProcedencia"),
                rs.getString("GradoEstudios"),
                rs.getString("Grupo"),
                rs.getString("Status")
        );
    }
    
>>>>>>> Stashed changes
    public boolean updateAlumno(EstudianteModelo estudianteModelo) {
            //Logica para actualizar
            //tiene que retornar true si se pudo y false si no
        return true;
=======
>>>>>>> master
    }
    
    private EstudianteModelo mapResultSetToEstudiante(ResultSet rs) throws SQLException {
        return new EstudianteModelo(
                rs.getString("Matricula"),
                rs.getString("Nombre"),
                rs.getString("ApellidoPaterno"),
                rs.getString("ApellidoMaterno"),
                rs.getString("CorreoPersonal"),
                rs.getString("CorreoInstitucional"),
                rs.getString("Generacion"),
                rs.getString("Celular"),
                rs.getString("Estado"),
                rs.getString("Municipio"),
                rs.getString("EscuelaProcedencia"),
                rs.getString("GradoEstudios"),
                rs.getString("Grupo"),
                rs.getString("semestre"),
                rs.getString("status")
        );
    }
    
    public boolean updateAlumno(EstudianteModelo estudianteModelo) {
        String sql = "UPDATE Alumnos SET Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, CorreoPersonal = ?, "
                + "CorreoInstitucional = ?, Generacion = ?, Celular = ?, Estado = ?, Municipio = ?, "
                + "EscuelaProcedencia = ?, GradoEstudios = ?, Grupo = ?, status = ? WHERE Matricula = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, estudianteModelo.getNombre());
            pstmt.setString(2, estudianteModelo.getApPaterno());
            pstmt.setString(3, estudianteModelo.getApMaterno());
            pstmt.setString(4, estudianteModelo.getEmailPersonal());
            pstmt.setString(5, estudianteModelo.getEmailInstitucional());
            pstmt.setString(6, estudianteModelo.getGeneracion());
            pstmt.setString(7, estudianteModelo.getNumCelular());
            pstmt.setString(8, estudianteModelo.getEstado());
            pstmt.setString(9, estudianteModelo.getMunicipio());
            pstmt.setString(10, estudianteModelo.getEscProcedencia());
            pstmt.setString(11, estudianteModelo.getGrado());
            pstmt.setString(12, estudianteModelo.getGrupo());
            pstmt.setString(14, estudianteModelo.getStatus());
            pstmt.setString(15, estudianteModelo.getMatricula());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar estudiante", e);
        }
    }
    
    public boolean deleteAlumno(String matricula) {
        String sql = "DELETE FROM Alumnos WHERE Matricula = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar estudiante", e);
        }
    }
    
    public EstudianteModelo returEstudiante(String matricula) {
        String sql = "SELECT IdAlumno, Matricula, Nombre, ApellidoPaterno, ApellidoMaterno, CorreoPersonal, CorreoInstitucional, "
                + "Generacion, Celular, Estado, Municipio, EscuelaProcedencia, GradoEstudios, Grupo, status "
                + "FROM Alumnos WHERE Matricula = ?";
        EstudianteModelo estudiante = null;
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    estudiante = mapResultSetToEstudiante(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar estudiante", e);
        }
        return estudiante;
    }
}

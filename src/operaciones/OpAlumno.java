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

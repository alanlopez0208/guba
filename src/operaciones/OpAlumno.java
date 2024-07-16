package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.EstudianteModelo;
import operaciones.conexion.Conexion;

public class OpAlumno {

    public ArrayList<EstudianteModelo> getEstudiantes() {
        ArrayList<EstudianteModelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Alumnos";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EstudianteModelo estudiante = mapResultSetToEstudiante(rs);
                lista.add(estudiante);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar estudiantes", e);
        }
        return lista;
    }

    public ArrayList<EstudianteModelo> buscarEstudiantes(String where, String filtro) {
        ArrayList<EstudianteModelo> resultados = new ArrayList<>();
        String sql = "SELECT * FROM Alumnos WHERE " + where + " LIKE ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, filtro + "%");

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
        EstudianteModelo estudiante = new EstudianteModelo();
        estudiante.setId(rs.getString("IdAlumno"));
        estudiante.setMatricula(rs.getString("Matricula"));
        estudiante.setNombre(rs.getString("Nombre"));
        estudiante.setApPaterno(rs.getString("ApellidoPaterno"));
        estudiante.setApMaterno(rs.getString("ApellidoMaterno"));
        estudiante.setEmailPersonal(rs.getString("CorreoPersonal"));
        estudiante.setEmailInstitucional(rs.getString("CorreoInstitucional"));
        estudiante.setGeneracion(rs.getString("Generacion"));
        estudiante.setNumCelular(rs.getString("Celular"));
        estudiante.setEstado(rs.getString("Estado"));
        estudiante.setMunicipio(rs.getString("Municipio"));
        estudiante.setEscProcedencia(rs.getString("EscuelaProcedencia"));
        estudiante.setGrado(rs.getString("GradoEstudios"));
        estudiante.setGrupo(rs.getString("IdGrupo"));
        estudiante.setStatus(rs.getString("Status"));
        estudiante.setPassword(rs.getString("Password"));
        estudiante.setPasswordTemporal(rs.getString("PasswordTemporal"));
        estudiante.setSexo(rs.getString("Genero"));
        estudiante.setFoto(rs.getString("Foto"));

        return estudiante;
    }

    public boolean updateAlumno(EstudianteModelo estudianteModelo) {
        String sql = "UPDATE Alumnos SET Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, CorreoPersonal = ?, "
                + "CorreoInstitucional = ?, Generacion = ?, Celular = ?, Estado = ?, Municipio = ?, "
                + "EscuelaProcedencia = ?, GradoEstudios = ?, IdGrupo = ?, Status = ?, Genero = ? "
                + (estudianteModelo.getFoto() != null ? ", Foto = ?" : "")
                + " WHERE Matricula = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
            pstmt.setString(13, estudianteModelo.getStatus());
            pstmt.setString(14, estudianteModelo.getSexo());

            if (estudianteModelo.getFoto() != null) {
                pstmt.setString(15, estudianteModelo.getFoto());
                pstmt.setString(16, estudianteModelo.getMatricula());
            } else {
                pstmt.setString(15, estudianteModelo.getMatricula());
            }

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar estudiante", e);
        }
    }

    public boolean deleteAlumno(String matricula) {
        String sql = "DELETE FROM Alumnos WHERE Matricula = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar estudiante", e);
        }
    }

    public EstudianteModelo getEstudiante(String matricula) {
        String sql = "SELECT * FROM Alumnos WHERE Matricula = ?";
        EstudianteModelo estudiante = null;

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

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

    public boolean crearAlumno(EstudianteModelo estudianteModelo) {
        String sqlAlumno = "INSERT INTO Alumnos (Matricula, Nombre, ApellidoPaterno, ApellidoMaterno, CorreoPersonal, "
                + "CorreoInstitucional, Generacion, Celular, Estado, Municipio, EscuelaProcedencia, GradoEstudios, IdGrupo, Status, Genero"
                + (estudianteModelo.getFoto() != null ? ", Foto" : "") + ") "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?" + (estudianteModelo.getFoto() != null ? ", ?" : "") + ")";
        String sqlAlumnoId = "SELECT last_insert_rowid() as nuevo_id_alumno";
        String sqlCalificaciones = "INSERT INTO Calificaciones (IdAlumno, IdGrupo, IdMateria)"
                + "SELECT ? , IdGrupo, IdMateria "
                + "FROM GruposMaterias "
                + "WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect()) {
            conn.setAutoCommit(false);
            int newAlumnoId;

            try (PreparedStatement pstmtAlumno = conn.prepareStatement(sqlAlumno)) {
                pstmtAlumno.setString(1, estudianteModelo.getMatricula());
                pstmtAlumno.setString(2, estudianteModelo.getNombre());
                pstmtAlumno.setString(3, estudianteModelo.getApPaterno());
                pstmtAlumno.setString(4, estudianteModelo.getApMaterno());
                pstmtAlumno.setString(5, estudianteModelo.getEmailPersonal());
                pstmtAlumno.setString(6, estudianteModelo.getEmailInstitucional());
                pstmtAlumno.setString(7, estudianteModelo.getGeneracion());
                pstmtAlumno.setString(8, estudianteModelo.getNumCelular());
                pstmtAlumno.setString(9, estudianteModelo.getEstado());
                pstmtAlumno.setString(10, estudianteModelo.getMunicipio());
                pstmtAlumno.setString(11, estudianteModelo.getEscProcedencia());
                pstmtAlumno.setString(12, estudianteModelo.getGrado());
                pstmtAlumno.setString(13, estudianteModelo.getGrupo());
                pstmtAlumno.setString(14, estudianteModelo.getStatus());
                pstmtAlumno.setString(15, estudianteModelo.getSexo());

                if (estudianteModelo.getFoto() != null) {
                    pstmtAlumno.setString(16, estudianteModelo.getFoto());
                }

                int affectedRows = pstmtAlumno.executeUpdate();
                if (affectedRows == 0) {
                    conn.rollback();
                    throw new SQLException("Error al crear alumno, no se insertó ninguna fila");
                }
            }

            try (PreparedStatement pstmtAlumnoId = conn.prepareStatement(sqlAlumnoId); ResultSet rs = pstmtAlumnoId.executeQuery()) {
                if (rs.next()) {
                    newAlumnoId = rs.getInt("nuevo_id_alumno");
                } else {
                    conn.rollback();
                    throw new SQLException("Error al obtener el ID del nuevo alumno");
                }
            }
            
            System.out.println("Se van a agregar las calificaciones papito");
            try (PreparedStatement pstmtCalificaciones = conn.prepareStatement(sqlCalificaciones)) {
                pstmtCalificaciones.setInt(1, newAlumnoId);
                pstmtCalificaciones.setString(2, estudianteModelo.getGrupo());
                pstmtCalificaciones.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear alumno y sus calificaciones", e);
        }
    }

}

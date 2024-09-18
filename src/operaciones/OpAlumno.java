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
        OpCarreras opCarrera = new OpCarreras();
        estudiante.setCarrera(opCarrera.getCarreraByd(rs.getString("IdCarrera")));
        estudiante.setSemestre(rs.getString("Semestre"));
        estudiante.setDireccion(rs.getString("Direccion"));
        estudiante.setNacimiento(rs.getString("Nacimiento"));

        return estudiante;
    }

    public boolean updateAlumno(EstudianteModelo estudianteModelo) {
        String sql = "UPDATE Alumnos SET Nombre = ?, IdCarrera = ?, Semestre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, CorreoPersonal = ?, "
                + "CorreoInstitucional = ?, Generacion = ?, Celular = ?, Estado = ?, Municipio = ?, "
                + "EscuelaProcedencia = ?, GradoEstudios = ?, IdGrupo = ?, Status = ?, Genero = ?, "
                + "Password = ?, Direccion = ?, Nacimiento = ? "
                + (estudianteModelo.getFoto() != null ? ", Foto = ?" : "")
                + " WHERE Matricula = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, estudianteModelo.getNombre());
            pstmt.setString(2, estudianteModelo.getCarrera().getIdCarrera());
            pstmt.setString(3, estudianteModelo.getSemestre());
            pstmt.setString(4, estudianteModelo.getApPaterno());
            pstmt.setString(5, estudianteModelo.getApMaterno());
            pstmt.setString(6, estudianteModelo.getEmailPersonal());
            pstmt.setString(7, estudianteModelo.getEmailInstitucional());
            pstmt.setString(8, estudianteModelo.getGeneracion());
            pstmt.setString(9, estudianteModelo.getNumCelular());
            pstmt.setString(10, estudianteModelo.getEstado());
            pstmt.setString(11, estudianteModelo.getMunicipio());
            pstmt.setString(12, estudianteModelo.getEscProcedencia());
            pstmt.setString(13, estudianteModelo.getGrado());
            pstmt.setString(14, estudianteModelo.getGrupo());
            pstmt.setString(15, estudianteModelo.getStatus());
            pstmt.setString(16, estudianteModelo.getSexo());
            pstmt.setString(17, estudianteModelo.getPassword());
            pstmt.setString(18, estudianteModelo.getDireccion());
            pstmt.setString(19, estudianteModelo.getNacimiento());

            if (estudianteModelo.getFoto() != null) {
                pstmt.setString(20, estudianteModelo.getFoto());
                pstmt.setString(21, estudianteModelo.getMatricula());
            } else {
                pstmt.setString(20, estudianteModelo.getMatricula());
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

    public ArrayList<EstudianteModelo> getEstudiantesBYGrupo(String idGrupo) {
        String sql = "SELECT * FROM Alumnos WHERE IdGrupo = ?";
        ArrayList<EstudianteModelo> estudiantes = new ArrayList<>();

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idGrupo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    EstudianteModelo estudiante = mapResultSetToEstudiante(rs);
                    estudiantes.add(estudiante);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar los estudiantes", e);
        }
        return estudiantes;
    }

    public boolean crearAlumno(EstudianteModelo estudianteModelo) {
        // SQL para insertar los datos en la tabla Alumnos
        String sqlAlumno = "INSERT INTO Alumnos (Matricula, IdCarrera, Semestre, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, "
                + "CorreoPersonal, CorreoInstitucional, Generacion, Celular, Estado, Municipio, EscuelaProcedencia, GradoEstudios, "
                + "PasswordTemporal, IdGrupo, Password, Status, Direccion, Nacimiento"
                + (estudianteModelo.getFoto() != null ? ", Foto" : "") + ") "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                + (estudianteModelo.getFoto() != null ? ", ?" : "") + ")";

        try (Connection conn = new Conexion().connect()) {

            try (PreparedStatement pstmtAlumno = conn.prepareStatement(sqlAlumno)) {
                // Asignar los valores de cada campo
                pstmtAlumno.setString(1, estudianteModelo.getMatricula());
                pstmtAlumno.setString(2, estudianteModelo.getCarrera().getIdCarrera());
                pstmtAlumno.setString(3, estudianteModelo.getSemestre());
                pstmtAlumno.setString(4, estudianteModelo.getNombre());
                pstmtAlumno.setString(5, estudianteModelo.getApPaterno());
                pstmtAlumno.setString(6, estudianteModelo.getApMaterno());
                pstmtAlumno.setString(7, estudianteModelo.getSexo()); // Género
                pstmtAlumno.setString(8, estudianteModelo.getEmailPersonal());
                pstmtAlumno.setString(9, estudianteModelo.getEmailInstitucional());
                pstmtAlumno.setString(10, estudianteModelo.getGeneracion());
                pstmtAlumno.setString(11, estudianteModelo.getNumCelular());
                pstmtAlumno.setString(12, estudianteModelo.getEstado());
                pstmtAlumno.setString(13, estudianteModelo.getMunicipio());
                pstmtAlumno.setString(14, estudianteModelo.getEscProcedencia());
                pstmtAlumno.setString(15, estudianteModelo.getGrado());
                pstmtAlumno.setString(16, estudianteModelo.getPasswordTemporal());
                pstmtAlumno.setString(17, estudianteModelo.getGrupo());
                pstmtAlumno.setString(18, estudianteModelo.getPassword());
                pstmtAlumno.setString(19, estudianteModelo.getStatus());
                pstmtAlumno.setString(20, estudianteModelo.getDireccion());
                pstmtAlumno.setString(21, estudianteModelo.getNacimiento());

                // Verificar si hay foto, en caso afirmativo, asignarla
                if (estudianteModelo.getFoto() != null) {
                    pstmtAlumno.setString(22, estudianteModelo.getFoto());
                }

                // Ejecutar la sentencia de inserción
                int affectedRows = pstmtAlumno.executeUpdate();
                return affectedRows > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al crear alumno y sus calificaciones", e);
        }
    }

    public ArrayList<EstudianteModelo> getEstudiantesByCarreraAndSemestre(String idCarrera, String semestre) {
        String sql = "SELECT * FROM Alumnos WHERE IdCarrera = ? AND Semestre = ?";
        ArrayList<EstudianteModelo> estudiantes = new ArrayList<>();

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idCarrera);
            pstmt.setString(2, semestre);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    EstudianteModelo estudiante = mapResultSetToEstudiante(rs);
                    estudiantes.add(estudiante);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar los estudiantes por carrera y semestre", e);
        }
        return estudiantes;
    }

    public boolean incrementarSemestre() {
        String sql = "UPDATE Alumnos "
                + "SET Semestre = CASE "
                + "    WHEN Semestre < 8 THEN Semestre + 1 "
                + "    WHEN Semestre = 8 THEN 9 "
                + "    ELSE Semestre "
                + "END, IdGrupo = SELECT idGrupo FROM Grupos WHERE Semestre = semestre";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar estudiante", e);
        }
    }

    public ArrayList<EstudianteModelo> getEstudiantesByMateria(String idMateria, String idPeriodo) {

        ArrayList<EstudianteModelo> estudiantes = new ArrayList<>();

        String sqlCalificaciones = "SELECT DISTINCT IdAlumno FROM Calificaciones WHERE IdMateria = ? AND IdPeriodo = ?";

        String sqlEstudiantes = "SELECT * FROM Alumnos WHERE IdAlumno = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmtCalificaciones = conn.prepareStatement(sqlCalificaciones)) {

            pstmtCalificaciones.setString(1, idMateria);
            pstmtCalificaciones.setString(2, idPeriodo);

            try (ResultSet rsCalificaciones = pstmtCalificaciones.executeQuery()) {

                while (rsCalificaciones.next()) {

                    int idAlumno = rsCalificaciones.getInt("IdAlumno");

                    try (PreparedStatement pstmtEstudiantes = conn.prepareStatement(sqlEstudiantes)) {
                        pstmtEstudiantes.setInt(1, idAlumno);

                        try (ResultSet rsEstudiantes = pstmtEstudiantes.executeQuery()) {
                            if (rsEstudiantes.next()) {
                                EstudianteModelo estudiante = mapResultSetToEstudiante(rsEstudiantes);
                                estudiantes.add(estudiante);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar los estudiantes por materia", e);
        }

        return estudiantes;
    }

    public ArrayList<EstudianteModelo> getEstudiantesByCarreraAndSemestreSinCalificaciones(String idCarrera, String semestre, String idMateria) {
        String sql = """
        SELECT a.* FROM Alumnos a
        LEFT JOIN Calificaciones c ON a.IdAlumno = c.IdAlumno AND c.IdMateria = ?
        WHERE a.IdCarrera = ? AND a.Semestre = ? AND c.IdAlumno IS NULL
        """;

        ArrayList<EstudianteModelo> estudiantes = new ArrayList<>();

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idMateria);
            pstmt.setString(2, idCarrera);
            pstmt.setString(3, semestre);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    EstudianteModelo estudiante = mapResultSetToEstudiante(rs);
                    estudiantes.add(estudiante);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar los estudiantes sin calificaciones para la materia especificada", e);
        }
        return estudiantes;
    }

    public boolean insertarCalificacion(EstudianteModelo alumno, String idDocente, String idMateria, String idPeriodo) {

        String sql = "INSERT INTO Calificaciones (IdAlumno, IdDocente, IdMateria, IdPeriodo) VALUES (?, ?, ?, ?)";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, alumno.getId()); // IdAlumno
            pstmt.setString(2, idDocente); // IdDocente
            pstmt.setString(3, idMateria); // IdMateria
            pstmt.setString(4, idPeriodo); // IdPeriodo

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar calificación: " + e.getMessage());
            return false;
        }
    }

    public boolean insertarCalificaciones(ArrayList<EstudianteModelo> estudiantes, String idDocente, String idMateria, String idPeriodo) {
        // Consultas SQL
        String sqlVerificacion = "SELECT COUNT(*) FROM Calificaciones WHERE IdAlumno = ? AND IdMateria = ?";
        String sqlInsercion = "INSERT INTO Calificaciones (IdAlumno, IdDocente, IdMateria, IdPeriodo) VALUES (?, ?, ?, ?)";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmtVerificacion = conn.prepareStatement(sqlVerificacion); PreparedStatement pstmtInsercion = conn.prepareStatement(sqlInsercion)) {

            conn.setAutoCommit(false);

            boolean exito = true;

            for (EstudianteModelo estudiante : estudiantes) {
                // Verificar si el registro ya existe
                pstmtVerificacion.setString(1, estudiante.getId()); // IdAlumno
                pstmtVerificacion.setString(2, idMateria); // IdMateria

                try (ResultSet rsVerificacion = pstmtVerificacion.executeQuery()) {
                    if (rsVerificacion.next() && rsVerificacion.getInt(1) == 0) {
                        // Establecer los parámetros para la consulta de inserción
                        pstmtInsercion.setString(1, estudiante.getId()); // IdAlumno
                        pstmtInsercion.setString(2, idDocente); // IdDocente
                        pstmtInsercion.setString(3, idMateria); // IdMateria
                        pstmtInsercion.setString(4, idPeriodo); // IdPeriodo

                        // Añadir al batch
                        pstmtInsercion.addBatch();
                    } else {
                        System.out.println("El registro ya existe para IdAlumno: " + estudiante.getId() + "de IdMateria: " + idMateria);
                        exito = false; // Indicar que al menos una inserción no se realizó
                    }
                }
            }

            // Ejecutar todas las inserciones en batch
            int[] rowsAffected = pstmtInsercion.executeBatch();
            conn.commit();

            for (int rows : rowsAffected) {
                if (rows == PreparedStatement.EXECUTE_FAILED) {
                    // Si alguna inserción falló, revertir la transacción
                    conn.rollback();
                    return false;
                }
            }
            return exito;
        } catch (SQLException e) {
            System.out.println("Error al insertar calificaciones: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCalificaciones(String idAlumno, String idMateria) {

        String sql = "DELETE FROM Calificaciones WHERE IdAlumno = ? AND IdMateria = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idAlumno); // IdAlumno
            pstmt.setString(2, idMateria); // IdMateria

            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar calificaciones: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarGrupoEstudiantes(String idGrupo, ArrayList<EstudianteModelo> estudiantes) {
        // Consulta SQL para actualizar el IdGrupo basado en la matrícula
        String sql = "UPDATE Alumnos SET IdGrupo = ? WHERE Matricula = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Iterar sobre la lista de estudiantes y actualizar el IdGrupo
            for (EstudianteModelo estudiante : estudiantes) {
                pstmt.setString(1, idGrupo); // Nuevo IdGrupo que se pasa como parámetro
                pstmt.setString(2, estudiante.getMatricula()); // La matrícula del estudiante a actualizar
                pstmt.addBatch(); // Añadir a batch para ejecutar en bloque
            }

            // Ejecutar todas las actualizaciones en un solo batch
            int[] affectedRows = pstmt.executeBatch();
            return affectedRows.length > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar IdGrupo de los estudiantes", e);
        }
    }

public boolean actualizarIdGrupoEstudiante(String idGrupo, EstudianteModelo estudiante) {
        // Consulta SQL para actualizar el IdGrupo de un solo estudiante basado en su matrícula
        String sql = "UPDATE Alumnos SET IdGrupo = ? WHERE Matricula = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asignar los valores al PreparedStatement
            pstmt.setString(1, idGrupo); // Nuevo IdGrupo que se pasa como parámetro
            pstmt.setString(2, estudiante.getMatricula()); // La matrícula del estudiante a actualizar

            // Ejecutar la actualización
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar IdGrupo del estudiante", e);
        }
    }

}

package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.PersonalModelo;
import operaciones.conexion.Conexion;

public class OpPersonal {

    private Connection conn;

    public OpPersonal() {
        conn = new Conexion().connect();
    }

    // Obtener todos los registros de Personal
    public ArrayList<PersonalModelo> getPersonales() {
        ArrayList<PersonalModelo> lista = new ArrayList<>();
        String sql = "SELECT RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, Matricula, Password, Foto FROM Personal";

        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PersonalModelo personal = mapResultSetToPersonal(rs);
                lista.add(personal);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar registros de personal", e);
        }
        return lista;
    }

    // Buscar personal por filtro
    public ArrayList<PersonalModelo> buscarPersonales(String where, String filtro) {
        ArrayList<PersonalModelo> resultados = new ArrayList<>();
        String sql = "SELECT * FROM Personal WHERE " + where + " LIKE ? ";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, filtro + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PersonalModelo personal = mapResultSetToPersonal(rs);
                    resultados.add(personal);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar registros de personal", e);
        }
        return resultados;
    }

    // Mapear ResultSet a PersonalModelo
    private PersonalModelo mapResultSetToPersonal(ResultSet rs) throws SQLException {
        PersonalModelo personal = new PersonalModelo();
        personal.setRfc(rs.getString("RFC"));
        personal.setCurp(rs.getString("CURP"));
        personal.setNombre(rs.getString("Nombre"));
        personal.setApPat(rs.getString("ApellidoPaterno"));
        personal.setApMat(rs.getString("ApellidoMaterno"));
        personal.setGenero(rs.getString("Genero"));
        personal.setCorreoPer(rs.getString("CorreoPersonal"));
        personal.setCorreoIns(rs.getString("CorreoInstitucional"));
        personal.setDomicilio(rs.getString("Domicilio"));
        personal.setCelular(rs.getString("Celular"));
        personal.setEstado(rs.getString("Estado"));
        personal.setMunicipio(rs.getString("Municipio"));
        personal.setMatricula(rs.getString("Matricula"));
        personal.setPassword(rs.getString("Password"));
        personal.setFoto(rs.getString("Foto"));
        return personal;
    }

    // Actualizar un registro de personal
    public boolean updatePersonal(PersonalModelo personalModelo) {
        String sql = "UPDATE Personal SET CURP = ?, Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Genero = ?, "
                + "CorreoPersonal = ?, CorreoInstitucional = ?, Domicilio = ?, Celular = ?, Estado = ?, Municipio = ?, Matricula = ?, Password = ?"
                + (personalModelo.getFoto() != null ? ", Foto = ? " : "")
                + " WHERE RFC = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, personalModelo.getCurp());
            pstmt.setString(2, personalModelo.getNombre());
            pstmt.setString(3, personalModelo.getApPat());
            pstmt.setString(4, personalModelo.getApMat());
            pstmt.setString(5, personalModelo.getGenero());
            pstmt.setString(6, personalModelo.getCorreoPer());
            pstmt.setString(7, personalModelo.getCorreoIns());
            pstmt.setString(8, personalModelo.getDomicilio());
            pstmt.setString(9, personalModelo.getCelular());
            pstmt.setString(10, personalModelo.getEstado());
            pstmt.setString(11, personalModelo.getMunicipio());
            pstmt.setString(12, personalModelo.getMatricula());
            pstmt.setString(13, personalModelo.getPassword());
            if (personalModelo.getFoto() != null) {
                pstmt.setString(14, personalModelo.getFoto());
                pstmt.setString(15, personalModelo.getRfc());
            } else {
                pstmt.setString(14, personalModelo.getRfc());
            }

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar registro de personal", e);
        }
    }

    // Eliminar un registro de personal
    public boolean deletePersonal(String rfc) {
        String sql = "DELETE FROM Personal WHERE RFC = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rfc);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar registro de personal", e);
        }
    }

    // Recuperar un registro de personal por RFC
    public PersonalModelo retornarPersonal(String rfc) {
        String sql = "SELECT RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, Matricula, Password, Foto FROM Personal WHERE RFC = ?";
        PersonalModelo personal = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rfc);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    personal = mapResultSetToPersonal(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar registro de personal", e);
        }
        return personal;
    }

    // Método para agregar un nuevo registro de personal
    public boolean crearPersonal(PersonalModelo personalModelo) {
        String sql = "INSERT INTO Personal (RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, Matricula, Password"
                + (personalModelo.getFoto() != null ? ", Foto" : "")
                + " ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                + (personalModelo.getFoto() != null ? ", ?" : "")
                + " )";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, personalModelo.getRfc());
            pstmt.setString(2, personalModelo.getCurp());
            pstmt.setString(3, personalModelo.getNombre());
            pstmt.setString(4, personalModelo.getApPat());
            pstmt.setString(5, personalModelo.getApMat());
            pstmt.setString(6, personalModelo.getGenero());
            pstmt.setString(7, personalModelo.getCorreoPer());
            pstmt.setString(8, personalModelo.getCorreoIns());
            pstmt.setString(9, personalModelo.getDomicilio());
            pstmt.setString(10, personalModelo.getCelular());
            pstmt.setString(11, personalModelo.getEstado());
            pstmt.setString(12, personalModelo.getMunicipio());
            pstmt.setString(13, personalModelo.getMatricula());
            pstmt.setString(14, personalModelo.getPassword());
            if (personalModelo.getFoto() != null) {
                pstmt.setString(15, personalModelo.getFoto());
            }

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear registro de personal", e);
        }
    }
}

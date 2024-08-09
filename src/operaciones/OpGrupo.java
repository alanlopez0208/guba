package operaciones;

import operaciones.conexion.Conexion;
import modelos.GrupoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.CarrerasModelo;
import modelos.MateriaModelo;

public class OpGrupo {

    private Connection conn;

    public OpGrupo() {
        conn = new Conexion().connect();
    }

    // Método para mapear un ResultSet a un objeto GrupoModelo
    private GrupoModelo mapResultSetToGrupo(ResultSet rs) throws SQLException {
        GrupoModelo grupo = new GrupoModelo();

        OpCarreras opCarrera = new OpCarreras();
        CarrerasModelo carrera = opCarrera.getCarreraByd(rs.getString("IdCarrera"));

        grupo.setId(rs.getString("IdGrupo"));
        grupo.setNombre(rs.getString("Nombre"));
        grupo.setSemestre(rs.getString("Semestre"));

        grupo.setCarrera(carrera);
        return grupo;
    }

    // Método para obtener todos los grupos
    public ArrayList<GrupoModelo> getGrupos() {
        ArrayList<GrupoModelo> listaGrupos = new ArrayList<>();
        String sql = "SELECT * FROM Grupos";

        try (Connection conn = new Conexion().connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                GrupoModelo grupo = mapResultSetToGrupo(rs);
                listaGrupos.add(grupo);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar todos grupos: " + e.getMessage());
        }
        return listaGrupos;
    }

    //Metodo para obtener las material del Grupo
    public ArrayList<MateriaModelo> getMateriasByGrupo(String idGrupo) {
        ArrayList<MateriaModelo> materias = new ArrayList<>();
        try {
            String sql = """
                        SELECT m.IdMateria , m.IdCarrera,m.Nombre, m.HBCA, m.HTI, m.Semestre, m.Creditos, m.Clave FROM GruposMaterias as gm JOIN Materias as m ON m.IdMateria = gm.IdMateria
                        JOIN Grupos as g ON g.IdGrupo = gm.IdGrupo WHERE g.IdGrupo = ?""";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idGrupo);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                MateriaModelo materia = new MateriaModelo();

                materia.setNombre(rs.getString("Nombre"));

                materia.setIdMateria(rs.getString("IdMateria"));
                materia.setHcba(rs.getString("HBCA"));
                materia.setHti(rs.getString("HTI"));
                materia.setSemestre(rs.getString("Semestre"));
                materia.setCreditos(rs.getString("Creditos"));
                materia.setCarrera(rs.getString("IdCarrera"));
                materia.setClave(rs.getString("Clave"));
                materias.add(materia);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las materias del grupo: " + e.getMessage());

        }
        return materias;

    }

    // método para agregar un grupo
    public boolean agregarGrupo(GrupoModelo grupo) {
        try {
            //   conn.setAutoCommit(false);
            //Primero insertamos el grupo
            String sql = "INSERT INTO Grupos (Nombre, Semestre, IdCarrera ) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());
            pstmt.setString(3, grupo.getCarrera().getIdCarrera());

            int rowAfecteds = pstmt.executeUpdate();
            conn.close();
            return rowAfecteds > 0;

        
        } catch (SQLException e) {
            System.out.println("Error al agregar grupo: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un grupo
    public boolean eliminarGrupo(int idGrupo) {
        String sql = "DELETE FROM Grupos WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idGrupo);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar grupo: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un grupo
    public boolean actualizarGrupo(GrupoModelo grupo) {
        String sentencia1 = "UPDATE Grupos SET Nombre = ?, Semestre = ?, IdCarrera = ? WHERE IdGrupo = ?";
        
        //System.out.println("INSERTANDO COSAS PERRONAS");
        try {
            //conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sentencia1);
            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());
            pstmt.setString(3, grupo.getCarrera().getIdCarrera());
            pstmt.setInt(4, Integer.parseInt(grupo.getId()));

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar grupo: " + e.getMessage());
            return false;
        }

    }

    //Metodo para eliminar todas materias del grupo
    public boolean eliminarMaterias(String idGrupo) {
        String sql = "DELETE FROM GruposMateria WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(idGrupo));
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar las materias del Grupo: " + e.getMessage());
            return false;
        }
    }

    // Método para seleccionar un grupo 
    public GrupoModelo seleccionarGrupo(int idGrupo) {
        String sql = "SELECT * FROM Grupos WHERE IdGrupo = ?";
        GrupoModelo grupoSeleccionado = null;

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idGrupo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                grupoSeleccionado = mapResultSetToGrupo(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar grupo: " + e.getMessage());
        }
        return grupoSeleccionado;
    }

    // Buscar docentes por filtro
    public ArrayList<GrupoModelo> buscarGrupos(String where, String filtro) {
        ArrayList<GrupoModelo> resultados = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM Grupos WHERE " + where + " LIKE ? ";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, filtro + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    GrupoModelo docente = mapResultSetToGrupo(rs);
                    resultados.add(docente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar docentes", e);
        }
        return resultados;
    }

    public GrupoModelo getGruposByCarreraAndSemestre(String idCarreras, String semestre) {
        GrupoModelo grupo = new GrupoModelo();
        String sql = "SELECT * FROM Grupos WHERE IdCarrera = ? AND Semestre = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idCarreras);
            pstmt.setString(2, semestre);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    grupo = mapResultSetToGrupo(rs);

                }
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar el grupo por carrera y semestre: " + e.getMessage());
        }
        return grupo;
    }

}

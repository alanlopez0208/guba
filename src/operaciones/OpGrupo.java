package operaciones;

import operaciones.conexion.Conexion;
import modelos.GrupoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.MateriaModelo;

public class OpGrupo {

    private Connection conn;

    public OpGrupo() {
        conn = new Conexion().connect();
    }

    // Método para mapear un ResultSet a un objeto GrupoModelo
    private GrupoModelo mapResultSetToGrupo(ResultSet rs) throws SQLException {
        GrupoModelo grupo = new GrupoModelo();
        grupo.setId(rs.getString("IdGrupo"));
        grupo.setNombre(rs.getString("Nombre"));
        grupo.setSemestre(rs.getString("Semestre"));
        return grupo;
    }

    // Método para obtener todos los grupos
    public ArrayList<GrupoModelo> getGrupos() {
        ArrayList<GrupoModelo> listaGrupos = new ArrayList<>();
        String sql = "SELECT IdGrupo, Nombre, Semestre FROM Grupos";

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
                        SELECT m.IdMateria , m.IdCarrera,m.Nombre, m.HBCA, m.HTI, m.Semestre, m.Creditos FROM GruposMaterias as gm JOIN Materias as m ON m.IdMateria = gm.IdMateria
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
            conn.setAutoCommit(false);
            //Primero insertamos el grupo
            String sql = "INSERT INTO Grupos (Nombre, Semestre) VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());

            int filasAfectadas = pstmt.executeUpdate();

            System.out.println("Si se puedo agregar un Grupo" + filasAfectadas);

            if (filasAfectadas < 0) {
                return false;
            }

            //Ahora obtenemos el id del grupo creado:
            String grupoNuevo = "";
            sql = "SELECT last_insert_rowid() as nuevo_grupo;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                return false;

            }

            grupoNuevo = rs.getString("nuevo_grupo");

            System.out.println("Si se pudo obtener el grupoId: " + grupoNuevo);

            sql = "INSERT INTO GruposMaterias (IdGrupo, IdMateria) VALUES (?, ?)";

            pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < grupo.getMaterias().size(); i++) {
                MateriaModelo materia = grupo.getMaterias().get(i);
                pstmt.setString(1, grupoNuevo);
                pstmt.setString(2, materia.getIdMateria());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();
            conn.close();

            return true;

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
    public boolean actualizarGrupo(GrupoModelo grupo, boolean mismasMaterias) {

        String sentencia1 = "UPDATE Grupos SET Nombre = ?, Semestre = ? WHERE IdGrupo = ?";
        String sentencia2 = "DELETE FROM GruposMaterias WHERE IdGrupo = ?";
        String sentencia3 = "INSERT INTO GruposMaterias (IdGrupo, IdMateria) VALUES (?, ?)";

        System.out.println("INSERTANDO COSAS PERRONAS");
        try {
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sentencia1);
            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());
            pstmt.setInt(3, Integer.parseInt(grupo.getId()));

            int rowAfected = pstmt.executeUpdate();

            if (!(rowAfected > 0)) {
                return false;
            }

            if (!mismasMaterias) {
                pstmt = conn.prepareStatement(sentencia2);
                pstmt.setInt(1, Integer.parseInt(grupo.getId()));
                rowAfected = pstmt.executeUpdate();
                if (!(rowAfected > 0)) {
                    return false;
                }
                pstmt = conn.prepareStatement(sentencia3);
                for (int i = 0; i < grupo.getMaterias().size(); i++) {
                    MateriaModelo materia = grupo.getMaterias().get(i);
                    pstmt.setString(1, grupo.getId());
                    pstmt.setString(2, materia.getIdMateria());
                    pstmt.addBatch();
                }
                System.out.println("SI SE PASO EL INSERT ");
                pstmt.executeBatch();
            }

            conn.commit();
            conn.close();

            return true;

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
        String sql = "SELECT IdGrupo, Nombre, Semestre FROM Grupos WHERE IdGrupo = ?";
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

}

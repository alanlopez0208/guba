
package modelos;


public class GrupoMateriaModelo {
    
    
    private String idGrupoMateria;
    private String idGrupo;
    private String idMateria;

    
    public GrupoMateriaModelo() {
    }

    public GrupoMateriaModelo(String idGrupo, String idMateria) {
        this.idGrupo = idGrupo;
        this.idMateria = idMateria;
    }

    public String getIdGrupoMateria() {
        return idGrupoMateria;
    }

    public void setIdGrupoMateria(String idGrupoMateria) {
        this.idGrupoMateria = idGrupoMateria;
    }
    
    
    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }
}

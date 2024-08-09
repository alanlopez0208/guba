
package modelos;


public class GrupoMateriaModelo {
    
    private String idGrupoMateria;
    private String idGrupo;
    private MateriaModelo materia;
    private MaestroModelo maestro;
    private int cursada;
    
    public GrupoMateriaModelo() {
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

    public MateriaModelo getMateria() {
        return materia;
    }

    public void setMateria(MateriaModelo materia) {
        this.materia = materia;
    }

    public MaestroModelo getMaestro() {
        return maestro;
    }

    public void setMaestro(MaestroModelo maestro) {
        this.maestro = maestro;
    }

    public int getCursada() {
        return cursada;
    }

    public void setCursada(int cursada) {
        this.cursada = cursada;
    }

  
}

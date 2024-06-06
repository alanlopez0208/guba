package modelos;

import java.util.ArrayList;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;


public class GrupoModelo {
    
    String id;
    String nombre;
    String semestre;
    ArrayList<MateriaModelo> materias;
    
    
     public GrupoModelo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    


   
  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public ArrayList<MateriaModelo> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<MateriaModelo> materias) {
        this.materias = materias;
    }
    
    
    
     public Object[] toRowTable(EventoAccion evento){
             return new Object[]{this.getId(), this.getNombre(), this.semestre, new AccionModelo(this, evento)};
   
    }
    
}

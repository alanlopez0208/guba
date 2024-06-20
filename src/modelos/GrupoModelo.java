package modelos;

import java.util.ArrayList;
import java.util.Objects;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;


public class GrupoModelo {
    
    String id;
    String nombre;
    String semestre;
    ArrayList<MateriaModelo> materias;

    public GrupoModelo() {
    }

    
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

    @Override
    public String toString() {
        return  nombre + " semestre: "+semestre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.semestre);
        hash = 83 * hash + Objects.hashCode(this.materias);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GrupoModelo other = (GrupoModelo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.semestre, other.semestre)) {
            return false;
        }
        return Objects.equals(this.materias, other.materias);
    }
    
}

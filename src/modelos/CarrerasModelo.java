package modelos;

import java.util.Objects;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class CarrerasModelo {

    private String idCarrera;
    private String idClave;
    private String nombre;
    private String hbca;
    private String creditos;
    private String totalHoras;
    private String modalidad;
    private String totalAsignaturas;
    private String hti;

    public CarrerasModelo() {
    }

    public String getHti() {
        return hti;
    }

    public void setHti(String hti) {
        this.hti = hti;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getIdClave() {
        return idClave;
    }

    public void setIdClave(String idClave) {
        this.idClave = idClave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHbca() {
        return hbca;
    }

    public void setHbca(String hbca) {
        this.hbca = hbca;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(String totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTotalAsignaturas() {
        return totalAsignaturas;
    }

    public void setTotalAsignaturas(String totalAsignaturas) {
        this.totalAsignaturas = totalAsignaturas;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idCarrera);
        hash = 67 * hash + Objects.hashCode(this.idClave);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.hbca);
        hash = 67 * hash + Objects.hashCode(this.creditos);
        hash = 67 * hash + Objects.hashCode(this.totalHoras);
        hash = 67 * hash + Objects.hashCode(this.modalidad);
        hash = 67 * hash + Objects.hashCode(this.totalAsignaturas);
        hash = 67 * hash + Objects.hashCode(this.hti);
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
        final CarrerasModelo other = (CarrerasModelo) obj;
        if (!Objects.equals(this.idCarrera, other.idCarrera)) {
            return false;
        }
        if (!Objects.equals(this.idClave, other.idClave)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.hbca, other.hbca)) {
            return false;
        }
        if (!Objects.equals(this.creditos, other.creditos)) {
            return false;
        }
        if (!Objects.equals(this.totalHoras, other.totalHoras)) {
            return false;
        }
        if (!Objects.equals(this.modalidad, other.modalidad)) {
            return false;
        }
        if (!Objects.equals(this.totalAsignaturas, other.totalAsignaturas)) {
            return false;
        }
        return Objects.equals(this.hti, other.hti);
    }
    
    
    public Object[] toRowTable(EventoAccion eventoAccion) {
        return new Object[]{
        this.getIdClave(), this.getNombre(), this.getCreditos(),this.getModalidad(), new AccionModelo(this, eventoAccion),
        };
    }

}

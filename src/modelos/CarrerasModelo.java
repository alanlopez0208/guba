package modelos;

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

}

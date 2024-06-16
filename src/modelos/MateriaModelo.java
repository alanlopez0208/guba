package modelos;

public class MateriaModelo {

    String clave;
    String idMateria;
    String nombre;
    String hcba;
    String hti;
    String creditos;
    String carrera;
    String semestre;

    public MateriaModelo() {
    }

    public MateriaModelo(String clave, String nombre, String hcba, String hti, String creditos, String carrera) {
        this.clave = clave;
        this.nombre = nombre;
        this.hcba = hcba;
        this.hti = hti;
        this.creditos = creditos;
        this.carrera = carrera;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHcba() {
        return hcba;
    }

    public void setHcba(String hcba) {
        this.hcba = hcba;
    }

    public String getHti() {
        return hti;
    }

    public void setHti(String hti) {
        this.hti = hti;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return  nombre;
    }

}

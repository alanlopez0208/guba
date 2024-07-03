package modelos;

import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class MateriaModelo {

    String id;
    String idMateria;
    String nombre;
    String hcba;
    String hti;
    String creditos;
    String carrera;
    String semestre;
    CarrerasModelo carreraModelo;
    String modalidad;

    public MateriaModelo() {
    }

    public MateriaModelo(String clave, String nombre, String hcba, String hti, String creditos, String carrera) {
        this.id = clave;
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
        return id;
    }

    public void setClave(String clave) {
        this.id = clave;
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

    public CarrerasModelo getCarreraModelo() {
        return carreraModelo;
    }

    public void setCarreraModelo(CarrerasModelo carreraModelo) {
        this.carreraModelo = carreraModelo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
    
    

    @Override
    public String toString() {
        return nombre;
    }

    public Object[] toRowTable(EventoAccion eventoAccion) {
        return new Object[]{
            this.getNombre(), this.getCreditos(), this.getSemestre(), this.getCarreraModelo().getNombre(), this.getModalidad() ,new AccionModelo(this, eventoAccion)
        };
    }

}

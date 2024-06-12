package modelos;

import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class EstudianteModelo {
    
    private String matricula;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String emailPersonal;
    private String emailInstitucional;
    private String generacion;
    private String numCelular;
    private String estado;
    private String municipio;
    private String escProcedencia;
    private String grado;
    private String grupo;
    private String Status;
    private String password;
    private String passwordTemporal;
    
    
    

    public EstudianteModelo() {
    }

    public EstudianteModelo(String matricula, String nombre, String apPaterno, String apMaterno) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    public EstudianteModelo(String matricula, String nombre, String apPaterno, String apMaterno, String emailPersonal, String emailInstitucional, String generacion, String numCelular, String estado, String municipio, String escProcedencia, String grado, String grupo, String semestre, String status ) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.emailPersonal = emailPersonal;
        this.emailInstitucional = emailInstitucional;
        this.generacion = generacion;
        this.numCelular = numCelular;
        this.estado = estado;
        this.municipio = municipio;
        this.escProcedencia = escProcedencia;
        this.grado = grado;
        this.grupo = grupo;
        this.Status = status;
    }

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEscProcedencia() {
        return escProcedencia;
    }

    public void setEscProcedencia(String escProcedencia) {
        this.escProcedencia = escProcedencia;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

  
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordTemporal() {
        return passwordTemporal;
    }

    public void setPasswordTemporal(String passwordTemporal) {
        this.passwordTemporal = passwordTemporal;
    }
    
    

    public Object[] toRowTable(EventoAccion evento) {
        return new Object[]{this.getMatricula(), this.getNombre(),this.getApPaterno(),this.getApMaterno(), new AccionModelo(this, evento)};
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

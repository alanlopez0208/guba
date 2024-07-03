package modelos;

import java.util.ArrayList;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class PersonalModelo {

    private String rfc;
    private String curp;
    private String nombre;
    private String apPat;
    private String apMat;
    private String genero;
    private String correoPer;
    private String correoIns;
    private String domicilio;
    private String celular;
    private String estado;
    private String municipio;
    private String matricula;
    private String password;
    private String foto;

    public PersonalModelo() {
    }

    public PersonalModelo(String rfc, String curp, String nombre, String apPat, String apMat, String genero, String correoPer, String correoIns, String domicilio, String celular, String estado, String municipio, String matricula, String password, String foto) {
        this.rfc = rfc;
        this.curp = curp;
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.genero = genero;
        this.correoPer = correoPer;
        this.correoIns = correoIns;
        this.domicilio = domicilio;
        this.celular = celular;
        this.estado = estado;
        this.municipio = municipio;
        this.matricula = matricula;
        this.password = password;
        this.foto = foto;
    }


    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreoPer() {
        return correoPer;
    }

    public void setCorreoPer(String correoPer) {
        this.correoPer = correoPer;
    }

    public String getCorreoIns() {
        return correoIns;
    }

    public void setCorreoIns(String correoIns) {
        this.correoIns = correoIns;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswordTemp() {
        return password;
    }

    public void setPasswordTemp(String passwordTemp) {
        this.password = passwordTemp;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public Object[] toRowTable(EventoAccion evento) {
        return new Object[]{this.getRfc(), this.getNombre(), this.getApPat(), this.getApMat(), new AccionModelo(this, evento)};

    }
}

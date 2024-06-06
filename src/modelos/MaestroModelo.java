package modelos;

import java.util.ArrayList;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;


public class MaestroModelo {
    private String rfc;
    private String curp;
    private String apPat;
    private String nombre;
    private String apMat;
    private String genero;
    private String correoPer;
    private String correoIns;
    private String domicilio;
    private String celular;
    private String estado;
    private String municipio;
    private String cv;
    private String grado;
    ArrayList<MateriaModelo> materias;


    public MaestroModelo(String rfc, String curp, String apPat, String nombre, String apMat, String genero, String correoPer, String correoIns, String domicilio, String celular, String estado, String municipio, String cv, String grado) {
        this.rfc = rfc;
        this.curp = curp;
        this.apPat = apPat;
        this.nombre = nombre;
        this.apMat = apMat;
        this.genero = genero;
        this.correoPer = correoPer;
        this.correoIns = correoIns;
        this.domicilio = domicilio;
        this.celular = celular;
        this.estado = estado;
        this.municipio = municipio;
        this.cv = cv;
        this.grado = grado;
    }

    public MaestroModelo(String rfc, String curp, String apPat, String nombre, String apMat, String genero, String correoPer, String correoIns, String domicilio, String celular, String estado, String municipio, String cv, String grado, ArrayList<MateriaModelo> materias) {
        this.rfc = rfc;
        this.curp = curp;
        this.apPat = apPat;
        this.nombre = nombre;
        this.apMat = apMat;
        this.genero = genero;
        this.correoPer = correoPer;
        this.correoIns = correoIns;
        this.domicilio = domicilio;
        this.celular = celular;
        this.estado = estado;
        this.municipio = municipio;
        this.cv = cv;
        this.grado = grado;
        this.materias = materias;
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

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
  
    
    public Object[] toRowTable(EventoAccion evento){
             return new Object[]{this.getRfc(), this.getNombre(), this.getApPat(), this.getApMat(), new AccionModelo(this, evento)};
   
    }
}

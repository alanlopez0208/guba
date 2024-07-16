package modelos;

import java.util.ArrayList;
import java.util.Objects;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class MaestroModelo {

    private String id;
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
    private String passwordTemp;
    private String foto;

    ArrayList<GrupoModelo> grupos;

    public MaestroModelo() {
    }

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

    public MaestroModelo(String rfc, String curp, String apPat, String nombre, String apMat, String genero, String correoPer, String correoIns, String domicilio, String celular, String estado, String municipio, String cv, String grado, ArrayList<GrupoModelo> grupos) {
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
        this.grupos = grupos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPasswordTemp() {
        return passwordTemp;
    }

    public void setPasswordTemp(String passwordTemp) {
        this.passwordTemp = passwordTemp;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ArrayList<GrupoModelo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<GrupoModelo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.rfc);
        hash = 53 * hash + Objects.hashCode(this.curp);
        hash = 53 * hash + Objects.hashCode(this.apPat);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.apMat);
        hash = 53 * hash + Objects.hashCode(this.genero);
        hash = 53 * hash + Objects.hashCode(this.correoPer);
        hash = 53 * hash + Objects.hashCode(this.correoIns);
        hash = 53 * hash + Objects.hashCode(this.domicilio);
        hash = 53 * hash + Objects.hashCode(this.celular);
        hash = 53 * hash + Objects.hashCode(this.estado);
        hash = 53 * hash + Objects.hashCode(this.municipio);
        hash = 53 * hash + Objects.hashCode(this.cv);
        hash = 53 * hash + Objects.hashCode(this.grado);
        hash = 53 * hash + Objects.hashCode(this.passwordTemp);
        hash = 53 * hash + Objects.hashCode(this.foto);
        hash = 53 * hash + Objects.hashCode(this.grupos);
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
        final MaestroModelo other = (MaestroModelo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.curp, other.curp)) {
            return false;
        }
        if (!Objects.equals(this.apPat, other.apPat)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apMat, other.apMat)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.correoPer, other.correoPer)) {
            return false;
        }
        if (!Objects.equals(this.correoIns, other.correoIns)) {
            return false;
        }
        if (!Objects.equals(this.domicilio, other.domicilio)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        if (!Objects.equals(this.cv, other.cv)) {
            return false;
        }
        if (!Objects.equals(this.grado, other.grado)) {
            return false;
        }
        if (!Objects.equals(this.passwordTemp, other.passwordTemp)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        return Objects.equals(this.grupos, other.grupos);
    }



    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApPat() + " " + this.getApMat();
    }

    public Object[] toRowTable(EventoAccion evento) {
        return new Object[]{this.getRfc(), this.getNombre(), this.getApPat(), this.getApMat(), new AccionModelo(this, evento)};

    }

}

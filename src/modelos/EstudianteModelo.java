package modelos;

import java.util.Objects;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class EstudianteModelo {
    
    private String id;
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
    private String foto;
    private String sexo;
    private String semestre;
    private CarrerasModelo carrera;
    private String direccion;
    private String nacimiento;
    

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public CarrerasModelo getCarrera() {
        return carrera;
    }

    public void setCarrera(CarrerasModelo carrera) {
        this.carrera = carrera;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    public Object[] toRowTable(EventoAccion evento) {
        return new Object[]{this.getMatricula(), this.getNombre(),this.getApPaterno(),this.getApMaterno(), new AccionModelo(this, evento)};
    }

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApPaterno() + " " + this.getApMaterno();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.matricula);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apPaterno);
        hash = 59 * hash + Objects.hashCode(this.apMaterno);
        hash = 59 * hash + Objects.hashCode(this.emailPersonal);
        hash = 59 * hash + Objects.hashCode(this.emailInstitucional);
        hash = 59 * hash + Objects.hashCode(this.generacion);
        hash = 59 * hash + Objects.hashCode(this.numCelular);
        hash = 59 * hash + Objects.hashCode(this.estado);
        hash = 59 * hash + Objects.hashCode(this.municipio);
        hash = 59 * hash + Objects.hashCode(this.escProcedencia);
        hash = 59 * hash + Objects.hashCode(this.grado);
        hash = 59 * hash + Objects.hashCode(this.grupo);
        hash = 59 * hash + Objects.hashCode(this.Status);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.passwordTemporal);
        hash = 59 * hash + Objects.hashCode(this.foto);
        hash = 59 * hash + Objects.hashCode(this.sexo);
        hash = 59 * hash + Objects.hashCode(this.semestre);
        hash = 59 * hash + Objects.hashCode(this.carrera);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + Objects.hashCode(this.nacimiento);
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
        final EstudianteModelo other = (EstudianteModelo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apPaterno, other.apPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apMaterno, other.apMaterno)) {
            return false;
        }
        if (!Objects.equals(this.emailPersonal, other.emailPersonal)) {
            return false;
        }
        if (!Objects.equals(this.emailInstitucional, other.emailInstitucional)) {
            return false;
        }
        if (!Objects.equals(this.generacion, other.generacion)) {
            return false;
        }
        if (!Objects.equals(this.numCelular, other.numCelular)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        if (!Objects.equals(this.escProcedencia, other.escProcedencia)) {
            return false;
        }
        if (!Objects.equals(this.grado, other.grado)) {
            return false;
        }
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        if (!Objects.equals(this.Status, other.Status)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.passwordTemporal, other.passwordTemporal)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.semestre, other.semestre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.nacimiento, other.nacimiento)) {
            return false;
        }
        return Objects.equals(this.carrera, other.carrera);
    }

   

}

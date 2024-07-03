package modelos;

import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class PagoAlumnosModelo {
    String idPago;
    String idAlumno;
    String fecha;
    String cantidad;
    String concepto;
    EstudianteModelo estudiante;

    public PagoAlumnosModelo() {
    }

    public PagoAlumnosModelo(String idPago, String idAlumno, String fecha, String cantidad, String concepto) {
        this.idPago = idPago;
        this.idAlumno = idAlumno;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public EstudianteModelo getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteModelo estudiante) {
        this.estudiante = estudiante;
    }

    public Object[] toRowTable(EventoAccion evento) {
        return new Object[]{this.estudiante.getNombre(), this.getFecha(), this.getCantidad(), this.getConcepto(), new AccionModelo(this, evento)};

    }
}

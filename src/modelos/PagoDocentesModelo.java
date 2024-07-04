package modelos;

import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;

public class PagoDocentesModelo {

    String idPago;
    String idMaestro;
    String fecha;
    String cantidad;
    String concepto;
    MaestroModelo maestro;

    public PagoDocentesModelo() {
    }

    public PagoDocentesModelo(String idPago, String idMaestro, String fecha, String cantidad, String concepto) {
        this.idPago = idPago;
        this.idMaestro = idMaestro;
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

    public String getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(String idMaestro) {
        this.idMaestro = idMaestro;
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

    public MaestroModelo getMaestro() {
        return maestro;
    }

    public void setMaestro(MaestroModelo maestro) {
        this.maestro = maestro;
    }

    public Object[] toRowTable(EventoAccion evento) {
        return new Object[]{this.maestro.getNombre(), this.getFecha(), this.getCantidad(), this.getConcepto(), new AccionModelo(this, evento)};
    }
}

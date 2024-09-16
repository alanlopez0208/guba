package swim.tabla;

public class AccionModelo {

    private Object modelo;
    private EventoAccion accion;
    private EventoEditar accionEditar;

    public AccionModelo(Object modelo, EventoAccion accion ) {
        this.modelo = modelo;
        this.accion = accion;
    }

    public AccionModelo(Object modelo, EventoEditar accionEditar) {
        this.modelo = modelo;
        this.accionEditar = accionEditar;
    }
    
    public Object getModelo() {
        return modelo;
    }

    public void setEstudiante(Object modelo) {
        this.modelo = modelo;
    }

    public EventoAccion getAccion() {
        return accion;
    }

    public void setAccion(EventoAccion accion) {
        this.accion = accion;
    }

    public EventoEditar getAccionEditar() {
        return accionEditar;
    }

    public void setAccionEditar(EventoEditar accionEditar) {
        this.accionEditar = accionEditar;
    }
}

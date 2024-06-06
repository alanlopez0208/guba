package swim.tabla;

public class AccionModelo {

    private Object modelo;
    private EventoAccion accion;

    public AccionModelo(Object modelo, EventoAccion accion ) {
        this.modelo = modelo;
        this.accion = accion;
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

}

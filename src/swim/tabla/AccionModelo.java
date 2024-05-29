package swim.tabla;

import modelos.EstudianteModelo;

public class AccionModelo {

    private EstudianteModelo estudiante;
    private EventoAccion accion;

    public AccionModelo(EstudianteModelo estudiante, EventoAccion accion ) {
        this.estudiante = estudiante;
        this.accion = accion;
    }

    public EstudianteModelo getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteModelo estudiante) {
        this.estudiante = estudiante;
    }

    public EventoAccion getAccion() {
        return accion;
    }

    public void setAccion(EventoAccion accion) {
        this.accion = accion;
    }

}

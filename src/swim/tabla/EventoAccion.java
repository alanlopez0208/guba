package swim.tabla;

import modelos.EstudianteModelo;

public interface EventoAccion {

    public void ver(EstudianteModelo modelo);

    public void borrar(EstudianteModelo modelo);

    public void editar(EstudianteModelo modelo);
}

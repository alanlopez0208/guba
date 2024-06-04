package operaciones;

import java.util.ArrayList;
import modelos.EstudianteModelo;

public class OpAlumno {

    public ArrayList<EstudianteModelo> getEstudiantes() {
        ArrayList<EstudianteModelo> lista = new ArrayList<>();

        // Crear 5 instancias de EstudianteModelo
        EstudianteModelo estudiante1 = new EstudianteModelo("2023001", "Juan", "Perez", "Lopez",
                "juan.perez@gmail.com", "jperez@institucional.edu", "2021", "5551234567",
                "Estado 1", "Municipio 1", "Escuela 1", "Grado 1", "Grupo A", "Semestre 1", "Activo");

        EstudianteModelo estudiante2 = new EstudianteModelo("2023002", "Maria", "Gomez", "Rodriguez",
                "maria.gomez@gmail.com", "mgomez@institucional.edu", "2021", "5551234568",
                "Estado 2", "Municipio 2", "Escuela 2", "Grado 2", "Grupo B", "Semestre 2", "Activo");

        EstudianteModelo estudiante3 = new EstudianteModelo("2023003", "Carlos", "Garcia", "Martinez",
                "carlos.garcia@gmail.com", "cgarcia@institucional.edu", "2021", "5551234569",
                "Estado 3", "Municipio 3", "Escuela 3", "Grado 3", "Grupo C", "Semestre 3", "Activo");

        EstudianteModelo estudiante4 = new EstudianteModelo("2023004", "Ana", "Lopez", "Hernandez",
                "ana.lopez@gmail.com", "alopez@institucional.edu", "2021", "5551234570",
                "Estado 4", "Municipio 4", "Escuela 4", "Grado 4", "Grupo D", "Semestre 4", "Activo");

        EstudianteModelo estudiante5 = new EstudianteModelo("2023005", "Luis", "Martinez", "Gonzalez",
                "luis.martinez@gmail.com", "lmartinez@institucional.edu", "2021", "5551234571",
                "Estado 5", "Municipio 5", "Escuela 5", "Grado 5", "Grupo E", "Semestre 5", "Activo");

        // Agregar las instancias a la lista
        lista.add(estudiante1);
        lista.add(estudiante2);
        lista.add(estudiante3);
        lista.add(estudiante4);
        lista.add(estudiante5);
        /**
         * //Aqui hay un ejemplo de for for (int i = 0; i < 10; i++) {
         * EstudianteModelo estudiante = new EstudianteModelo();
         * estudiante.setNombre(....); estudiante.setApMaterno(....); //y asi
         * sucesivamente }
         *
         */
        return lista;
    }

    //Metodo para actualizar alumno
    public boolean updateAlumno(EstudianteModelo estudianteModelo) {
            //Logica para actualizar
            //tiene que retornar true si se pudo y false si no
        return true;
    }

    //Metodo para eliminarAlumno
    public boolean deleteAlumno(String matricula) {
            //Logica para actualizar
            //tiene que retornar true si se pudo y false si no
        return true;
    }
}

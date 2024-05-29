package operaciones;

import java.util.ArrayList;
import modelos.CalificacionModelo;

public class OpCalificaciones {

    public ArrayList<CalificacionModelo> getCalificaciones(String matricula) {
        ArrayList<CalificacionModelo> lista = new ArrayList<>();

        CalificacionModelo calificacion1 = new CalificacionModelo();
        calificacion1.setSemestre("Primavera 2024");
      
        calificacion1.setGrupo("A");
        calificacion1.setMateria("Matemáticas");
        calificacion1.setU1P1(8.5f);
        calificacion1.setU1P2(9.0f);
        calificacion1.setU1P3(7.5f);
        calificacion1.setU2P1(8.0f);
        calificacion1.setU2P2(9.5f);
        calificacion1.setU2P3(8.0f);
        calificacion1.setTrabajoFinal(9.0f);

        CalificacionModelo calificacion2 = new CalificacionModelo();
        calificacion2.setSemestre("Otoño 2023");
      
        calificacion2.setGrupo("B");
        calificacion2.setMateria("Ciencias");
        calificacion2.setU1P1(7.0f);
        calificacion2.setU1P2(8.0f);
        calificacion2.setU1P3(7.5f);
        calificacion2.setU2P1(9.0f);
        calificacion2.setU2P2(8.5f);
        calificacion2.setU2P3(9.0f);
        calificacion2.setTrabajoFinal(8.0f);

        CalificacionModelo calificacion3 = new CalificacionModelo();
        calificacion3.setSemestre("Invierno 2023");
       
        calificacion3.setGrupo("C");
        calificacion3.setMateria("Historia");
        calificacion3.setU1P1(9.5f);
        calificacion3.setU1P2(8.5f);
        calificacion3.setU1P3(9.0f);
        calificacion3.setU2P1(7.0f);
        calificacion3.setU2P2(8.0f);
        calificacion3.setU2P3(8.5f);
        calificacion3.setTrabajoFinal(9.5f);

        CalificacionModelo calificacion4 = new CalificacionModelo();
        calificacion4.setSemestre("Verano 2022");
       
        calificacion4.setGrupo("D");
        calificacion4.setMateria("Arte");
        calificacion4.setU1P1(8.0f);
        calificacion4.setU1P2(7.5f);
        calificacion4.setU1P3(8.5f);
        calificacion4.setU2P1(9.0f);
        calificacion4.setU2P2(8.0f);
        calificacion4.setU2P3(7.0f);
        calificacion4.setTrabajoFinal(8.5f);

        CalificacionModelo calificacion5 = new CalificacionModelo();
        calificacion5.setSemestre("Primavera 2021");
       
        calificacion5.setGrupo("E");
        calificacion5.setMateria("Educación Física");
        calificacion5.setU1P1(9.0f);
        calificacion5.setU1P2(8.0f);
        calificacion5.setU1P3(9.5f);
        calificacion5.setU2P1(7.5f);
        calificacion5.setU2P2(8.5f);
        calificacion5.setU2P3(9.0f);
        calificacion5.setTrabajoFinal(8.0f);

        lista.add(calificacion1);
        lista.add(calificacion2);
        lista.add(calificacion3);
        lista.add(calificacion4);
        lista.add(calificacion5);
        return lista;
    }

    //Metodo para actualizar alumno
    public boolean updateAlumno(String matricula) {

        return true;
    }

    //Metodo para eliminarAlumno
    public boolean deleteAlumno(String matricula) {

        return true;
    }
}

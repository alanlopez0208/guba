package operaciones;

import java.util.ArrayList;
import modelos.MaestroModelo;

public class OpMaestro {

    public static ArrayList<MaestroModelo> getMaestros() {
        ArrayList<MaestroModelo> lista = new ArrayList<>();

        MaestroModelo maestro1 = new MaestroModelo(
            "RFC1", "CURP1", "ApellidoP1", "ApellidoM1", "Masculino", 
            "correo1@personal.com", "correo1@instituto.com", "Domicilio 1", 
            "1234567890", "Estado 1", "Municipio 1", "CV1", "Grado1"
        );

        MaestroModelo maestro2 = new MaestroModelo(
            "RFC2", "CURP2", "ApellidoP2", "ApellidoM2", "Femenino", 
            "correo2@personal.com", "correo2@instituto.com", "Domicilio 2", 
            "0987654321", "Estado 2", "Municipio 2", "CV2", "Grado2"
        );

        MaestroModelo maestro3 = new MaestroModelo(
            "RFC3", "CURP3", "ApellidoP3", "ApellidoM3", "Masculino", 
            "correo3@personal.com", "correo3@instituto.com", "Domicilio 3", 
            "1122334455", "Estado 3", "Municipio 3", "CV3", "Grado3"
        );

        MaestroModelo maestro4 = new MaestroModelo(
            "RFC4", "CURP4", "ApellidoP4", "ApellidoM4", "Femenino", 
            "correo4@personal.com", "correo4@instituto.com", "Domicilio 4", 
            "5566778899", "Estado 4", "Municipio 4", "CV4", "Grado4"
        );

        MaestroModelo maestro5 = new MaestroModelo(
            "RFC5", "CURP5", "ApellidoP5", "ApellidoM5", "Masculino", 
            "correo5@personal.com", "correo5@instituto.com", "Domicilio 5", 
            "6677889900", "Estado 5", "Municipio 5", "CV5", "Grado5"
        );

        lista.add(maestro1);
        lista.add(maestro2);
        lista.add(maestro3);
        lista.add(maestro4);
        lista.add(maestro5);

        return lista;
    }

    //Metodo para actualizar alumno
    public boolean updateAlumno(MaestroModelo maestroModelo) {
            //Logica para actualizar
            //tiene que retornar true si se pudo y false si no
        return true;
    }

    //Metodo para eliminarAlumno
    public boolean deleteAlumno(String rfc) {
            //Logica para actualizar
            //tiene que retornar true si se pudo y false si no
        return true;
    }
}

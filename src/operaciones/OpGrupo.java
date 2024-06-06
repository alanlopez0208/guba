package operaciones;

import java.util.ArrayList;
import modelos.GrupoModelo;

public class OpGrupo {
    
    
    
    public static ArrayList<GrupoModelo> getGrupos() {
        ArrayList<GrupoModelo> grupos = new ArrayList<>();

        // Crear instancias de GrupoModelo usando las listas de MateriaModelo
        grupos.add(new GrupoModelo(1, "Grupo A"));
        grupos.add(new GrupoModelo(2, "Grupo B"));
        grupos.add(new GrupoModelo(3, "Grupo C" ));
        grupos.add(new GrupoModelo(4, "Grupo D"));
        grupos.add(new GrupoModelo(5, "Grupo E"));

        return grupos;
    }
    
    
    
    
}

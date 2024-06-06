package operaciones;

import java.util.ArrayList;
import modelos.GrupoModelo;

public class OpGrupo {
    
    
    
    public static ArrayList<GrupoModelo> getGrupos() {
        ArrayList<GrupoModelo> grupos = new ArrayList<>();

        // Crear instancias de GrupoModelo usando las listas de MateriaModelo
        grupos.add(new GrupoModelo("GRP001", "Grupo A"));
        grupos.add(new GrupoModelo("GRP002", "Grupo B"));
        grupos.add(new GrupoModelo("GRP003", "Grupo C" ));
        grupos.add(new GrupoModelo("GRP004", "Grupo D"));
        grupos.add(new GrupoModelo("GRP005", "Grupo E"));

        return grupos;
    }
    
    
    
    
}

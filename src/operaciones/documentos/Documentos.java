package operaciones.documentos;

public enum Documentos {
    Boleta("Boleta"),
    Certificado("Certificado"),
    Constancia("Constancia"),
    Kardex("Kardex");

    private String nombre;

    private Documentos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}

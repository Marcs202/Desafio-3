package model;

public class Recurso {
    private String descripcion;
    private String enlace;
    private int id;
    private String imagen;
    private String tipo;
    private String titulo;

    public  Recurso(){}
    public Recurso(String descripcion, String enlace, int id, String imagen, String tipo, String titulo) {
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.id = id;
        this.imagen = imagen;
        this.tipo = tipo;
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public int getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }
}

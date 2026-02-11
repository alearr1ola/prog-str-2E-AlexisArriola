package Persona;

/**
 * Clase que define los datos de una Persona.
 */
public class Persona {
    public int id;
    public String nombre;
    public boolean activa;

    /**
     * Constructor para inicializar una nueva persona.
     */
    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activa = true;
    }
}


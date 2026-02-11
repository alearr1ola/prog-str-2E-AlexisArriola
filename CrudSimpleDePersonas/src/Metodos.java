package MetodosServicePersonas;


/**
 * Clase que contiene las operaciones del sistema.
 */
public class Metodos {

    /**
     * Busca si un ID ya existe en el arreglo para evitar duplicados.
     * @return true si el ID ya existe, false si no.
     */
    public static boolean idRepetido(Persona.Persona[] lista, int id) {
        for (Persona.Persona p : lista) {
            if (p != null && p.id == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un hueco vacío (null) en el arreglo.
     * @return El índice del hueco, o -1 si está lleno.
     */
    public static int buscarHueco(Persona.Persona[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca una persona activa por su ID.
     * @return El objeto Persona si lo halla y está activo, null si no.
     */
    public static Persona.Persona buscarPersonaActiva(Persona.Persona[] lista, int id) {
        for (Persona.Persona p : lista) {
            if (p != null && p.id == id && p.activa) {
                return p;
            }
        }
        return null;
    }
}
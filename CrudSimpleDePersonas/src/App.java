package Apps;

import java.util.Scanner;

/**
 * Clase principal que gestiona el menú y la interacción.
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona.Persona[] personas = new Persona.Persona[20];
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1. Alta, 2. Buscar por Id, 3. Baja logica por Id, 4. Listar activas, 5. Actualizar nombre por ID, 0. Salir");
            System.out.print("Opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Error: Ingresa un número.");
                sc.nextLine();
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: // ALTA
                    int hueco = MetodosServicePersonas.Metodos.buscarHueco(personas);
                    if (hueco == -1) {
                        System.out.println("Lista llena.");
                    } else {
                        System.out.print("ID (>0): ");
                        int id = sc.nextInt(); sc.nextLine();

                        // VALIDACIONES
                        if (id <= 0) {
                            System.out.println("ID inválido.");
                        } else if (MetodosServicePersonas.Metodos.idRepetido(personas, id)) {
                            System.out.println("Ese ID ya existe.");
                        } else {
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            if (nombre.trim().isEmpty()) {
                                System.out.println("El nombre no puede estar vacío.");
                            } else {
                                personas[hueco] = new Persona.Persona(id, nombre);
                                System.out.println("Guardado");
                            }
                        }
                    }
                    break;

                case 2: // BUSCAR
                    System.out.print("ID a buscar: ");
                    int idB = sc.nextInt(); sc.nextLine();
                    Persona.Persona encontrada = MetodosServicePersonas.Metodos.buscarPersonaActiva(personas, idB);
                    if (encontrada != null) {
                        System.out.println("Nombre: " + encontrada.nombre);
                    } else {
                        System.out.println("No encontrada o inactiva.");
                    }
                    break;

                case 3: // BAJA
                    System.out.print("ID para dar de baja: ");
                    int idLow = sc.nextInt(); sc.nextLine();
                    // Buscamos a la persona sin importar si ya estaba inactiva
                    boolean exitoBaja = false;
                    for (Persona.Persona p : personas) {
                        if (p != null && p.id == idLow) {
                            p.activa = false; // Baja lógica
                            System.out.println("Persona desactivada.");
                            exitoBaja = true;
                            break;
                        }
                    }
                    if (!exitoBaja) System.out.println("ID no encontrado.");
                    break;

                case 4: // LISTAR
                    System.out.println("\n-- Listado de Activos --");
                    for (Persona.Persona p : personas) {
                        if (p != null && p.activa) {
                            System.out.println("ID: " + p.id + " | Nombre: " + p.nombre);
                        }
                    }
                    break;

                case 5: // ACTUALIZAR
                    System.out.print("ID para actualizar: ");
                    int idAct = sc.nextInt(); sc.nextLine();
                    Persona.Persona pAct = MetodosServicePersonas.Metodos.buscarPersonaActiva(personas, idAct);
                    if (pAct != null) {
                        System.out.print("Nuevo nombre: ");
                        String nuevoN = sc.nextLine();
                        if (!nuevoN.trim().isEmpty()) {
                            pAct.nombre = nuevoN;
                            System.out.println("Actualizado.");
                        }
                    } else {
                        System.out.println("No disponible para actualizar.");
                    }
                    break;

                case 0: System.out.println("Fin"); break;
                default: System.out.println("Opción no válida.");
            }
        }
    }
}
package Mainn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ControlAlumnos control = new ControlAlumnos();

        int opcion;

        do {
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja logica");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Promedio: ");
                    double promedio = sc.nextDouble();
                    control.alta(id, nombre, promedio);
                    break;

                case 2:
                    System.out.print("ID: ");
                    control.buscarAlumno(sc.nextInt());
                    break;

                case 3:
                    System.out.print("ID: ");
                    int idAct = sc.nextInt();
                    System.out.print("Nuevo promedio: ");
                    double nuevo = sc.nextDouble();
                    control.actualizarPromedio(idAct, nuevo);
                    break;

                case 4:
                    System.out.print("ID: ");
                    control.baja(sc.nextInt());
                    break;
                case 5:
                    control.listar();
                    break;
                case 6:
                    control.reportes();
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }
}
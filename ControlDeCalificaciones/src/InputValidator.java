package src;

import java.util.Scanner;

public class InputValidator {

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }
    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                sc.nextLine();
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Error: valor fuera de rango (" + min + " - " + max + ")");
        }
    }
    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                sc.nextLine();
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Error: valor fuera del rango (" + min + " - " + max + ")");
        }
    }
    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                boolean valor = sc.nextBoolean();
                sc.nextLine();
                return valor;
            } else {
                sc.nextLine();
                System.out.println("Error: ingresa true o false");
            }
        }
    }
}

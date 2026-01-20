package ActRefactor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = pedirEntero(scanner, "num1: ");
        int b = pedirEntero(scanner, "num2: ");
        int c = pedirEntero(scanner, "num3: ");

        int suma = calcularLaSuma(a, b, c);
        int cantidad = 3;
        double promedio = calcularElPromedio(suma, cantidad);
        System.out.println("suma = " + suma);
        System.out.println("prom = " + promedio);

    }
    /**
     * Pide un número al usuario y lo devuelve
     * @param scanner para leer lo que escribio el usuario
     * @param mensaje le muestra que escribir al usuario
     * @return el número que escribió el usuario
     */
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Suma tres números y devuelve el resultado
     * @param a primer número
     * @param b segundo número
     * @param c tercer número
     * @return la suma de nuestros tres números
     */
    public static int calcularLaSuma(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Calcula el promedio dividiendo la suma entre la cantidad de números
     * @param suma la suma de los números
     * @param cantidad cuántos números se sumaron
     * @return el promedio como número decimal
     */
    public static double calcularElPromedio(int suma, int cantidad) {
        return (suma * 1.0) / cantidad;
    }
}
package NumAleatorio;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int fueraDeRango = 0;
    static int noNumericos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int intentos = 0;
        int limiteIntentos = 7;

        int secreto = random.nextInt(max) + min;
        boolean gano = false;

        System.out.println("Adivina el número entre 1-100");
        System.out.println("Tienes " + limiteIntentos + " intentos");

        while (intentos < limiteIntentos && !gano) {
            int valor = obtenerNumeroValido(min, max, scanner, "Intento " + (intentos +1) + ":");
            intentos++;

            if (valor == secreto) {
                System.out.println("¡Ganaste!");
                System.out.println("Lo lograste en " + intentos + " intentos");
                gano = true;
            } else if (valor > secreto) {
                System.out.println("El número secreto es menor");
            } else {
                System.out.println("El número secreto es mayor");
            }
        }

        if(gano == false){
            System.out.println("Perdiste :(");
            System.out.println("El número secreto eraa: " + secreto);
        }

        System.out.println("Entradas fuera de rango: " + fueraDeRango);
        System.out.println("Entradas no numéricas: " + noNumericos);
        scanner.close();
    }

    /**
     * Solicita al usuario un número que sea válido dentro de un rango.
     * Controla entradas no numéricas y valores fuera de rango,
     * incrementa nuestros contadores.
     *
     * @param min valor mínimo permitido
     * @param max valor máximo permitido
     * @param scanner objeto Scanner para leer la entrada del usuario
     * @param mensaje mensaje que se muestra al solicitar el número
     * @return un número entero válido dentro del rango especificado
     */
    public static int obtenerNumeroValido(int min, int max, Scanner scanner, String mensaje) {
        int valor;

        while (true) {
            System.out.println(mensaje);

            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();

                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Número fuera de rango 1-100");
                    fueraDeRango++;
                }
            } else {
                System.out.println("Entrada no numérica");
                noNumericos++;
                scanner.next();
            }
        }
    }
}
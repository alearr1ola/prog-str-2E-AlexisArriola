package ActBuenasPracticas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = obtenerEntero(sc);
        int suma = sumarHastaLimite(numero);

        System.out.println("La suma de todos los números del 1 hasta " + numero + " es: " + suma);

        sc.close();
    }

    /**
     * Pide al usuario que ingrese un número entero que no sea negativo
     * y repite la solicitud hasta que el usuario escriba un número válido
     * @param sc Objeto Scanner para leer la entrada del usuario
     * @return El número entero no negativo que fue ingresado por el usuario
     */
    public static int obtenerEntero(Scanner sc) {
        int valor;

        System.out.print("Ingresa un entero no negativo: ");
        valor = sc.nextInt();

        while (valor < 0) {
            System.out.print("Número no válido. Ingresa un entero no negativo: ");
            valor = sc.nextInt();
        }

        return valor;
    }

    /**
     * Calcula la suma de todos los números enteros desde 1 hasta un límite
     * @param limite El número hasta el cual se quiere sumar
     * @return La suma de todos los números desde 1 hasta el límite
     */
    public static int sumarHastaLimite(int limite) {
        int suma = 0;
        for (int i = 1; i <= limite; i++) {
            suma = suma + i;
        }
        return suma;
    }
}


package menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionMenu = 0;
        int contadorCelsiusAFahrenheit = 0;
        int contadorFahrenheitACelsius = 0;
        int contadorKmAMillas = 0;
        int contadorMillasAKm = 0;
        int totalConversiones = 0;

        do {
            System.out.println("1. Celsius a Fahrenheit");
            System.out.println("2. Fahrenheit a Celsius");
            System.out.println("3. Kilómetros a Millas");
            System.out.println("4. Millas a Kilómetros");
            System.out.println("5. Salir");

            while (true) {
                System.out.print("Selecciona una opción 1-5: ");
                if (scanner.hasNextInt()) {
                    opcionMenu = scanner.nextInt();
                    if (opcionMenu >= 1 && opcionMenu <= 5) {
                        break;
                    } else {
                        System.out.println("La opción debe estar entre 1 y 5");
                    }
                } else {
                    System.out.println("No ingresaste un valor numerico");
                    scanner.next();
                }
            }

            switch (opcionMenu) {

                case 1:
                    double gradosCelsius = obtenerNumeroDecimalValido(scanner, "Ingresa los grados Celsius:");
                    double resultadoFahrenheit = (gradosCelsius * 9 / 5) + 32;
                    System.out.println(gradosCelsius + " °C = " + resultadoFahrenheit + " °F");
                    contadorCelsiusAFahrenheit++;
                    totalConversiones++;
                    break;

                case 2:
                    double gradosFahrenheit = obtenerNumeroDecimalValido(scanner, "Ingresa los grados Fahrenheit:");
                    double resultadoCelsius = (gradosFahrenheit - 32) * 5 / 9;
                    System.out.println(gradosFahrenheit + " °F = " + resultadoCelsius + " °C");
                    contadorFahrenheitACelsius++;
                    totalConversiones++;
                    break;

                case 3:
                    double kilometros = obtenerNumeroDecimalValido(scanner, "Ingresa los kilómetros:");
                    double resultadoMillas = kilometros * 0.621371;
                    System.out.println(kilometros + " Km = " + resultadoMillas + " Millas");
                    contadorKmAMillas++;
                    totalConversiones++;
                    break;

                case 4:
                    double millas = obtenerNumeroDecimalValido(scanner, "Ingresa las millas:");
                    double resultadoKilometros = millas * 1.60934;
                    System.out.println(millas + " Millas = " + resultadoKilometros + " Km");
                    contadorMillasAKm++;
                    totalConversiones++;
                    break;

                case 5:
                    System.out.println("Saliendo");
                    break;
            }

        } while (opcionMenu != 5);
        System.out.println("Conversiones realizadas: " + totalConversiones);
        System.out.println("Celsius a Fahrenheit: " + contadorCelsiusAFahrenheit);
        System.out.println("Fahrenheit a Celsius: " + contadorFahrenheitACelsius);
        System.out.println("Kilómetros a Millas: " + contadorKmAMillas);
        System.out.println("Millas a Kilómetros: " + contadorMillasAKm);
        scanner.close();
    }

     public static double obtenerNumeroDecimalValido(Scanner scanner, String mensaje) {
        double numeroIngresado;
        while (true) {
            System.out.println(mensaje);
            if (scanner.hasNextDouble()) {
                numeroIngresado = scanner.nextDouble();
                return numeroIngresado;
            } else {
                System.out.println("Ingresa un valor numerico");
                scanner.next();
            }
        }
    }
}

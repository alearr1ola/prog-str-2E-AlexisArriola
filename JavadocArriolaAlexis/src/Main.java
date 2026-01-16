package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int OpcionDelMenu;

        do {
            System.out.println("Menú: ");
            System.out.println("1. Calcula el IMC");
            System.out.println("2. Calcula el área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular el área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Seleccionae una opción: ");

            OpcionDelMenu = scanner.nextInt();

            switch (OpcionDelMenu) {
                case 1:
                    System.out.print("Ingresa tu peso kg: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingresa tu altura en m: ");
                    double altura = scanner.nextDouble();
                    System.out.println("IMC: " + calcularIMC(peso, altura));
                    break;

                case 2:
                    System.out.print("Ingresa el largo: ");
                    double largo = scanner.nextDouble();
                    System.out.print("Ingresa el ancho: ");
                    double ancho = scanner.nextDouble();
                    System.out.println("el área del rectángulo: " + areaRectangulo(largo, ancho));
                    break;

                case 3:
                    System.out.print("Ingresa la temperatura en grados °C: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("La temperatura en grados °F: " + convertirCelsiusAFahrenheit(celsius));
                    break;

                case 4:
                    System.out.print("Ingresa el radio: ");
                    double radio = scanner.nextDouble();
                    System.out.println("Área del círculo: " + areaCirculo(radio));
                    break;

                case 5:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo");
            }

            System.out.println();

        } while (OpcionDelMenu != 5);

        scanner.close();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) de una persona
     * @param peso Peso de la persona en kilogramos
     * @param altura Altura de la persona en metros
     * @return El valor del IMC calculado
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Calcula el área de un rectángulo
     * @param largo Largo del rectángulo
     * @param ancho Ancho del rectángulo
     * @return Área del rectángulo
     */
    public static double areaRectangulo(double largo, double ancho) {
        return largo * ancho;
    }

    /**
     * Convierte grados Celsius a grados Fahrenheit
     * @param celsius Temperatura en grados Celsius
     * @return Temperatura convertida a Fahrenheit
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo a partir de su radio
     * @param radio El radio del círculo
     * @return El área del círculo despues de haber usado la fórmula de: A = π * radio²
     */
    public static double areaCirculo(double radio) {
        double pi = 3.1416;
        return pi * radio * radio;
    }
}
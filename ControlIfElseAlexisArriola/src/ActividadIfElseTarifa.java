import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int edad;
        boolean esEstudiante;
        int tarifa = 0;

        System.out.print("Ingrese la edad: ");
        edad = scanner.nextInt();

        if (edad <= 0 || edad >= 120) {
            System.out.println("Edad inválida");
            return;
        }

        System.out.print("Eres estudiante? Ingresa true o false: ");
        esEstudiante = scanner.nextBoolean();

        if (edad < 12) {
            tarifa = 50;

        } else if (edad >= 12 && edad <= 17) {

            if (esEstudiante == true) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }

        } else if (edad >= 18) {

            if (esEstudiante == true) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: " + tarifa);
    }
}
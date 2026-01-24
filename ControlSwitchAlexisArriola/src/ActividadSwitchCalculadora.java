package Switch;

import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Opciones disponibles:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print("Ingresa la opcion que desea realizar: ");

        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > 4) {
            System.out.println("Opción inválida");
            return;
        }

        System.out.print("Ingresa el valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingresa el valor de b: ");
        double b = scanner.nextDouble();
        double resultado;

        switch (opcion) {
            case 1:
                resultado = a + b;
                System.out.println("Elegiste: Sumar");
                System.out.println("los valores que ingresaste son: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                resultado = a - b;
                System.out.println("Elegiste: Restar");
                System.out.println("los valores que ingresaste son: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                resultado = a * b;
                System.out.println("Elegiste: Multiplicar");
                System.out.println("los valores que ingresaste son: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.println("Elegiste: Dividir");
                System.out.println("los valores que ingresaste son: a = " + a + ", b = " + b);

                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    System.out.println("Resultado: " + resultado);
                }
                break;
        }
    }
}
package Main;

import src.ShippingCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double peso = leerDoubleEnRango(sc, "Ingresa el peso en Kg 0.1 a 50: ", 0.1, 50.0);
        int distancia = leerIntEnRango(sc, "Ingresa la distancia en Km 1 a 2000: ", 1, 2000);
        int tipo = leerTipoServicio(sc, "Ingresa tipo de servicio 1=Estándar, 2=Express: ");
        boolean zonaRemota = leerBoolean(sc, "Es zona remota? true/false: ");

        ShippingCalculator envio = new ShippingCalculator();
        double subtotal = envio.calcularSubtotal(peso, distancia, tipo, zonaRemota);
        double iva = envio.calcularIVA(subtotal);
        double total = envio.calcularTotal(subtotal, iva);
        imprimirTicket(tipo, peso, distancia, zonaRemota, subtotal, iva, total);
    }
    /**
     * Pide al usuario un número decimal dentro de cierto rango
     * @param sc Scanner para leer datos
     * @param mensaje Mensaje que se muestra al usuario
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return El número decimal ingresado dentro del rango
     */
    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max) {
        double valor;
        do {
            System.out.println(mensaje);
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Pide al usuario un número entero dentro de un rango
     * @param sc Scanner para leer datos
     * @param mensaje Mensaje que se muestra al usuario
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return El número entero ingresado dentro del rango
     */
    public static int leerIntEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor;
        do {
            System.out.println(mensaje);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Pide al usuario un valor verdadero o falso
     * @param sc Scanner para leer datos
     * @param mensaje Mensaje que se muestra al usuario
     */
    public static boolean leerBoolean(Scanner sc, String mensaje) {
        String entrada;
        do {
            System.out.println(mensaje);
            entrada = sc.next();
        } while (!entrada.equals("true") && !entrada.equals("false"));

        return entrada.equals("true");
    }
    /**
     * Le pide al usuarioque seleccione el tipo de servicio: 1 = Estándar, 2 = Express
     * @param sc Scanner para leer datos
     * @param mensaje Mensaje que se muestra al usuario
     * @return 1 si es Estándar, 2 si es Express
     */
    public static int leerTipoServicio(Scanner sc, String mensaje) {
        int valor;
        do {
            System.out.println(mensaje);
            valor = sc.nextInt();
        } while (valor < 1 || valor > 2);
        return valor;
    }
    /**
     * Imprime un ticket de envío con todos los datos y los costos
     * @param tipo 1 = Estándar, 2 = Express
     * @param peso Peso en kg
     * @param distancia Distancia en km
     * @param zonaRemota true si es zona remota, false si no
     * @param subtotal Costo antes de IVA
     * @param iva IVA calculado
     * @param total Total final (subtotal + IVA)
     */
    public static void imprimirTicket(int tipo, double peso, int distancia, boolean zonaRemota,
                                      double subtotal, double iva, double total) {
        String servicio = (tipo == 1) ? "Estándar" : "Express";
        System.out.println("Servicio: " + servicio);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Zona remota: " + (zonaRemota? "Sí" : "No"));
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA: " + iva);
        System.out.println("Total: " + total);
    }
}

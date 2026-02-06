package src;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService gradeService = new GradeService();
        String nombre = InputValidator.leerTextoNoVacio(sc, "Nombre del alumno: ");
        double p1 = InputValidator.leerDoubleEnRango(sc, "Parcial 1: ", 0, 100);
        double p2 = InputValidator.leerDoubleEnRango(sc, "Parcial 2: ", 0, 100);
        double p3 = InputValidator.leerDoubleEnRango(sc, "Parcial 3: ", 0, 100);
        int asistencia = InputValidator.leerIntEnRango(sc, "Asistencia: ", 0, 100);
        boolean entregoProyecto = InputValidator.leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        double promedio = gradeService.calcularPromedio(p1, p2, p3);
        double finalNota = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(finalNota, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalNota, estado);
    }

    public static void imprimirReporte(
            String nombre,
            double p1, double p2, double p3,
            double promedio,
            int asistencia,
            boolean entregoProyecto,
            double finalNota, String estado) {
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.println("Final: " + finalNota);
        System.out.println("Estado: " + estado);
    }
}




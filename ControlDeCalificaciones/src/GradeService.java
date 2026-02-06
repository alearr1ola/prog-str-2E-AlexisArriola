package src;

public class GradeService {

    public double calcularPromedio(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }

    public double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }
    public String determinarEstado(double finalNota, int asistencia, boolean entregoProyecto) {

        if (asistencia < 80) {
            return "Reprobado por asistencias";
        }
        if (!entregoProyecto) {
            return "Reprobado por proyectos";
        }
        if (finalNota >= 70) {
            return "Aprobado";
        } else {
            return "Reprobado por calificación";
        }
    }
}
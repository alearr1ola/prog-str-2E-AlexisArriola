package Controll;

public class ControlAlumnos {

    Alumno[] alumnos = new Alumno[25];
    public void alta(int id, String nombre, double promedio) {
        if (id <= 0) {
            System.out.println("ID invalido");
            return;
        }
        if (buscar(id) != -1) {
            System.out.println("ID repetido");
            return;
        }
        if (nombre.trim().equals("")) {
            System.out.println("Nombre vacio");
            return;
        }
        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio fuera de rango");
            return;
        }
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno agregado");
                return;
            }
        }
        System.out.println("No hay espacio disponible");
    }
    public void buscarAlumno(int id) {
        int pos = buscar(id);
        if (pos != -1 && alumnos[pos].activo) {
            System.out.println("ID: " + alumnos[pos].id);
            System.out.println("Nombre: " + alumnos[pos].nombre);
            System.out.println("Promedio: " + alumnos[pos].promedio);
        } else {
            System.out.println("No encontrado o inactivo");
        }
    }
    public void actualizarPromedio(int id, double nuevoPromedio) {
        int pos = buscar(id);
        if (pos != -1 && alumnos[pos].activo) {
            if (nuevoPromedio < 0 || nuevoPromedio > 10) {
                System.out.println("Promedio fuera de rango");
                return;
            }
            alumnos[pos].promedio = nuevoPromedio;
            System.out.println("Promedio actualizado");

        } else {
            System.out.println("No encontrado o inactivo");
        }
    }
    public void baja(int id) {
        int pos = buscar(id);
        if (pos != -1 && alumnos[pos].activo) {
            alumnos[pos].activo = false;
            System.out.println("Alumno dado de baja");
        } else {
            System.out.println("No encontrado o ya inactivo");
        }
    }
    public void listar() {
        boolean hay = false;
        for (int i = 0; i < alumnos.length; i++) {

            if (alumnos[i] != null && alumnos[i].activo) {
                System.out.println("ID: " + alumnos[i].id +
                        " | Nombre: " + alumnos[i].nombre +
                        " | Promedio: " + alumnos[i].promedio);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay alumnos activos");
        }
    }

    public void reportes() {

        int total = 0;
        double suma = 0;
        int mayores8 = 0;
        Alumno mayor = null;
        Alumno menor = null;

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                total++;
                suma += alumnos[i].promedio;
                if (mayor == null || alumnos[i].promedio > mayor.promedio) {
                    mayor = alumnos[i];
                }
                if (menor == null || alumnos[i].promedio < menor.promedio) {
                    menor = alumnos[i];
                }
                if (alumnos[i].promedio >= 8.0) {
                    mayores8++;
                }
            }
        }

        if (total == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }

        System.out.println("Promedio general: " + (suma / total));

        System.out.println("Mayor promedio:");
        System.out.println("ID: " + mayor.id + " Nombre: " + mayor.nombre + " Promedio: " + mayor.promedio);

        System.out.println("Menor promedio:");
        System.out.println("ID: " + menor.id + " Nombre: " + menor.nombre + " Promedio: " + menor.promedio);

        System.out.println("Alumnos con promedio >= 8: " + mayores8);
    }

    private int buscar(int id) {

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id) {
                return i;
            }
        }
        return -1;
    }
}
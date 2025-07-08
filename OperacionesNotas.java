import java.util.*;

public class OperacionesNotas {
    public static void mostrarPromedios(HashMap<String, ArrayList<Double>> notasEstudiantes) {
        System.out.println("\n--- Estudiantes ---");
        for (Map.Entry<String, ArrayList<Double>> entry: notasEstudiantes.entrySet()) {
            String nombre = entry.getKey();
            String nombreFormateado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
            ArrayList<Double> notas = entry.getValue();
            double promedio = calcularPromedio(notas);
            double max = Collections.max(notas);
            double min = Collections.min(notas);
            System.out.printf("👦 %s: Promedio = %.1f | Nota Máxima = %.1f | Nota Mínima = %.1f\n", nombreFormateado, promedio, max, min);
        }
    }

    public static void verificarAprobacion(HashMap<String, ArrayList<Double>> notasEstudiantes, Scanner sc) {
        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine().toLowerCase();

        if(!notasEstudiantes.containsKey(nombre)) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("Ingrese la nota a evaluar: ");
        double nota = Validador.leerNotaValida();

        if (nota >= 4.0) {
            System.out.println("La nota es Aprobatoria.");
        } else {
            System.out.println("La nota es Reprobatoria.");
        }
    }

    public static void verificarComparacionConPromedioCurso(HashMap<String, ArrayList<Double>> notasEstudiantes, Scanner sc) {
        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine().toLowerCase();

        if(!notasEstudiantes.containsKey(nombre)){
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("Ingrese la nota a comparar: ");
        double nota = Validador.leerNotaValida();

        double promedioCurso = calcularPromedioCurso(notasEstudiantes);
        if (nota >= promedioCurso) {
            System.out.printf("La nota (%.1f) está po SOBRE el promedio del curso (%.1f).\n", nota, promedioCurso);
        } else {
            System.out.printf("La nota (%.1f) está por DEBAJO del promedio del curso (%.1f).\n", nota, promedioCurso);
        }
    }

    private static double calcularPromedio(ArrayList<Double> notas) {
        double suma = 0;
        for (double nota: notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    private static double calcularPromedioCurso(HashMap<String, ArrayList<Double>> notasEstudiantes) {
        double sumaTotal = 0;
        int cantidadNotas = 0;

        for (ArrayList<Double> notas : notasEstudiantes.values()) {
            for (double nota: notas) {
                sumaTotal += nota;
                cantidadNotas++;
            }
        }
        return sumaTotal / cantidadNotas;
    }
}

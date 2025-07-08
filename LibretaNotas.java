import java.util.*;

public class LibretaNotas {
    private HashMap<String, ArrayList<Double>> notasEstudiantes;
    private Scanner sc;
    
    public LibretaNotas() {
        notasEstudiantes = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Ingrese la cantidad de alumnos (máximo 5): ");
        int cantidadAlumnos = Validador.leerEnteroEnRango(1, 5);

        System.out.println("Ingrese la cantidad de notas por alumno (máximo 4): ");
        int cantidadNotas = Validador.leerEnteroEnRango(1, 4);;

        for (int i=0; i<cantidadAlumnos; i++) {
            System.out.println("Nombre del alumno #" + (i + 1) + ": ");
            String nombre = sc.nextLine();

            ArrayList<Double> notas = new ArrayList<>();

            for (int j=0; j < cantidadNotas; j++) {
                System.out.println("Ingrese la nota #" + (j+1) + " para " + nombre + ": ");
                double nota = Validador.leerNotaValida();
                notas.add(nota);
            }

            notasEstudiantes.put(nombre, notas);
        }

        Menu menu = new Menu(notasEstudiantes, sc);
        menu.mostrar();
    }

    public static void main(String[] args) {
        LibretaNotas app = new LibretaNotas();
        app.iniciar();
    }
}
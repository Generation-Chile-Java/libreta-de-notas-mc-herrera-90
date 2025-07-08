import java.util.*;

public class Menu {
    private final HashMap<String, ArrayList<Double>> notasEstudiantes;
    private final Scanner sc;
    
    public Menu(HashMap<String, ArrayList<Double>> notasEstudiantes, Scanner sc) {
        this.notasEstudiantes = notasEstudiantes;
        this.sc = sc;
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar el Promedio de Notas por Estudiante");
            System.out.println("2. Verificar si una Nota es Aprobatoria");
            System.out.println("3. Verificar si una Nota está sobre el Promedio del Curso");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opción: ");

            opcion = Validador.leerEntero();

            switch (opcion) {
                case 1 -> OperacionesNotas.mostrarPromedios(notasEstudiantes);
                case 2 -> OperacionesNotas.verificarAprobacion(notasEstudiantes, sc);
                case 3 -> OperacionesNotas.verificarComparacionConPromedioCurso(notasEstudiantes, sc);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        
        } while(opcion != 0);
    }
}

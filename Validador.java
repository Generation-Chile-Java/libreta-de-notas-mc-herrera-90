import java.util.*;

public class Validador {
    private static Scanner sc = new Scanner(System.in);

    public static int leerEntero() {
        while(!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Intenta nuevamente: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    public static int leerEnteroPositivo() {
        int numero;
        do {
            numero = leerEntero();

            if (numero <= 0) {
                System.out.println("Ingresa un número positivo: ");
            }
        } while (numero <= 0);
        return numero;
    }

    public static double leerNotaValida() {
        double nota;
        do {
            while(!sc.hasNextDouble()) {
                System.out.println("Nota inválida, Ingresa un número válido: ");
                sc.next();
            }

            nota = sc.nextDouble();
            sc.nextLine();
            if (nota < 1.0 || nota > 7.0) {
                System.out.println("La nota debe estar entre 1.0 y 7.0");
            }
        } while(nota < 1.0 || nota > 7.0);
        return nota;
    }

    public static int leerEnteroEnRango(int min, int max) {
        int numero;
        do {
            numero = leerEntero();
            if (numero < min || numero > max) {
                System.out.printf("El número debe estar entre %d y %d. Intenta nuevamente: ", min, max);
            }
        } while (numero < min || numero > max);
        return numero;
    }
}

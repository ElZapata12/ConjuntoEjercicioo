import java.util.Scanner;
import java.util.Stack;

public class Pila {
    private static Stack<String> pilaNombres = new Stack<>();

    public static void gestionarPila() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú Pila de Nombres:");
            System.out.println("1. Agregar nombre");
            System.out.println("2. Ver último nombre");
            System.out.println("3. Eliminar último nombre");
            System.out.println("4. Saber si existe alguien agregado");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    agregarNombre();
                    break;
                case 2:
                    verUltimoNombre();
                    break;
                case 3:
                    eliminarUltimoNombre();
                    break;
                case 4:
                    verificarPila();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void agregarNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un nombre: ");
        String nombre = sc.next();
        pilaNombres.push(nombre);
        System.out.println("Nombre agregado.");
    }

    private static void verUltimoNombre() {
        if (!pilaNombres.isEmpty()) {
            System.out.println("Último nombre en la pila: " + pilaNombres.peek());
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    private static void eliminarUltimoNombre() {
        if (!pilaNombres.isEmpty()) {
            System.out.println("Nombre eliminado: " + pilaNombres.pop());
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    private static void verificarPila() {
        if (pilaNombres.isEmpty()) {
            System.out.println("No hay nadie agregado.");
        } else {
            System.out.println("Si hay alguien agregado.");
        }
    }
}

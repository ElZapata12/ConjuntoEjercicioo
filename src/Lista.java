import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lista {
    private static List<String> listaCompras = new ArrayList<>();

    public static void gestionarLista() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú Lista de Compras:");
            System.out.println("1. Registrar compra");
            System.out.println("2. Ver lista");
            System.out.println("3. Tamaño de la lista");
            System.out.println("4. Buscar en la lista");
            System.out.println("5. Eliminar elementos");
            System.out.println("6. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    mostrarLista();
                    break;
                case 3:
                    mostrarTamanio();
                    break;
                case 4:
                    buscarElemento();
                    break;
                case 5:
                    eliminarElemento();
                    break;
                case 6:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void registrar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el elemento a registrar (o 'fin' para terminar): ");
        String elemento;

        while (!(elemento = sc.nextLine()).equalsIgnoreCase("fin")) {
            listaCompras.add(elemento);
            System.out.println("'" + elemento + "' ha sido agregado.");
            System.out.print("Ingrese otro elemento (o 'fin' para terminar): ");
        }
    }

    private static void mostrarLista() {
        if (listaCompras.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Elementos en la lista:");
            for (String item : listaCompras) {
                System.out.println(item);
            }
        }
    }

    private static void mostrarTamanio() {
        System.out.println("El tamaño de la lista es de: " + listaCompras.size() + " elementos.");
    }

    private static void buscarElemento() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el elemento a buscar: ");
        String elemento = sc.nextLine();

        boolean encontrado = false;
        for (String item : listaCompras) {
            if (item.equalsIgnoreCase(elemento)) {
                System.out.println("El elemento '" + elemento + "' está en la lista.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El elemento '" + elemento + "' no está en la lista.");
        }
    }

    private static void eliminarElemento() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el elemento a eliminar: ");
        String elemento = sc.nextLine();

        boolean eliminado = false;
        for (int i = 0; i < listaCompras.size(); i++) {
            if (listaCompras.get(i).equalsIgnoreCase(elemento)) {
                listaCompras.remove(i);
                System.out.println("Elemento '" + elemento + "' eliminado.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("El elemento '" + elemento + "' no está en la lista.");
        }
    }
}

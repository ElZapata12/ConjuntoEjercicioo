//Evelin Ramiro Rosales
//Maria Fernanda Gomez Gregorio
//Miguel Angel Zapata Rosales

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Sistema de Venta de Boletos:");
            System.out.println("1. Cola de Boletos");
            System.out.println("2.  Lista de Compras");
            System.out.println("3. Gestionar Pila de Nombres");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Cola.gestionarCola();
                    break;
                case 2:
                    Lista.gestionarLista();
                    break;
                case 3:
                    Pila.gestionarPila();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}

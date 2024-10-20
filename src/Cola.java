import java.util.Scanner;

class Cola {
    private int[] elementos;
    private int frente;
    private int fin;
    private int tamanio;

    public Cola(int capacidad) {
        elementos = new int[capacidad];
        frente = 0;
        fin = -1;
        tamanio = 0;
    }

    public void encolar(int elemento) {
        if (estaLlena()) {
            throw new RuntimeException("La cola está llena");
        }
        fin = (fin + 1) % elementos.length;
        elementos[fin] = elemento;
        tamanio++;
    }

    public int desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % elementos.length;
        tamanio--;
        return elemento;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public boolean estaLlena() {
        return tamanio == elementos.length;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.print("Contenido de la cola: ");
        for (int i = 0; i < tamanio; i++) {
            System.out.print(elementos[(frente + i) % elementos.length] + " ");
        }
        System.out.println();
    }

    public static void gestionarCola() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantas personas seran atendidas?");
        int capacidad = sc.nextInt();
        Cola cola = new Cola(capacidad);

        int opcion;
        do {
            System.out.println("\nMenú Cola de Boletos:");
            System.out.println("1. agregar cliente");
            System.out.println("2. eliminar cliente");
            System.out.println("3. Mostrar clientes");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número del cliente: ");
                    int cliente = sc.nextInt();
                    try {
                        cola.encolar(cliente);
                        System.out.println("Cliente " + cliente + " encolado.");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int desencolado = cola.desencolar();
                        System.out.println("Cliente " + desencolado + " ha sido atendido.");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    cola.mostrarCola();
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}

import java.util.Scanner;
import java.util.Stack;

public class Menu {

    public static void main(String[] args) {
        Punto4 punto4 = new Punto4(); // Instancia de la clase Punto4
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Llenar la pila");
            System.out.println("2. Buscar un valor en la pila");
            System.out.println("3. Mostrar la pila actual");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    punto4.llenarPila(scanner);
                    break;
                case 2:
                    punto4.buscarValor(scanner);
                    break;
                case 3:
                    punto4.mostrarPila();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }

        scanner.close();
    }

    public static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor ingresa un número: ");
            }
        }
    }
}

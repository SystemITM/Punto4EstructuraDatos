import java.util.Scanner;
import java.util.Stack;

public class Punto4 {

     Stack<Object> pila;

    public Punto4() {
        this.pila = new Stack<>();
    }

    public void llenarPila(Scanner scanner) {
        System.out.println("\nIngresa valores para llenar la pila (separados por espacio):");
        String[] valores = scanner.nextLine().split(" ");
        for (String valor : valores) {
            pila.push(isNumeric(valor) ? Integer.parseInt(valor) : valor.charAt(0));
        }
        System.out.println("Pila actualizada con éxito.");
    }

    public void buscarValor(Scanner scanner) {
        if (pila.isEmpty()) {
            System.out.println("\nLa pila está vacía. Llénala primero.");
            return;
        }

        System.out.println("\nIngresa el valor (número o carácter) a buscar en la pila:");
        String entrada = scanner.nextLine();
        Object valorBuscado = isNumeric(entrada) ? Integer.parseInt(entrada) : entrada.charAt(0);

        int posicion = buscarEnPila(valorBuscado);

        if (posicion != -1) {
            System.out.println("Valor encontrado en la posición: " + (posicion + 1));
        } else {
            System.out.println("Valor no encontrado en la pila.");
        }
    }

    public void mostrarPila() {
        if (pila.isEmpty()) {
            System.out.println("\nLa pila está vacía.");
        } else {
            System.out.println("\nContenido actual de la pila (desde arriba hacia abajo):");
            for (int i = pila.size() - 1; i >= 0; i--) {
                System.out.println(pila.get(i));
            }
        }
    }

    private int buscarEnPila(Object valorBuscado) {
        Stack<Object> tempStack = new Stack<>();
        int posicion = -1;
        int contador = 0;

        // Buscar el elemento y mantener el estado original de la pila
        while (!pila.isEmpty()) {
            Object elemento = pila.pop();
            tempStack.push(elemento);

            if (elemento.equals(valorBuscado)) {
                posicion = contador;
                break;
            }
            contador++;
        }

        // Restaurar la pila original
        while (!tempStack.isEmpty()) {
            pila.push(tempStack.pop());
        }

        return posicion;
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

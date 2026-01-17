import java.util.Scanner;
public class Main { // Abre la clase
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLimite = pedirEnteros(scanner);
        int sumaTotal = sumarHastaN(numLimite);
        System.out.println("La suma total del 1 hasta " + numLimite + " es: " + sumaTotal);

        scanner.close();
    }
    public static int pedirEnteros(Scanner scanner) {
        System.out.print("Escriba un número positivo: ");
        return scanner.nextInt();
    }
    public static int sumarHastaN(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }
}
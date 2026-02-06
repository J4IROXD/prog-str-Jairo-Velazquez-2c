import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();
        double peso = leerDoubleRango(sc, "Escriba el peso en Kg (0.1 - 50): ", 0.1, 50.0);
        int dist = leerIntEnRango(sc, "Escriba la distancia (1 - 2000): ", 1, 2000);
        int serv = leerIntEnRango(sc, "Escoga un servicio (1.Estandar o 2.Express): ", 1, 2);
        boolean zonarem = leerBoolean(sc, "¿Es en una zona remota? (true/false): ");

        double subto = calc.calcularSubtotal(peso, dist, serv, zonarem);
        double iva = calc.calcularIVA(subto);
        double total = calc.calcularTotal(subto, iva);
        imprimirTicket(serv, peso, dist, zonarem, subto, iva, total);
    }

    public static double leerDoubleRango(Scanner sc, String msg, double min, double max) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                if (valor >= min && valor <= max) return valor;
                else System.out.println("Error: Fuera de rango.");
            } else {
                System.out.println("Error: No es numérico.");
                sc.next();
            }
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                if (valor >= min && valor <= max) return valor;
                else System.out.println("Error: Fuera de rango.");
            } else {
                System.out.println("Error: No es un número entero.");
                sc.next();
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("Error: Escriba true o false.");
                sc.next();
            }
        }
    }

    public static void imprimirTicket(int serv, double peso, int dist, boolean remoto, double sub, double iva, double total) {
        String nombreServicio = (serv == 1) ? "Estándar" : "Express";
        System.out.println("\n--- TICKET DE ENVÍO ---");
        System.out.println("Servicio: " + nombreServicio);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + dist + " km");
        System.out.println("Zona Remota: " + (remoto ? "Sí" : "No"));
        System.out.println("-------------------------------");
        System.out.printf("Subtotal: $%.2f%n", sub);
        System.out.printf("IVA (16%%): $%.2f%n", iva);
        System.out.printf("TOTAL: $%.2f%n", total);
        System.out.println("-------------------------------");
    }
}
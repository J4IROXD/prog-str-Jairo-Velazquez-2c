import java.util.Scanner;
public class InputValueValidator {
    public double pedirDouble(Scanner sc, String mensaje, double min, double max) {
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("El número esta fuera del rango");
                }
            } else {
                System.out.println("El dato ingresado no es númerico");
                sc.next();
            }
        }
    }

    public int pedirInt(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                } else {
                    System.out.println("El número esta fuera del rango");
                }
            } else {
                System.out.println("Error el dato ingresado no es un número entero");
                sc.next();
            }
        }
    }

    public boolean pedirBoolean(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje + "escribe true o false");
            if (sc.hasNextBoolean()) {
                sc.nextLine();
                return sc.nextBoolean();
            } else {
                System.out.println("Error tienes que escribir  true o false");
                sc.next();
            }
        }
    }
}
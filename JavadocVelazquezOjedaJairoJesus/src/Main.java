import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        int choice;
        do {

            System.out.println("Menu:");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular el área de un rectangulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");


            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Escriba su peso en kilogramos (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Escriba su altura en metros (m): ");
                    double altura = scanner.nextDouble();
                    double imc = solucionIMC(peso, altura);
                    System.out.println("Tu IMC es: " + imc);
                    break;
                case 2:
                    System.out.print("Escriba la base del retángulo en metros (m): ");
                    double BaseRect = scanner.nextDouble();
                    System.out.print("Escriba la altura del retángulo en metros (m): ");
                    double AlturaRect = scanner.nextDouble();
                    double AreaRect = AreaRectangulo(BaseRect, AlturaRect);
                    System.out.println("El área del rectangulo es: " + AreaRect + " m^2");
                    break;
                case 3:
                    System.out.print("Escriba los celsius (°C): ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = CalcularFahrenheit(celsius);
                    System.out.println(celsius + "°C son igual a: "+ fahrenheit+"°F");
                    break;
                case 4:
                    System.out.print("Escriba la radio del circulo en metros (m): ");
                    double RadioCir = scanner.nextDouble();
                    double AreaCir = CalcularAreaCir(RadioCir);
                    System.out.println("El área del circulo es de: " + AreaCir+"m^2");
                    break;
                case 5:
                    System.out.print("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción invalida :(. Intente de nuevo :D");
            }


        } while (choice != 5);
        scanner.close();
    }
    /**
     * Calcular el IMC (Indice de Masa Corporal) de una persona
     * La formula es peso / (altura * altura)
     *
     * @param peso El peso debe ser en kilogramos (kg)
     * @param altura La altura debe de ser en metros (m)
     * @return calcular el imc
     */
    public static double solucionIMC(double peso, double altura) {
        return peso / (altura*altura);
    }
    /**
     * Calcular el área de un rectangulo en base a su base y altura
     * @param BaseRect La base de ser en metros (m)
     * @param AlturaRect La altura de ser en metros (m)
     * @return El área del rectangulo
     */
    public static double AreaRectangulo(double BaseRect, double AlturaRect) {
        return BaseRect * AlturaRect;
    }
    /**
     * Dar equivalencia de grados Celsious a Fahrenheit
     * La formula es (C*1.18) + 32
     * @param celsius La temperatura debe estar en grados celsius
     * @return El resultado debe ser en grados Fahrenheit
     */
    public static double CalcularFahrenheit(double celsius){
        return (celsius*1.18) + 32;
    }
    /**
     * Calcular el área del circulo con su radio
     * En la formula se utiliza Math.PI
     * @param RadioCir La radio del circulo debe estar en metros
     * @return Calcular el área del circulo
     */
    public static double CalcularAreaCir(double RadioCir){
        return Math.PI * (RadioCir*RadioCir);
    }

}
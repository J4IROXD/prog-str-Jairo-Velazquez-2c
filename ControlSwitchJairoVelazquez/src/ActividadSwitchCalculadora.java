import java.util.Scanner;
public class ActividadSwitchCalculadora {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.println("Bienvenido");
     System.out.println("1) Sumar");
     System.out.println("2) Restar");
     System.out.println("3) Multiplicar");
     System.out.println("4) Dividir");
     System.out.print("Seleccione una opción: ");
     int opcion = scanner.nextInt();
     System.out.print("Escriba el valor de a: ");
     double a = scanner.nextDouble();
     System.out.print("Escriba el valor de b: ");
     double b = scanner.nextDouble();
     switch (opcion) {
         case 1:
             double suma = CalcularSuma(a, b);
             System.out.println("El resultado es: "+ suma);
             break;
         case 2:
             double resta = CalcularResta(a, b);
             System.out.println("El resultado es: "+ resta);
             break;
         case 3:
             double multiplicacion = CalcularMultiplicacion(a, b);
             System.out.println("El resultado es: "+ multiplicacion);
             break;
         case 4:
             if (b == 0) {
                 System.out.println("Error: No se puede dividir entre cero.");
             }
              else {
                 double divicion = CalcularDivicion(a, b);
                 System.out.println("El resultado es: "+ divicion);
         }
             break;
         default:
             System.out.println("Opción no valida, intente de nuevo.");
             break;
     }
     scanner.close();
 }

    /**
     * Calcular el resultado de a + b
     *
     * @param a
     * @param b
     * @return
     */
    public static double CalcularSuma(double a, double b) {
     return a + b;
 }

    /**
     * Calcular el resultado a - b
     * @param a
     * @param b
     * @return
     */
    public static double CalcularResta(double a, double b) {
     return a - b;
 }

    /**
     * Calcular el resultado de a * b
     * @param a
     * @param b
     * @return
     */
    public static double CalcularMultiplicacion(double a, double b) {
     return  a * b;
    }

    /**
     * Calcular el resultado de a / b
     * @param a
     * @param b
     * @return
     */
    public static double CalcularDivicion(double a, double b) {
     return a / b;
    }
}

import java.util.Scanner;
public class MenuConversionJairoVelazquez {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int contCaF = 0;
        int contFaC = 0;
        int contKmaMi = 0;
        int contMiaKm = 0;
        boolean continuar = true;

        do {
            System.out.println("Bienvenido a menú de converción");
            System.out.println("1. °C a °F");
            System.out.println("2. °F a °C");
            System.out.println("3. Km a Millas");
            System.out.println("4. Millas a Km");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Escriba los grados celsius (°C): ");
                        double celsius = scanner.nextDouble();
                        double fahrenheit = CalcularFahrenheit(celsius);
                        System.out.println(celsius+"°C equivalen a " + fahrenheit +"°F");
                        contCaF++;
                        break;
                    case 2:
                        System.out.print("Escriba los grados fahrenheit (°F): ");
                        double fahr = scanner.nextDouble();
                        double cel = CalcularCelsius(fahr);
                        System.out.println(fahr+"°F equivalen a "+ cel+"°C");
                        contFaC++;
                        break;
                    case 3:
                        System.out.print("Escriba los kilometros (Km): ");
                        double kilometros = scanner.nextDouble();
                        double millas = CalcularMillas(kilometros);
                        System.out.println(kilometros + " Km equivalen a "+ millas + " Mi");
                        contKmaMi++;
                        break;
                    case 4:
                        System.out.print("Escriba las millas (Mi): ");
                        double mi = scanner.nextDouble();
                        double km = CalcularKilometros(mi);
                        System.out.println(mi + " Mi equivalen a "+ km + " Km");
                        contMiaKm++;
                        break;
                    case 5:
                        System.out.println("Hasta luego :)");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Error: Seleccione una de las opciones");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresaste un dato no numérico. Ingrese una de las opciones.");
                scanner.nextLine();
            }
        }
        while (continuar);
        int total = contCaF + contFaC + contKmaMi + contMiaKm;
        System.out.println("TOTAL DE CALCULOS HECHOS");
        System.out.println("Total de conversiones: "+total);
        System.out.println("Total de conversiones de °C a °F: "+contCaF);
        System.out.println("Total de conversiones de °F a °C: "+contFaC);
        System.out.println("Total de conversiones de Km a Mi: "+contKmaMi);
        System.out.println("Total de conversiones de Mi a Km: "+contMiaKm);
        scanner.close();
    }

    /** Dar equivalencias de grados Celsius a Fahrenheit
     * La formula es (C*1.18) + 32
     * @Param celsius La temperatura debe estar en grados celsius
     * @return El resultado debe ser en grados Fahrenheit
     */
    public static double CalcularFahrenheit(double celsius){
        return (celsius*1.18)+32;
        }
    /** Dar equivalencias de grados Fahrenheit a Celsius
     * La formula es  (F − 32) * 5/9
     * @Param fahr La temperatura tiene que estar en grados fahrenheit
     * @return El resultado tiene que estar en grados celsius
     */
    public static double CalcularCelsius(double fahr){
        return (fahr-32)*5/9;
    }
    /** Dar equivalencias de kilometros a millas
     * La formula es Km/1.60934
     * @Param kilometros La longitud tiene que ser en kilometros
     * @return El resultado tiene que ser en millas
     */
    public static double CalcularMillas(double kilometros){
        return kilometros/1.60934;
    }
    /** Dar equivalencias de millas a kilometros
     * La formula es Mi*1.60934
     * @Param mi La longitud tiene que estar en millas
     * @returm El resultado tiene que ser en kilometros
     */
    public static double CalcularKilometros(double mi){
        return mi*1.60934;
    }
  }

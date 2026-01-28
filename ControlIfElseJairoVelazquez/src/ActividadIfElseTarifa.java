import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.print("Escriba su edad: ");
        int edad = scanner.nextInt();
        System.out.print("¿Es estudiante? (escriba true o false): ");
        boolean esEstudiante = scanner.nextBoolean();
        int tarifa = 0;
        if (edad < 0 || edad > 120){
            System.out.println("Edad invalida");
            return;
        }
        if (edad < 12){
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante){
                tarifa = 60;

            }
            else {
                tarifa = 80;
            }
        }
        else {
            if (esEstudiante){
                tarifa = 90;
            }
            else {
                tarifa = 120;
            }
        }
        System.out.println("Edad: "+edad);
        if (esEstudiante){
            System.out.println("¿Es estudiante? Sí");
        }
        else {
            System.out.println("¿Es estudiante? No");
        }
        System.out.println("El total de su tarifa es de $"+tarifa);
    }

}

import java.util.Random;
import java.util.Scanner;

public class AdivinarNumero {
    static int erroresRango = 0;
    static int erroresNoNumerico = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min=1;
        int max=100;
        int intentos=0;
        int limiteIntentos=7;
        boolean gano=false;
        int secreto = random.nextInt(100)+1; //sirve para generar un numero entero entre 1...100
        System.out.println("Adivina el número (1-100) "+"tienes: "+limiteIntentos+" intentos para lograrlo");
        while (intentos<limiteIntentos){
            int numeros=obtenerNumeroValido("Intento: "+(intentos+1),sc,min,max);
            intentos++;
            if(numeros==secreto){
                System.out.println("Felicidades ganaste en el intento: "+intentos);
                gano=true;
                break;
            } else if (numeros>secreto) {
                System.out.println("El número secreto es menor a "+numeros);
            } else {
                System.out.println("El número secreto es mayor a "+numeros);
            }
        }
        if (!gano){
            System.out.println("Perdiste el número secreto era: "+secreto);
        }
        System.out.println("Errores de rango: " + erroresRango);
        System.out.println("Errores no numéricos: " + erroresNoNumerico);
    }
    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max) {
        int entrada;
        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextInt()) {
                entrada = sc.nextInt();
                if (entrada >= min && entrada <= max) {
                    return entrada;
                }
                System.out.println("El número ingresado esta fuera del rango (1-100)");
                erroresRango++;
            } else {
                System.out.println("El dato ingresado no es numerico");
                erroresNoNumerico++;
                sc.next();
            }
        }
    }
}
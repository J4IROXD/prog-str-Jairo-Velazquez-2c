import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GradeService gs = new GradeService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("Escriba el nombre del alumno: ");
        String nombre = sc.nextLine();
        while (nombre.trim().isEmpty()) {
            System.out.println("Error: No ha escrito algun nombre. Intente de nuevo: ");
            nombre = sc.nextLine();
        }

        System.out.println("Escriba la calificación del parcial 1: ");
        double parcial1 = sc.nextDouble();
        System.out.println("Escriba la calificación del parcial 2:");
        double parcial2 = sc.nextDouble();
        System.out.println("Escriba la calificación del parcial 3:");
        double parcial3 = sc.nextDouble();
        System.out.println("Escriba el porcentaje de asistencia (0-100): ");
        int asistencia = sc.nextInt();
        System.out.println("¿Entrego proyecto? (escriba true o false)");
        boolean entregoProyecto = sc.nextBoolean();
        double promedio = gs.calcularPromedio(parcial1, parcial2, parcial3);
        double calificacionFinal = gs.calificacionFinal(promedio, asistencia);
        String determinarEstado = gs.determinarEstado(calificacionFinal, asistencia, entregoProyecto);
        System.out.println("Alumno: " + nombre);
        System.out.println("Promedio: " + String.format("%.2f",promedio));
        System.out.println("Calificación final: " + String.format("%.2f",calificacionFinal));
        System.out.println("Estado: " + determinarEstado);
    }
}
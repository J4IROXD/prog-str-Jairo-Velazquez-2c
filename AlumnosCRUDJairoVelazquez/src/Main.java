import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorAlumnos gestalum = new GestorAlumnos();
        int opcion = 0;
        do {
            System.out.println("----Menú----");
            System.out.println("Bienvenido");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.println("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1: {
                    System.out.println("Escriba el nombre del alumno: ");
                    String nombre = sc.nextLine();
                    System.out.println("Escriba la ID del alumno (debe ser mayor a 0): ");
                    int id = sc.nextInt();
                    System.out.println("Escriba el promedio del alumno: ");
                    double promedio = sc.nextDouble();
                    gestalum.altaAlumno(id, nombre, promedio);
                    break;
                }
                case 2: {
                    System.out.println("Escribe la ID del alumno: ");
                    int idBuscar = sc.nextInt();
                    Alumnos encontrado = gestalum.buscarID(idBuscar);

                    if (encontrado != null){
                        System.out.println("Alumno: " + encontrado.getNombre() + " - Promedio: " + encontrado.getPromedio());
                    } else {
                        System.out.println("No se encontro ningun alumno con esa ID");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Escriba la ID del alumno: ");
                    int idBuscar = sc.nextInt();
                    System.out.println("Ingrese el nuevo promedio del alumno: ");
                    double nuevoPromedio = sc.nextDouble();
                    gestalum.actualizarPromedio(idBuscar, nuevoPromedio);
                    System.out.println("Se actualizo el promedio con exito");
                    break;
                }
                case 4: {
                    System.out.println("Escriba la ID del al que desea dar de baja: ");
                    int idBuscar = sc.nextInt();
                    boolean resultado = gestalum.bajaLogica(idBuscar);
                    if (resultado == true){
                        System.out.println("La ID: " + idBuscar + " fue dada de baja con exito");
                    } else {
                        System.out.println("Error: no se econtro la ID");
                    }
                    break;
                }
                case 5: {
                    gestalum.listarAlumnos();
                    break;
                }
                case 6: {
                    gestalum.reporteAlumnos();
                    break;
                }
                case 0: {
                    System.out.println("Saliendo del programa...");
                }
                default: {
                    System.out.println("Opción invalida, intente de nuevo");
                    break;
                }
            }
        } while (opcion != 0);
    }
}
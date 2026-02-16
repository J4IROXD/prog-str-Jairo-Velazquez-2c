import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona[] personas = new Persona[20];
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("----Menú----");
            System.out.println("Bienvenido");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("0) Salir");
            System.out.println("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("Escriba la ID de la persona (que sea mayor a 0): ");
                    int idRecibido = sc.nextInt();
                    sc.nextLine();

                    if (idRecibido <= 0) { // Corregido para que detecte el error
                        System.out.println("El número debe de ser mayor a 0");
                    } else {
                        boolean idRep = false;
                        for (int i = 0; i < personas.length; i++) {
                            if (personas[i] != null && personas[i].getId() == idRecibido) {
                                idRep = true;
                                break;
                            }
                        }
                        if (idRep) {
                            System.out.println("Esta ID ya esta registrada");
                        } else {
                            System.out.println("Escriba el nombre de la persona: ");
                            String nombreRecibido = sc.nextLine();

                            if (nombreRecibido.trim().isEmpty()) {
                                System.out.println("El nombre no puede estar vacío.");
                            } else {
                                boolean guardar = false;
                                for (int i = 0; i < personas.length; i++) {
                                    if (personas[i] == null) {
                                        personas[i] = new Persona(idRecibido, nombreRecibido);
                                        System.out.println("la persona se guardo en esta posición: " + i);
                                        guardar = true;
                                        break;
                                    }
                                }
                                if (!guardar) {
                                    System.out.println("Error: Todas las posiciones estan ocupadas");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                        System.out.println("Escriba la ID del usuario: ");
                        int idRecibido = sc.nextInt();
                        boolean encontrado = false;
                        for (int i = 0; i < personas.length; i++) {
                            if (personas[i] != null && personas[i].getActive() && personas[i].getId() == idRecibido) {
                                System.out.println(personas[i].getNombre());
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Usuario no encontrado");
                        }
                        break;
                }
                case 3: {
                    System.out.println("Escriba la ID del usuario al que quiera dar de baja: ");
                    int idRecibido = sc.nextInt();
                    boolean encontrado = false;
                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].getId() == idRecibido && personas[i].getActive()) {
                            personas[i].setActive(false);
                            encontrado = true;
                            System.out.println("El usuario ha sido dado de baja exitosamente");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                }
                case 4: {
                    boolean encontrado = false;
                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].getActive()) {
                            System.out.println("Nombre: " + personas[i].getNombre() + " ID: " + personas[i].getId());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("La lista esta vacia");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Escriba el ID del usuario al cual quiera cambiar el nombre: ");
                    int idRecibido = sc.nextInt();
                    boolean encontrado = false;
                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].getId() == idRecibido && personas[i].getActive()){
                            sc.nextLine();
                            System.out.println("Escriba el nuevo nombre: ");
                            String nombreNuevo = sc.nextLine();
                            personas[i].setNombre(nombreNuevo);
                            System.out.println("El nombre se ha cambiado exitosamente");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado){
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                }
                case 0: {
                    System.out.println("Saliendo...");
                    break;
                }
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
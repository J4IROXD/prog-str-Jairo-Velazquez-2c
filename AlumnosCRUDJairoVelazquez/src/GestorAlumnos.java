public class GestorAlumnos {
    private Alumnos[] alumnos = new Alumnos[25];

    public boolean altaAlumno(int id, String nombre, double promedio) {
        if (id <= 0) {
            System.out.println("Error: La ID debe ser mayor a 0");
            return false;
        } else {
            boolean idRep = false;
            for (int i = 0; i < alumnos.length; i++) {
                if (alumnos[i] != null && alumnos[i].getId() == id) {
                    idRep = true;
                    break;
                }
            }
            if (idRep) {
                System.out.println("Error: La ID ya esta en uso");
                return false;
            }
        }
        if (promedio < 0 || promedio > 10) {
            System.out.println("Error: El promedio esta fuera del rango");
            return false;
        }
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre esta vacío");
            return false;
        }
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumnos(id, nombre, promedio);
                System.out.println("La persona se guardo en esta posición: " + i);
                return true;
            }
        }
        System.out.println("Error: Ya no hay espacio");
        return false;
    }

    public Alumnos buscarID(int idBuscar) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo() && alumnos[i].getId() == idBuscar) {
                System.out.println(alumnos[i].getNombre());
                return alumnos[i];
            }
        }
        return null;
    }

    public boolean actualizarPromedio(int idBuscar, double nuevoPromedio) {
        if (nuevoPromedio < 0 || nuevoPromedio > 10) {
            System.out.println("Error: El promedio esta fuera del rango");
            return false;
        }
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo() && alumnos[i].getId() == idBuscar) {
                alumnos[i].setPromedio(nuevoPromedio);
                return true;
            }
        }
        return false;
    }

    public boolean bajaLogica(int idBuscar) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == idBuscar && alumnos[i].isActivo()) {
                alumnos[i].setActivo(false);
                return true;
            }
        }
        return false;
    }

    public void listarAlumnos() {
        System.out.println("----ALUMNOS ACTIVOS----");
        for (int i = 0; i < alumnos.length; i++){
            if (alumnos[i] != null && alumnos[i].isActivo()){
                System.out.println("ID: " + alumnos[i].getId() + " | Nombre: " + alumnos[i].getNombre() + " | Promedio: " + alumnos[i].getPromedio());
            }
        }
    }

    public void reporteAlumnos(){
        System.out.println("----REPORTE----");
        double suma = 0;
        int contador = 0;
        Alumnos mejorAlumno = null;
        Alumnos peorAlumno = null;
        int cantidadOcho = 0;
        for (int i = 0; i < alumnos.length; i++){
            if (alumnos[i] != null && alumnos[i].isActivo()) {
                suma += alumnos[i].getPromedio();
                contador++;

                if (mejorAlumno == null || alumnos[i].getPromedio() > mejorAlumno.getPromedio()){
                    mejorAlumno = alumnos[i];
                }
                if (peorAlumno == null || alumnos[i].getPromedio() < peorAlumno.getPromedio()) {
                    peorAlumno = alumnos[i];
                }
                if (alumnos[i].getPromedio() >= 8){
                    cantidadOcho++;
                }
            }
        }
        if (contador > 0){
            double promedioGeneral = suma/contador;
            System.out.println("El promedio general es de: " + promedioGeneral);
        } else {
            System.out.println("Error: Aún no hay alumnos para calcular el pronedio general");
        }
        if (mejorAlumno != null){
            System.out.println("El alumno con mayor promedio es: " + mejorAlumno.getNombre());
        }
        if (peorAlumno != null){
            System.out.println("El alumno con menor promedio es: " + peorAlumno.getNombre());
        }
            System.out.println("Alumnos con un promedio igual o mayor a 8: " + cantidadOcho);
    }
}


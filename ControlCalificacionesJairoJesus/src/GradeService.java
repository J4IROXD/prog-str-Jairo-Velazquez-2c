public class GradeService {
    public double calcularPromedio(double parcial1, double parcial2, double parcial3){
        return (parcial1 + parcial2 + parcial3) / 3;
    }
    public double calificacionFinal(double promedio, int asistencia){
        return (promedio * 0.7) + (asistencia * 0.3);
    }
    public String determinarEstado (double calificacionFinal, int asistencia, boolean entregoProyecto) {
        if (asistencia < 80) {
            return "REPROBADO por asistencia";
        }
        if (entregoProyecto == false) {
            return "REPROBADO por proyecto";
        }
        if (calificacionFinal >= 70){
            return "APROBADO";
        }else {
            return "REPROBADO por calificación";
        }
    }
}

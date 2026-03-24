package modelo;

public class Contacto {
    private String nombre;
    private String numero;
    private String parentesco;

    public Contacto (String nombre, String numero, String parentesco){
        this.nombre = nombre;
        this.numero = numero;
        this.parentesco = parentesco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return this.nombre + "-" + this.numero + "-" +"(" + this.parentesco + ")";
    }
}

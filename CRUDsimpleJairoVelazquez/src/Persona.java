public class Persona {
    private int id;
    private String nombre;
    private Boolean isActive;

    public Persona(int idRecibido, String nombreRecibido) {
        id = idRecibido;
        nombre = nombreRecibido;
        isActive = true;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

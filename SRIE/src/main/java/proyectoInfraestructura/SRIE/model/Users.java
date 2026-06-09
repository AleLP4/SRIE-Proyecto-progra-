package proyectoInfraestructura.SRIE.model;

public class Users {

    private String nombre,correo,carrera;
    private int id;

    public Users(String nombre, String correo, String carrera, int id) {
        this.nombre = nombre;
        this.correo = correo;
        this.carrera = carrera;
        this.id = id;
    }

    public Users() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


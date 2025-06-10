import java.util.ArrayList;

public class Lector {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String contrasena;

    public Lector(String nombre, String apellido, String cedula, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCedula() { return cedula; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public void cambiarContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }

    public void visualizarHistorial() {
        System.out.println("Historial de préstamos para " + nombre + " " + apellido + " no implementado.");
    }

    @Override
    public String toString() {
        return "Lector: " + nombre + " " + apellido + " (Cédula: " + cedula + ", Correo: " + correo + ")";
    }
}
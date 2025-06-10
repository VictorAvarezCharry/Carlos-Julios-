import java.util.Date;

public class Prestamo {
    private int id;
    private Libro libro;
    private Lector lector;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;

    public Prestamo(int id, Libro libro, Lector lector) {
        this.id = id;
        this.libro = libro;
        this.lector = lector;
        this.fechaPrestamo = new Date();
        this.estado = "Activo";
        libro.setDisponible(false);
    }

    public int getId() { return id; }
    public Libro getLibro() { return libro; }
    public Lector getLector() { return lector; }
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public Date getFechaDevolucion() { return fechaDevolucion; }
    public String getEstado() { return estado; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    public void setEstado(String estado) { this.estado = estado; }

    public void registrar() {
        System.out.println("Préstamo registrado con ID: " + id);
    }

    public void marcarDevuelto() {
        this.estado = "Devuelto";
        this.fechaDevolucion = new Date();
        this.libro.setDisponible(true);
    }

    public boolean esVencido() {
        if (fechaDevolucion == null) return false;
        return new Date().after(fechaDevolucion);
    }

    @Override
    public String toString() {
        return "Préstamo: " + id + " - " + libro.getTitulo() + " a " + lector.getNombre() + " " + lector.getApellido() + 
               " (Fecha Préstamo: " + fechaPrestamo + ", Fecha Devolución: " + fechaDevolucion + ", Estado: " + estado + ")";
    }
}
import java.util.Date;

public class Reserva {
    private int id;
    private Lector usuario;
    private Libro libro;
    private Date fechaReserva;

    public Reserva(int id, Lector usuario, Libro libro) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaReserva = new Date();
    }

    public int getId() { return id; }
    public Lector getUsuario() { return usuario; }
    public Libro getLibro() { return libro; }
    public Date getFechaReserva() { return fechaReserva; }

    public void confirmar() {
        if (libro.esReservable()) {
            System.out.println("Reserva confirmada para " + usuario.getNombre() + " " + usuario.getApellido() + " para " + libro.getTitulo());
        } else {
            System.out.println("El libro no está disponible para reserva.");
        }
    }

    @Override
    public String toString() {
        return "Reserva: " + id + " - " + usuario.getNombre() + " " + usuario.getApellido() + " para " + libro.getTitulo() + " (Fecha: " + fechaReserva + ")";
    }
}
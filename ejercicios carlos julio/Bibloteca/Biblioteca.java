import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Lector> lectores = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<Multa> multas = new ArrayList<>();

    public void registrarLibro(String isbn, String titulo, String autor, String genero, int anio) {
        Libro libro = new Libro(isbn, titulo, autor, genero, anio);
        libros.add(libro);
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public void registrarLector(String nombre, String apellido, String cedula, String correo, String contrasena) {
        Lector lector = new Lector(nombre, apellido, cedula, correo, contrasena);
        lectores.add(lector);
    }

    public Lector buscarLector(String cedula) {
        for (Lector lector : lectores) {
            if (lector.getCedula().equals(cedula)) {
                return lector;
            }
        }
        return null;
    }

    public void registrarPrestamo(int id, Libro libro, Lector lector) {
        Prestamo prestamo = new Prestamo(id, libro, lector);
        prestamo.registrar();
        prestamos.add(prestamo);
    }

    public void devolverLibro(Libro libro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().equals(libro) && "Activo".equals(prestamo.getEstado())) {
                prestamo.marcarDevuelto();
                checkMulta(prestamo);
                break;
            }
        }
    }

    private void checkMulta(Prestamo prestamo) {
        if (prestamo.esVencido()) {
            Multa multa = new Multa(prestamo.getId(), new Date(), prestamo.getFechaPrestamo());
            multas.add(multa);
            System.out.println("Multa generada: " + multa);
        }
    }

    public void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        }
    }

    public void filtrarLibros(String criterio) {
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(criterio.toLowerCase()) ||
                libro.getAutor().toLowerCase().contains(criterio.toLowerCase())) {
                System.out.println(libro);
            }
        }
    }

    public void filtrarLectores(String criterio) {
        for (Lector lector : lectores) {
            if (lector.getNombre().toLowerCase().contains(criterio.toLowerCase()) ||
                lector.getApellido().toLowerCase().contains(criterio.toLowerCase())) {
                System.out.println(lector);
            }
        }
    }

    public void generarReporte(Date[] rangoFechas, String estado) {
        ArrayList<Prestamo> filteredPrestamos = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaPrestamo().after(rangoFechas[0]) && prestamo.getFechaPrestamo().before(rangoFechas[1]) &&
                (estado == null || prestamo.getEstado().equalsIgnoreCase(estado))) {
                filteredPrestamos.add(prestamo);
            }
        }
        Reporte reporte = new Reporte(filteredPrestamos, rangoFechas, estado);
        reporte.generarInforme();
    }

    public void notificarVencimientos() {
        for (Prestamo prestamo : prestamos) {
            if ("Activo".equals(prestamo.getEstado()) && prestamo.esVencido()) {
                System.out.println("Vencimiento notificado para préstamo " + prestamo.getId() + " de " + prestamo.getLector().getNombre());
            }
        }
    }
}
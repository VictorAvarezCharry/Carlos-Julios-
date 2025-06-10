import java.util.Date;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int anio;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor, String genero, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.disponible = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public void editar(String isbn, String titulo, String autor, String genero, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
    }

    public void eliminar() {
        this.disponible = false; // Simula eliminación lógica
    }

    public boolean esReservable() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " (ISBN: " + isbn + ", Autor: " + autor + ", Género: " + genero + ", Año: " + anio + ", Disponible: " + disponible + ")";
    }
}
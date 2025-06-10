import java.util.ArrayList;
import java.util.Date;

public class Reporte {
    private ArrayList<Prestamo> prestamos;
    private Date[] rangoFechas;
    private String estado;

    public Reporte(ArrayList<Prestamo> prestamos, Date[] rangoFechas, String estado) {
        this.prestamos = prestamos;
        this.rangoFechas = rangoFechas;
        this.estado = estado;
    }

    public ArrayList<Prestamo> getPrestamos() { return prestamos; }
    public Date[] getRangoFechas() { return rangoFechas; }
    public String getEstado() { return estado; }

    public void generarInforme() {
        System.out.println("Generando Informe para reporte de préstamos (" + estado + ") en rango: " + rangoFechas[0] + " a " + rangoFechas[1]);
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    @Override
    public String toString() {
        return "Reporte: " + estado + " (Rango: " + rangoFechas[0] + " a " + rangoFechas[1] + ")";
    }
}
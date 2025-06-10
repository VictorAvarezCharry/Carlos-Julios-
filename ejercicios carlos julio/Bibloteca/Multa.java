import java.util.Date;

public class Multa {
    private int idPrestamo;
    private Date fechaReal;
    private Date fechaLimite;
    private double monto;

    public Multa(int idPrestamo, Date fechaReal, Date fechaLimite) {
        this.idPrestamo = idPrestamo;
        this.fechaReal = fechaReal;
        this.fechaLimite = fechaLimite;
        this.monto = calcularMulta();
    }

    public int getIdPrestamo() { return idPrestamo; }
    public Date getFechaReal() { return fechaReal; }
    public Date getFechaLimite() { return fechaLimite; }
    public double getMonto() { return monto; }

    public double calcularMulta() {
        if (fechaReal == null || fechaLimite == null) return 0.0;
        long diffInMillies = fechaReal.getTime() - fechaLimite.getTime();
        long diffDays = diffInMillies / (1000 * 60 * 60 * 24);
        return diffDays > 0 ? diffDays * 2.0 : 0.0; // $2 por día de retraso
    }

    @Override
    public String toString() {
        return "Multa: " + idPrestamo + " (Fecha Real: " + fechaReal + ", Fecha Límite: " + fechaLimite + ", Monto: $" + monto + ")";
    }
}
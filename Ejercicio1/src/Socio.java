import java.time.LocalDate;

public class Socio {
    private final String nombre;
    private final int numeroSocio;
    private final LocalDate fechaAlta;

    public Socio(String nombre, int numeroSocio, LocalDate fechaAlta) {
        this.nombre = nombre;
        this.numeroSocio = numeroSocio;
        this.fechaAlta = fechaAlta;
    }

    /** Pide prestado un libro. Devuelve el préstamo o null si no hay ejemplares. */
    public Prestamo tomarPrestado(Libro libro) {
        return Prestamo.crear(this, libro);
    }

    public void devolver(Prestamo prestamo) {
        prestamo.finalizar();
    }

    public String getNombre() { return nombre; }
    public int getNumeroSocio() { return numeroSocio; }
    public LocalDate getFechaAlta() { return fechaAlta; }
}

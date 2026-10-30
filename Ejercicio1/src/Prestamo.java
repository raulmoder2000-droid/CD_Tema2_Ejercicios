import java.time.LocalDate;

public class Prestamo {
    private final Socio socio;
    private final Libro libro;
    private final LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;

    private Prestamo(Socio socio, Libro libro) {
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.activo = true;
    }

    /** Crea el préstamo solo si el libro tiene ejemplares disponibles. */
    public static Prestamo crear(Socio socio, Libro libro) {
        if (libro.prestarEjemplar()) {
            return new Prestamo(socio, libro);
        }
        return null;
    }

    /** Finaliza el préstamo y avisa al libro de la devolución. */
    public void finalizar() {
        if (!activo) {
            return;
        }
        activo = false;
        fechaDevolucion = LocalDate.now();
        libro.devolverEjemplar();
    }

    public Socio getSocio() { return socio; }
    public Libro getLibro() { return libro; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public boolean isActivo() { return activo; }
}

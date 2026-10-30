public class Libro {
    private final String titulo;
    private final String autor;
    private final String isbn;
    private int ejemplaresDisponibles;

    public Libro(String titulo, String autor, String isbn, int ejemplaresDisponibles) {
        if (ejemplaresDisponibles < 0) {
            throw new IllegalArgumentException("Los ejemplares no pueden ser negativos");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public boolean hayEjemplares() {
        return ejemplaresDisponibles > 0;
    }

    /** Presta un ejemplar si hay disponibles. Si no hay, el objeto no cambia. */
    public boolean prestarEjemplar() {
        if (!hayEjemplares()) {
            return false;
        }
        ejemplaresDisponibles--;
        return true;
    }

    public void devolverEjemplar() {
        ejemplaresDisponibles++;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public int getEjemplaresDisponibles() { return ejemplaresDisponibles; }
}

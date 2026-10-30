import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Alta de un libro con 3 ejemplares
        Libro libro = new Libro("El Quijote", "Miguel de Cervantes", "978-84-376-0494-7", 3);
        System.out.println("Alta libro: " + libro.getTitulo() + " -> ejemplares: " + libro.getEjemplaresDisponibles());

        // 2. Alta de dos socios
        Socio socio1 = new Socio("Ana", 1, LocalDate.now());
        Socio socio2 = new Socio("Luis", 2, LocalDate.now());
        System.out.println("Alta socios: " + socio1.getNombre() + " y " + socio2.getNombre());

        // 3. El primer socio toma prestado el libro
        Prestamo p1 = socio1.tomarPrestado(libro);
        mostrar(socio1, p1, libro);

        // 4. El segundo socio intenta tomar el mismo libro
        Prestamo p2 = socio2.tomarPrestado(libro);
        mostrar(socio2, p2, libro);

        // 5. El primer socio devuelve el libro
        socio1.devolver(p1);
        System.out.println(socio1.getNombre() + " devuelve el libro -> ejemplares: " + libro.getEjemplaresDisponibles());

        // 6. El segundo socio vuelve a intentar tomar el libro
        Prestamo p3 = socio2.tomarPrestado(libro);
        mostrar(socio2, p3, libro);
    }

    private static void mostrar(Socio socio, Prestamo prestamo, Libro libro) {
        String resultado = (prestamo != null) ? "EXITO" : "FALLO (no hay ejemplares)";
        System.out.println(socio.getNombre() + " pide el libro: " + resultado
                + " -> ejemplares: " + libro.getEjemplaresDisponibles());
    }
}

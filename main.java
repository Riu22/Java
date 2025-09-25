import java.util.ArrayList;

class Libro {
    private String titulo;
    private String autor;
    private boolean disponible = true;

    public Libro(String titulo, String autor, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    public void prestar() {
        cambiarEstado(false,
                "No se puede prestar \"" + titulo + "\" porque ya está prestado.",
                "El libro \"" + titulo + "\" ha sido prestado.");
    }

    public void devolver() {
        cambiarEstado(true,
                "No se puede devolver \"" + titulo + "\" porque ya estaba disponible.",
                "El libro \"" + titulo + "\" ha sido devuelto.");
    }

    private void cambiarEstado(boolean nuevoEstado, String mensajeError, String mensajeExito) {
        if (disponible == nuevoEstado) {
            System.out.println(mensajeError);
        } else {
            disponible = nuevoEstado;
            System.out.println(mensajeExito);
        }
    }

    public void mostrarInfo() {
        System.out.printf("Título: %s\nAutor: %s\nDisponible: %s\n",
                titulo, autor, disponible ? "Sí" : "No");
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getTitulo() {
        return titulo;
    }
}

class Biblioteca {
    private ArrayList<Libro> listaLibros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new RuntimeException("Libro no encontrado");
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("📚 Libros disponibles:");
        for (Libro libro : listaLibros) {
            if (libro.isDisponible()) {
                libro.mostrarInfo();
            }
        }
    }
}

public class main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro l1 = new Libro("Cien años de soledad", "Gabriel García Márquez", true);
        Libro l2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", true);
        Libro l3 = new Libro("El principito", "Antoine de Saint-Exupéry", true);

        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);

        biblioteca.mostrarLibrosDisponibles();

        Libro libroBuscado = biblioteca.buscarPorTitulo("El principito");
        if (libroBuscado != null) {
            libroBuscado.prestar();
        }

        biblioteca.mostrarLibrosDisponibles();

        if (libroBuscado != null) {
            libroBuscado.devolver();
        }

        biblioteca.mostrarLibrosDisponibles();
    }
}

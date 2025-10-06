import java.util.*;

public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;
    private final int isbn;
    private static int contador_isbn = 1;

    public Libro() {
        this.titulo = "tituloLibro"+contador_isbn;
        this.autor = "autorLibro"+contador_isbn;
        this.disponible = true;
        this.isbn = contador_isbn;
        contador_isbn++;
    }

    public Libro(Scanner sc) {
        System.out.print("Ingrese el titulo del libro: ");
        this.titulo = sc.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        this.autor = sc.nextLine();
        this.disponible = true;
        this.isbn = contador_isbn;
        System.out.println("El ISBN del libro sera: "+this.isbn);
        contador_isbn++;
    }

    public String getTitulo() {return this.titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getAutor() {return this.autor;}
    public void setAutor(String autor) {this.autor = autor;}

    public boolean isDisponible() {return this.disponible;}
    public void setDisponible(boolean disponible) {this.disponible = disponible;}

    public int getIsbn() {return isbn;}

    public String toString() {
        String string_disponible;
        if (disponible) {string_disponible = "Disponible";}
        else {string_disponible = "No disponible";}

        return string_disponible+". "+titulo+".("+autor+") ISBN: "+isbn;
    }

    public static void mostrarLibros(ArrayList<Libro> lista) {
        if (!lista.isEmpty()){
            System.out.println("Lista de libros: ");
            for (Libro l : lista){
                System.out.println("-"+l);
            }
        }
        else {
            System.out.println("Aun no tienes Libros registrados, porfavor registrar uno antes.");
        }
    }

    public static boolean isLibroDisponible(ArrayList<Libro> lista_libros){
        for (Libro l : lista_libros) {
            if (l.isDisponible()){
                return true;
            }
        }
        return false;
    }

    public static void mostrarLibrosDisponibles(ArrayList<Libro> lista) {
        if (lista.isEmpty()){
            System.out.println("Aun no tienes Libros registrados, porfavor registrar uno antes.");
        }
        else if(!Libro.isLibroDisponible(lista)) {
            System.out.println("No hay libros disponibles en esta lista.");
        }
        else {
            System.out.println("Lista de libros disponibles: ");
            for (Libro l : lista){
                if (l.isDisponible()){
                    System.out.println("-"+l);
                }
            }
        }
    }

}

import java.util.ArrayList;
import java.util.Scanner;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private boolean activo;
    private final int id_prestamo;
    private static int contador_prestamos = 1;

    public Prestamo(Scanner sc, ArrayList<Usuario> lista_usuarios, ArrayList<Libro> lista_libros) {
        this.libro = null;
        this.usuario = null;
        while (libro == null || usuario == null){
            System.out.println("Ingresar isbn del libro: ");
            int isbn = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingresar id del usuario que lo compra: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Libro l : lista_libros){
                if (l.getIsbn() == isbn) {
                    this.libro = l;
                }
            }
            for (Usuario u : lista_usuarios) {
                if (u.getId_usuario() == id) {
                    this.usuario = u;
                }
            }
            
            if (libro == null){
                System.out.println("ISBN del libro no valido. Vuelva a ingresar.");
            }
            else if (!libro.isDisponible()){
                System.out.println("El libro seleccionado no esta disponible, por favor vuelva a ingresar.");
                libro = null;
            }
            if (usuario == null) {
                System.out.println("El ID del usuario no es valido. Vuelva a ingresar.");
            }
        }
        this.activo = true;
        this.id_prestamo = contador_prestamos;
        libro.setDisponible(false);
        System.out.println("El id de este prestamo sera: "+id_prestamo);
        contador_prestamos++;
    }

    public Libro getlibro() {
        return libro;
    }
    public void setLibro(Libro libro){
        this.libro = libro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getId_prestamo() {
        return id_prestamo;
    }

    public boolean isActivo() {
        return activo;
    }
    public void setActivo() {
        if (activo){
            activo = false;
            libro.setDisponible(false);
        }
        else {
            activo = true;
            libro.setDisponible(true);
        }
    }

    public String toString(){
        String string_activo;
        if (activo) {string_activo = "Activo";}
        else {string_activo = "No activo";}
        return string_activo+". Usuario: "+usuario.getNombres()+"("+usuario.getId_usuario()+"). Libro: "+libro.getTitulo()+"("+libro.getIsbn()+")";
    }
    
    public static void devolverLibro(Scanner sc, ArrayList<Prestamo> lista) {
        boolean bucle = true;
        while (bucle){
            System.out.println("Ingresar el id del prestamo a devolver: ");
            int id = sc.nextInt();
            sc.nextLine();
            for (Prestamo p : lista) {
                if (p.getId_prestamo() == id){
                    if (p.isActivo()) {
                        p.setActivo();
                        p.getlibro().setDisponible(true);
                        bucle = false;
                    }
                    else {
                        System.out.println("Este prestamo ya fue devuelto.");
                    }
                }
            }
            if (bucle) {
                System.out.println("No se pudo encontrar el ID del prestamo.");
            }
            
        }

    }

    public static void mostrarPrestamos(ArrayList<Prestamo> lista) {
        if (!lista.isEmpty()){
            System.out.println("Registro de prestamos: ");
            for (Prestamo p : lista){
                System.out.println("-"+p);
            }
        }
        else {
            System.out.println("Aún no tienes prestamos registrados, porfavor registrar uno antes.");
        }
    }
}

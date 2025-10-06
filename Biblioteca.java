import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
    private Scanner sc;
    private ArrayList<Libro> lista_libros;
    private ArrayList<Usuario> lista_usuarios;
    private ArrayList<Prestamo> lista_prestamos;
    private boolean sesionActiva;

    public Biblioteca() {
        this.sc = new Scanner(System.in);
        this.lista_libros = new ArrayList<>();
        this.lista_usuarios = new ArrayList<>();
        this.lista_prestamos = new ArrayList<>();
        this.sesionActiva = true;
    }
    public char bienvenida() {
        System.out.println("Bienvenido al sistema de gestion de biblioteca");
        System.out.println("¿Deseas comenzar? (s/n)");
        return sc.next().charAt(0);
    }

    public void iniciar(){
        while(sesionActiva) {
            System.out.println("--------------------------------");
            System.out.println("---------MENU PRINCIPAL---------");
            System.out.println("Seleccione una opcion:");
            System.out.println("1)Agregar datos\n2)Mostrar base de datos\n3)Realizar un prestado\n4)Devolver libro\n5)verificar disponibilidad de un libro\n0)Cerrar");
            String seleccion = sc.nextLine();
            switch (seleccion) {
                case "1":
                    System.out.println("--------------------------------");
                    System.out.println("-------MENU AGREGAR DATOS-------");
                    System.out.println("Seleccione una opcion:");
                    System.out.println("1)Nuevo Usuario\n2)Nuevo Libro\n3)Volver");
                    String seleccion_1 = sc.nextLine();
                    switch (seleccion_1) {
                        case "1":
                            lista_usuarios.add(new Usuario());
                            System.out.println("Se logró ingresar el nuevo usuario con éxito!.");
                            break;
                        case "2":
                            lista_libros.add(new Libro());
                            System.out.println("Se logró ingresar el nuevo libro con éxito!.");
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Opcion ingresada no valida.\nPor favor ingresar uno de los numeros de la lista.");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("--------------------------------");
                    System.out.println("-------MENU MOSTRAR DATOS-------");
                    System.out.println("Seleccione una opcion:");
                    System.out.println("1)Mostrar usuarios\n2)Mostrar libros\n3)Mostrar prestamos\n4)Volver");
                    String seleccion_2 = sc.nextLine();
                    switch (seleccion_2) {
                        case "1":
                            Usuario.mostrarUsuarios(lista_usuarios);
                            break;
                        case "2":
                            Libro.mostrarLibros(lista_libros);
                            break;
                        case "3":
                            Prestamo.mostrarPrestamos(lista_prestamos);
                            break;
                        case "4":
                            break;
                        default:
                            System.out.println("Opcion ingresada no valida.\nPor favor ingresar uno de los numeros de la lista.");
                            break;
                    }
                    break;
                case "3":
                    if (lista_libros.isEmpty()) {
                        System.out.println("Lista de libros vacia. Agregar almenos uno antes de seguir.");
                    }
                    else if (!Libro.isLibroDisponible(lista_libros)) {
                        System.out.println("No hay ningun libro disponible en la lista. No es posible realizar un prestamo.");
                    }
                    else if (lista_usuarios.isEmpty()){
                        System.out.println("Lista de usuarios vacia. Agregar almenos uno antes de seguir");
                    }
                    else {
                        lista_prestamos.add(new Prestamo(sc, lista_usuarios, lista_libros));
                        System.out.println("Se logro hacer el prestamo con exito.");
                    }
                    break;
                case "4":
                    Prestamo.devolverLibro(sc, lista_prestamos);
                    break;
                case "5":
                    Libro.mostrarLibrosDisponibles(lista_libros);
                    break;
                case "0":
                    sesionActiva = false;
                    despedida();
                    break;
                default:
                    System.out.println("Opcion ingresada no valida.\nPor favor ingresar uno de los numeros de la lista.");
                    break;
            }
        }
    }

    public void despedida(){
        System.out.println("Gracias por usar el sistema de gestion de biblioteca.");
        sc.close();
    }
    
}

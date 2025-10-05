import java.util.Scanner;
import java.util.ArrayList;

public class Usuario {
    private String nombres;
    private final int id_usuario;
    private static int contador_usuarios = 1;

    public Usuario(){
        this.nombres = "usuarioNro"+contador_usuarios;
        this.id_usuario = contador_usuarios;
        contador_usuarios++;
    }

    public Usuario(Scanner sc) {
        System.out.println("Ingrese el nombre completa del nuevo usuario: ");
        this.nombres = sc.nextLine();
        this.id_usuario = contador_usuarios; 
        System.out.println("El id del usuario sera: "+id_usuario);
        contador_usuarios++;
    }

    public String getNombres() {return this.nombres;}
    public void setNombres(String nombres) {this.nombres = nombres;}
    public int getId_usuario() {return this.id_usuario;}

    public String toString(){
        return "Usuario: "+nombres+". ID: "+id_usuario;
    }

    public static void mostrarUsuarios(ArrayList<Usuario> lista) {
        if (!lista.isEmpty()){
            System.out.println("Lista de alumnos: ");
            for (Usuario u : lista){
                System.out.println("-"+u);
            }
        }
        else {
            System.out.println("Aun no tienes Usuarios registrados, porfavor registrar uno antes.");
        }
    }
}

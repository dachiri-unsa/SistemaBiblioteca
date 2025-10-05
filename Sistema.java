public class Sistema {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        char continuar = biblioteca.bienvenida();
        if (continuar == 's' || continuar == 'S') biblioteca.iniciar();
        else biblioteca.despedida();
    }
}

package Project;

import java.util.Scanner;

public class TiendaZapatos {

    // Máximo de usuarios permitidos
    static final int MAX_USERS = 5;
    // Array de usuarios
    static Usuario[] usuarios = new Usuario[MAX_USERS];
    static int contUsuarios = 0; // Para saber cuántos usuarios se han registrado

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nBienvenido");
            System.out.println("1. Registrar Zapato");
            System.out.println("2. Iniciar Seccion");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); // Aquí pedimos al usuario que ingrese una opción

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    iniciarSeccion();
                    break;
                case 3:
                    System.out.println("Saliendo de la Tienda...Vuelva Pronto ;)");
                    break;
                default:
                    System.out.println("Ingrese una opción válida!");
            }

        } while (opcion != 3);
        sc.close();
    }

    // Método para registrar un vehículo
    public static void registrarVehiculo() {
        if (contUsuarios >= MAX_USERS) {
            System.out.println("La tienda ya no tiene más capacidad :(");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombreUsuario = sc.nextLine();

        System.out.print("Ingresa Los Zapatos Elegidos: ");
        String Zapatos = sc.nextLine();

        System.out.print("Ingresa el modelo: ");
        String modeloZapatos= sc.nextLine();

        System.out.print("Establece tu contraseña: ");
        String contraseñaUsuario = sc.nextLine();

        // Crear nuevo usuario y añadir al array
        Usuario nuevoUsuario = new Usuario(nombreUsuario, Zapatos, modeloZapatos, contraseñaUsuario);
        usuarios[contUsuarios] = nuevoUsuario;
        contUsuarios++;

        System.out.println("Tus Zapatos han sido registrados exitosamente.");
    }

    // Método para iniciar sesión
    public static void iniciarSeccion() {
        if (contUsuarios == 0) {
            System.out.println("No hay Zapatos registrados.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = sc.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contraseña = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < contUsuarios; i++) {
            if (usuarios[i].getNombreUsuario().equals(nombreUsuario) &&
                    usuarios[i].getContraseña().equals(contraseña)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido a la Tienda, " + nombreUsuario + "!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nombre de usuario no encontrado o contraseña incorrecta.");
        }
    }
}

// Clase Usuario
class Usuario {
    private String nombreUsuario;
    private String Zapatos;
    private String modeloZapatos;
    private String contraseña;

    public Usuario(String nombreUsuario, String Zapatos, String modeloZapatos, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.Zapatos = Zapatos;
        this.modeloZapatos = modeloZapatos;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

}

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("Menu Examen Acceso a Datos");
            System.out.println("-----------------------------");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Lista de Usuarios Registrados");
            System.out.println("3. Comprobar Credenciales");
            System.out.println("4. Exportar Lista de Usuarios a Fichero");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.print("Introduce el nombre: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Introduce los apellidos: ");
                    String apellidos = sc.nextLine();
                    System.out.print("Introduce el correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Introduce la contraseña: ");
                    String pass = sc.nextLine();
                    try {
                        dao.insertarUsuario(new Usuario(nombre, apellidos, correo, pass));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Usuario añadido correctamente");
                }
                case 2 -> {
                    try {
                        System.out.println(dao.listarUsuarios());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    System.out.println("Introduce correo");
                    String correo = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Introduce contraseña");
                    String pass = sc.nextLine();
                    try {
                        dao.logIn(correo,pass);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 4 -> {
                    dao.exportarUsuarios();
                    System.out.println("Usuarios exportados");
                }
            }
        }while(opcion!=5);
        System.out.println("Aplicacion cerrada");


    }
}

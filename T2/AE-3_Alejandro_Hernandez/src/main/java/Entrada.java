import dao.CocheDAO;
import dao.PasajeroDAO;
import model.Coche;
import model.Pasajero;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        CocheDAO dao = new CocheDAO();
        PasajeroDAO pDao = new PasajeroDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("Menu AE3 Manejo de Conectores");
            System.out.println("-----------------------------");
            System.out.println("1. Registrar Coche");
            System.out.println("2. Borrar coche por id");
            System.out.println("3. Consultar coche por id");
            System.out.println("4. Modificar coche por id");
            System.out.println("5. Lista de coches");
            System.out.println("6. Gestion de Pasajeros");
            System.out.println("7. Salir de la applicacion");
            opcion = sc.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.print("Introduce la marca: ");
                    sc.nextLine();
                    String marca = sc.nextLine();
                    System.out.print("Introduce el modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Introduce el color: ");
                    String color = sc.nextLine();
                    try {
                        dao.insertarCoche(new Coche(marca, modelo, color));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Coche añadido correctamente");
                }
                case 2 -> {
                    System.out.println("Introduce el id del coche que deseas borrar");
                    int id = sc.nextInt();
                    try {
                        dao.borrarCochePorId(id);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Coche boprrado");
                }
                case 3 -> {
                    System.out.println("Introduce el id del coche a consultar");
                    int id = sc.nextInt();
                    try {
                        dao.consultarCocheId(id);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 4 -> {
                    System.out.println("Introduce el id del coche a modificar");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce Marca");
                    String marca = sc.nextLine();
                    System.out.println("Introduce Modelo");
                    String modelo = sc.nextLine();
                    System.out.println("Introduce Color");
                    String color = sc.nextLine();

                    try {
                        dao.modificarCochePorId(new Coche(id,marca,modelo,color));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Coche modificado");
                }
                case 5 ->{
                    try {
                        dao.listarCoches();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 6 ->{
                    int opcionSub = 0;
                    do {
                        System.out.println("Menu Gestion de Pasajeros");
                        System.out.println("-------------------------");
                        System.out.println("1. Insertar pasajero");
                        System.out.println("2. Borrar pasajero por id");
                        System.out.println("3. Consultar pasajero por id");
                        System.out.println("4. Lista de pasajeros");
                        System.out.println("5. Salir de la applicacion");
                        opcionSub = sc.nextInt();

                        switch (opcionSub){
                            case 1 ->{
                                System.out.print("Introduce el nombre: ");
                                sc.nextLine();
                                String nombre = sc.nextLine();
                                System.out.print("Introduce la edad: ");
                                int edad  = sc.nextInt();
                                System.out.print("Introduce el peso: ");
                                int peso  = sc.nextInt();
                                try {
                                    pDao.insertarPasajero(new Pasajero(nombre,edad,peso));
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                System.out.println("Pasajero añadido correctamente");
                            }
                            case  2 -> {
                                System.out.println("Introduce el id del pàsajero que deseas borrar");
                                int id = sc.nextInt();
                                try {
                                    pDao.borrarPasajeroPorId(id);
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                System.out.println("Pasajero boprrado");
                            }
                            case 3 ->{
                                System.out.println("Introduce el id del pasajero a consultar");
                                int id = sc.nextInt();
                                try {
                                  pDao.consultarPasajeroPorId(id);
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case 4 ->{
                                try {
                                    pDao.listarPasajeros();
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        }
                    }while (opcionSub!=5);
                }
            }
        }while(opcion!=6);
        System.out.println("Aplicacion cerrada");


    }
}

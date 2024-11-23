import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AlmacenCoche {
    private String cochesDat = "coches.dat";
    private String cochesCsv = "coches.csv";
    private ArrayList<Coche> coches = new ArrayList<>();

    public AlmacenCoche() {
        cargarDatos();
    }

    // Cargar datos desde el fichero coches.dat
    private void cargarDatos() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(cochesDat))) {
            coches = (ArrayList<Coche>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Guardar datos en coches.dat
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cochesDat))) {
            oos.writeObject(coches);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Exportar datos a CSV
    private void exportarACSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(cochesCsv))) {
            for (Coche coche : coches) {
                writer.printf("%d;%s;%s;%s;%s%n",
                        coche.getId(), coche.getMatricula(),
                        coche.getMarca(), coche.getModelo(), coche.getColor());
            }
            System.out.println("Datos exportados correctamente a " + cochesCsv);
        } catch (IOException e) {
            System.err.println("Error al exportar a CSV: " + e.getMessage());
        }
    }

    // Métodos CRUD
    public void añadirCoche(Coche nuevo) {
        for (Coche coche : coches) {
            if (coche.getId() == nuevo.getId() || coche.getMatricula().equals(nuevo.getMatricula())) {
                System.out.println("Error: ID o matrícula duplicados.");
                return;
            }
        }
        coches.add(nuevo);
        System.out.println("Coche añadido correctamente.");
    }

    public void borrarCoche(int id) {
        for(Coche coche: coches){
            if (coche.getId()==id){
                coches.remove(coche);
                System.out.println("Coche eliminado con exito");
            }else System.out.println("id de coche no encontrado");
        }
    }

    public void consultarCoche(int id) {
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                System.out.println(coche);
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }

    public void listarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el almacén.");
        } else {
            coches.forEach(System.out::println);
        }
    }

    // Menú de usuario
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("");
            System.out.println("\nMenú:");
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche por ID");
            System.out.println("3. Consultar coche por ID");
            System.out.println("4. Listar coches");
            System.out.println("5. Salir y exportar archivos");
            System.out.print("Seleccione una opción: ");
            System.out.println("");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    System.out.print("Introduce la Matrícula: ");
                    String matricula = sc.nextLine();
                    System.out.print("Introduce la Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Introduce el Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Introduce el Color: ");
                    String color = sc.nextLine();
                    añadirCoche(new Coche(id, matricula, marca, modelo, color));
                    System.out.println("Coche añadido correctamente");
                }
                case 2 -> {
                    System.out.print("Introduce el ID a borrar: ");
                    int id = sc.nextInt();
                    borrarCoche(id);
                }
                case 3 -> {
                    System.out.print("Introduce el ID a consultar: ");
                    int id = sc.nextInt();
                    consultarCoche(id);
                }
                case 4 -> listarCoches();
                case 5 -> {
                    guardarDatos();
                    exportarACSV();
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
        sc.close();
    }

    public static void main(String[] args) {
        AlmacenCoche gestorCoches = new AlmacenCoche();
        gestorCoches.mostrarMenu();
    }
}

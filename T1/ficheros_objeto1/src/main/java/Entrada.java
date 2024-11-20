import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        GestorFicheros gestorFicheros = new GestorFicheros();
       // gestorFicheros.escribirObjeto("src/main/java/resources/objetos_serializados.obj");
       // gestorFicheros.lecturaObjeto("src/main/java/resources/objetos_serializados.obj");
        // gestorFicheros.patata("src/main/java/resources/datos.bin");



        int numero = 0;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Introduce un numero");

           numero = sc.nextInt();
            if (numero >= 0) {
                System.out.println("Eres un puto anormal");
            } else {
                System.out.println("Tambien eres un puto anormal");
            }
        }while (numero!=1000);


        System.out.println("Fin puto payaso");
        }
    }


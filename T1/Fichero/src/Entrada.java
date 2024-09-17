import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Entrada {
    public static void main(String[] args) {

        //***********PRUEBA EN EL MAIN***********

       /* File ficheroSinPuntero = new File("src/resources/directorio/Prueba_directorio.txt");
        System.out.println(ficheroSinPuntero.getName());

        if (!ficheroSinPuntero.exists()){
            try {
                ficheroSinPuntero.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else System.out.println("El fichero ya existe"); */

        //***********EJERCICIO 1 ***********

        File ficherosDir = new File("src/resources/directorio");

        System.out.println(Arrays.stream(ficherosDir.list()).toList());

        //***********EJERCICIO 2 ***********

        File ficherosSub = new File("src/resources/directorio/subcarpeta");

        System.out.println(Arrays.stream(ficherosSub.list()).toList());

        //***********EJERCICIO 3 ***********


        File ficherosC = new File("C:\\Users");
        System.out.println(Arrays.stream(ficherosC.list()).toList());
    }


}

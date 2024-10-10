import controller.GestorFicheros;
import controller.GestorFicherosEscritura;
import controller.GestorFicherosLectura;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Entrada {
    public static void main(String[] args) {

       //GestorFicheros gestorFicheros = new GestorFicheros();
       //gestorFicheros.lecturaTextoPlano("src/resources/ficheros/Prueba_fichero.txt");
       //GestorFicherosLectura gestorFicherosLectura = new GestorFicherosLectura();
       //gestorFicherosLectura.gestorFicherosLectura("src/resources/ficheros/escritura.txt");
        GestorFicherosLectura gestorFicherosLectura = new GestorFicherosLectura();
        gestorFicherosLectura.gestorFicherosLectura("src/resources/ficheros/escritura.txt");

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

       /* File ficherosDir = new File("src/resources/directorio");

        System.out.println(Arrays.stream(ficherosDir.list()).toList());

        //***********EJERCICIO 2 ***********

        File ficherosSub = new File("src/resources/directorio/subcarpeta");

        System.out.println(Arrays.stream(ficherosSub.list()).toList());

        //***********EJERCICIO 3 ***********

        rutaDir("C:\\Users");

    }*/
   /* public static void rutaDir(String ruta){
    File ficherosC = new File("C:\\Users");

    if(ficherosC.isDirectory()){
        File [] archivos = ficherosC.listFiles();
        if(archivos!=null){
            for(File archivo:archivos){
                if(archivo.isFile()){
                    System.out.println("Archivo : " + archivo.getName());
                } else if (archivo.isDirectory()) {
                    System.out.println("Directorio : " + archivo.getName());
                    rutaDir(archivo.getAbsolutePath());

                }
            }
        }*/



    }


    }


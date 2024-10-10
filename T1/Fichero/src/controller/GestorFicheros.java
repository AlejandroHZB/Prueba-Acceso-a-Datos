package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestorFicheros {

    public void lecturaDirectorios(String path){
        
    }

    public void lecturaRecursiva(String path){

    }

    public void lecturaSubdirectorios(File fichero){

    }

    public void lecturaTextoPlano(String path){

        File file = new File(path);
        FileReader fileReader = null;
        if(file.exists() && (file.isFile()) ){
            try{
                fileReader = new FileReader(file);
               int lectura =  fileReader.read(); // int - UNICODE ASCI
            } catch ( FileNotFoundException e){
                System.out.println("Fallo en la lectura del fichero");
            } catch (IOException e) {
                System.out.println("Error en la escritura");
            } finally {
                try {
                    fileReader.close();
                } catch (IOException e){
                    System.out.println("Error cerrando el flujo");
                } catch (NullPointerException e){
                    System.out.println("Error al cerrar por ser nulo ");
                }
            }

        }

    }

}

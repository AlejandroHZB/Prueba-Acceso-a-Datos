package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestorFicherosEscritura {

    public void gestorFicherosLectura(String path){

        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.write("Buenas tardes.");
        } catch (IOException e) {
            System.out.println("Error");

        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cierre");
            }
        }

    }

}
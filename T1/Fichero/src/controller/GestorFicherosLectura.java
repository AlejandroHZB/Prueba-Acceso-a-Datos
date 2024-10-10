package controller;

import java.io.*;

public class GestorFicherosLectura {

    public void gestorFicherosLectura(String path){

        File file = new File(path);
        BufferedReader bf = null;

        try {

            bf = new BufferedReader(new FileReader(file));
            String lectura = null;
            }

            } catch (IOException e ) {
            System.out.println("Error");
            }
            finally {
                try {
                bf.close();
                } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cierre");
            }
        }

    }

}

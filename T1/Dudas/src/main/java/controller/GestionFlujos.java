package controller;

import model.Usuario;

import java.io.*;

public class GestionFlujos {

    //File siempre

   private File file = new File("src/main/java/resources/ejemplo.txt");
   private File fileBinario = new File("src/main/java/resources/ejemplo.bin");
    private File fileObjeto = new File("src/main/java/resources/ejemplo.obj");

    // TEXTO PLANO --> "asasasas".txt
    //FILE -> FILEWRITER lo malo es que no tiene salto de linea
    //FILEWRITER --> BUFFEREDWRITTER

    public void escrituraTP(){
        //  FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter =new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("Esto es una linea bufferedWritter");
        } catch (IOException e) {
            System.out.println("Error");;
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error en cierre");
            }
        }



        /*try {
            fileWriter = new FileWriter(file);
            fileWriter.write("Buenas tardes");


        } catch (IOException e) {
            System.out.println("Error");;
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error en cierre");
            }
       } */


    }
    public void lecturaTP(){

        File file = new File("src/main/java/resources/ejemplo.txt");
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;
            while((linea = bufferedReader.readLine()) !=null){
                System.out.println(linea);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /*FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int lectura = -1;
            while ( (lectura = fileReader.read()) > -1 ){
                System.out.print((char)lectura);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/

    }

    // BINARIO --> tipo de dato (int 5, boolean false...)
    //file --> FileInputStream --> DataInputSream

    public void lecturaBinario(){

        DataInputStream dataInputStream = null;

        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileBinario));

            System.out.println(dataInputStream.readUTF());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void escrituraBinario(){

        DataOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(fileBinario));
            dataOutputStream.writeUTF("Eyo klk klokua");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    // OBJETO --> Object()

    public void lecturaObjetos(){

    //File --> FileInputStream --> ObjectInputStream

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(fileObjeto));
            Object recuperado = null;
            while((recuperado = objectInputStream.readObject()) != null){
                System.out.println(((Usuario)recuperado).getNombre());

            }
        } catch (IOException e) {
            System.out.println("Error " +  e.getMessage());;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("ERROR");;
            }
        }

    }
    public void  escrituraObjetos(){

        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileObjeto));
            objectOutputStream.writeObject(new Usuario("Alejandro", "Hernandez", "correoeo.es"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

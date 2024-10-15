import model.Producto;

import java.io.*;

public class GestorFicheros {

    public void escribirBinarios(String path){

        File f = new File(path);
        DataOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(f));
            dataOutputStream.writeUTF("Esto es una prueba");
            dataOutputStream.writeInt(22);
            dataOutputStream.writeBoolean(true);


        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }finally {
            try {
                dataOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error cerrado");
            }
        }


    }

    public void lecturaBinarios(String path){

        File f = new File(path);
        DataInputStream dataInputStream = null;

        try {
            dataInputStream = new DataInputStream(new FileInputStream(f));
            //SEGUIMOS EL ORDEN QUE HEMOS ESTABLECIDO EN EL WRITE -> CHARS INT BOOLEAN
            String lectura = dataInputStream.readUTF();
            System.out.println(lectura);
            int numero = dataInputStream.readInt();
            System.out.println(numero);
            boolean boo = dataInputStream.readBoolean();
            System.out.println(boo);




        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }finally {
            try {
                dataInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error cerrado");
            }
        }


    }

    public void escribirObjeto(String path){

        File f = new File(path);
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(f));
            objectOutputStream.writeObject(new Producto(1,"Producto1",99.65,1));
            objectOutputStream.writeObject(new Producto(2,"Producto2",12.65,3));

        } catch (IOException e) {
            System.out.println("Error");
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error cerrado");
            }
        }

    }

    public void lecturaObjeto(String path){
        File file = new File(path);
        ObjectInputStream objectInputStream = null;


        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Producto producto = (Producto) objectInputStream.readObject();
            producto.mostrarDatos();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void patata(String path){

        File file = new File(path);
        DataInputStream dataInputStream = null;

        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
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

}






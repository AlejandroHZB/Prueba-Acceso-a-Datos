import java.io.IOException;

public class Entrada {
    public static void main(String[] args) {

       ProcessBuilder proceso = new ProcessBuilder("C");
        try{
            proceso.start();
            System.out.println("Proceso lanzado");
        }
        catch (IOException e){
            System.out.println(e.getMessage());

        }
    }
}

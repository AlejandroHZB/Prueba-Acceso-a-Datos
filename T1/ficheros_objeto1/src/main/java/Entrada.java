public class Entrada {
    public static void main(String[] args) {
        GestorFicheros gestorFicheros = new GestorFicheros();
       // gestorFicheros.escribirObjeto("src/main/java/resources/objetos_serializados.obj");
       // gestorFicheros.lecturaObjeto("src/main/java/resources/objetos_serializados.obj");
        gestorFicheros.patata("src/main/java/resources/datos.bin");
    }
}

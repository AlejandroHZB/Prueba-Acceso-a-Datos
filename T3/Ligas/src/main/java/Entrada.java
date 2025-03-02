import controller.LigaController;
import model.Entrenador;
import model.Jugador;
import model.Liga;

public class Entrada {
    public static void main(String[] args) {

        LigaController ligaController = new LigaController();
        // ligaController.agregarEntrenador(new Entrenador("AlejandroMister",11,0));
         ligaController.buscarPorNacionalida();

    }
}
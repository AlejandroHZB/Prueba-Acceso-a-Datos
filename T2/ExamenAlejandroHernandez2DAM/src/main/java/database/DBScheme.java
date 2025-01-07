package database;

public interface DBScheme {

    String HOST = "127.0.0.1";
    String PORT = "3306";

    //voy a usar la base de datos de la clase de repaso que ya la tengo creada y son los mismos parametros
    String DATABASE = "repaso";


    String tab_usuario = "usuarios";
    String col_id = "id";
    String col_nombre = "nombre";
    String col_apellido = "apellido";
    String col_pass = "password";
    String col_correo = "correo";
}

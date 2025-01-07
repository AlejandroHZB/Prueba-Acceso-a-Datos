package database;

public interface DBScheme {
    String HOST = "127.0.0.1";
    String PORT = "3306";
    String DATABASE = "ManejoConectores";

    String tab_coche = "coches";
    String col_coche_id= "id";
    String col_marca= "marca";
    String col_modelo= "modelo";
    String col_color= "color";

    String tab_pasajeros = "pasajeros";
    String col_pasajeros_id= "id";
    String col_nombre= "nombre";
    String col_edad= "edad";
    String col_peso= "peso";

}

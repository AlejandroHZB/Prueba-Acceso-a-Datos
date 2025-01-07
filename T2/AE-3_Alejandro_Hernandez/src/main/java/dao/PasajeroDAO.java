package dao;

import database.DBConnection;
import database.DBScheme;
import model.Pasajero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    List<Pasajero> listaPasajero = new ArrayList<>();

    public boolean insertarPasajero(Pasajero pasajero) throws SQLException {

        connection = new DBConnection().getConnection();

        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)", DBScheme.tab_pasajeros,DBScheme.col_nombre,DBScheme.col_edad,DBScheme.col_peso);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,pasajero.getNombre());
        preparedStatement.setInt(2,pasajero.getEdad());
        preparedStatement.setInt(3,pasajero.getPeso());

        return preparedStatement.execute();

    }

    public void borrarPasajeroPorId(int id) throws SQLException {
        connection = new DBConnection().getConnection();

        String query = String.format("DELETE FROM %s WHERE %S = ?",DBScheme.tab_pasajeros,DBScheme.col_pasajeros_id);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    public void consultarPasajeroPorId(int id) throws SQLException {

        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s WHERE %s = ?", DBScheme.tab_pasajeros,DBScheme.col_pasajeros_id);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        Pasajero pasajero = null;
        while(resultSet.next()) {
            int idP = (resultSet.getInt(DBScheme.col_pasajeros_id));
            String nombre = resultSet.getString((DBScheme.col_nombre));
            int edad = resultSet.getInt((DBScheme.col_edad));
            int peso = resultSet.getInt((DBScheme.col_peso));
            pasajero = new Pasajero(idP,nombre,edad,peso);
        }
        System.out.println(pasajero);
    }

    public List<Pasajero> listarPasajeros() throws SQLException {


        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s",DBScheme.tab_pasajeros);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        while(resultSet.next()){
            int id = (resultSet.getInt(DBScheme.col_pasajeros_id));
            String nombre = resultSet.getString((DBScheme.col_nombre));
            int edad = resultSet.getInt((DBScheme.col_edad));
            int peso = resultSet.getInt((DBScheme.col_peso));
            pasajeros.add(new Pasajero(id,nombre,edad,peso));

        }
        System.out.println(pasajeros);
        return pasajeros;
    }
}

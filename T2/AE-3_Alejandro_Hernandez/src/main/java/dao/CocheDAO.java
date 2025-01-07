package dao;

import database.DBConnection;
import database.DBScheme;
import model.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CocheDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    List<Coche> listaCoches = new ArrayList<>();

    public boolean insertarCoche(Coche coche) throws SQLException {

        connection = new DBConnection().getConnection();

        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)", DBScheme.tab_coche,DBScheme.col_marca,DBScheme.col_modelo,DBScheme.col_color);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,coche.getMarca());
        preparedStatement.setString(2,coche.getModelo());
        preparedStatement.setString(3,coche.getColor());

        return preparedStatement.execute();

    }

    public void borrarCochePorId(int id) throws SQLException {
        connection = new DBConnection().getConnection();

        String query = String.format("DELETE FROM %s WHERE %S = ?",DBScheme.tab_coche,DBScheme.col_coche_id);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
       preparedStatement.executeUpdate();
    }

    public void consultarCocheId(int id) throws SQLException {

        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s WHERE %s = ?", DBScheme.tab_coche,DBScheme.col_coche_id);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        Coche coche = null;
        while(resultSet.next()) {
            int idC = (resultSet.getInt(DBScheme.col_coche_id));
            String marca = resultSet.getString((DBScheme.col_marca));
            String modelo = resultSet.getString((DBScheme.col_modelo));
            String color = resultSet.getString((DBScheme.col_color));
            coche = new Coche(idC,marca,modelo,color);
        }
        System.out.println(coche);
    }

    public void modificarCochePorId(Coche coche) throws SQLException {

        connection = new DBConnection().getConnection();
        String query = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?",DBScheme.tab_coche,DBScheme.col_marca,DBScheme.col_modelo,DBScheme.col_color,DBScheme.col_coche_id);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,coche.getMarca());
        preparedStatement.setString(2,coche.getModelo());
        preparedStatement.setString(3,coche.getColor());
        preparedStatement.setInt(4,coche.getId());
        preparedStatement.executeUpdate();
    }

    public List<Coche> listarCoches() throws SQLException {


        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s",DBScheme.tab_coche);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        ArrayList<Coche> coches = new ArrayList<>();
        while(resultSet.next()){
           int id = (resultSet.getInt(DBScheme.col_coche_id));
           String marca = resultSet.getString((DBScheme.col_marca));
           String modelo = resultSet.getString((DBScheme.col_modelo));
           String color = resultSet.getString((DBScheme.col_color));
           coches.add(new Coche(id,marca,modelo,color));

        }
        System.out.println(coches);
        return coches;
    }


}

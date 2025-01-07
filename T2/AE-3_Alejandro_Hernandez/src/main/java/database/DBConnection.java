package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public Connection getConnection(){
        if(connection==null){
            try {
                createConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    private void createConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%s/%s", DBScheme.HOST,DBScheme.PORT,DBScheme.DATABASE);
        connection = DriverManager.getConnection(url,"root","");
    }

    public void closeConnection(){

        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

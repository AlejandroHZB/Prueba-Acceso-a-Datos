package dao;

import database.DBConnection;
import database.DBScheme;
import model.Usuario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    List<Usuario> usuarios = new ArrayList<>();

    public boolean insertarUsuario(Usuario usuario) throws SQLException {

        connection = new DBConnection().getConnection();

        String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                DBScheme.tab_usuario, DBScheme.col_nombre, DBScheme.col_apellido, DBScheme.col_correo, DBScheme.col_pass);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getApellido());
        preparedStatement.setString(3, usuario.getCorreo());
        preparedStatement.setString(4, usuario.getPass());

        if (usuario.getCorreo().equalsIgnoreCase(DBScheme.col_correo)){
            System.out.println("Error, correo ya registrado");
            return false;
        }else{
            usuarios.add(usuario);
        return preparedStatement.execute();}
    }
    public ArrayList<Usuario> listarUsuarios() throws SQLException {

        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM usuarios");
        resultSet = preparedStatement.executeQuery();

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(DBScheme.col_id);
            String nombre = resultSet.getString(DBScheme.col_nombre);
            listaUsuarios.add(new Usuario(id, nombre));
        }
        return listaUsuarios;
    }

    public boolean logIn(String correo, String pass) throws SQLException {
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(String.format("SELECT * FROM %s WHERE %s=? AND %s=?",
                 DBScheme.tab_usuario, DBScheme.col_correo, DBScheme.col_pass));
        preparedStatement.setString(1,correo);
        preparedStatement.setString(2,pass);
        resultSet = preparedStatement.executeQuery();

        if (correo.equals(DBScheme.col_correo) && pass.equals(DBScheme.col_pass)){
            System.out.println("LogIn correcto");
            return resultSet.next();

        }else System.out.println("Error");
        return false;
    }



    public void exportarUsuarios(){

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.obj"))) {
            out.writeObject(usuarios);
            System.out.println("Usuarios exportados a usuarios.obj.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PeticionJSON {

    public void procesarPeticion(){

        String urlString = "https://dummyjson.com/products";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea=null;
            StringBuffer stringBuffer = new StringBuffer();
            while((linea= bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }
            //System.out.println(bufferedReader.readLine());
            JSONObject peticionProducto = new JSONObject(stringBuffer.toString());
            JSONArray listaProductos = peticionProducto.getJSONArray("products");

            for ( Object item : listaProductos){
               JSONObject producto = (JSONObject)item;

                System.out.println(producto.getString("title"));
                System.out.println(producto.getDouble("price"));
                System.out.println("Las categorias son : ");

                JSONArray tags = producto.getJSONArray("tags");
                for( Object tag: tags ){
                    System.out.println("\t "+ tag);
                }

            }




            System.out.println("fin");

        } catch (MalformedURLException e) {
            System.out.println("Error en la URL");
        }catch (IOException ex){
            System.out.println("Eyoo");
        }

    }

}

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("1.Leer");
            System.out.println("2.Leer");
            System.out.println("3.Leer");
            System.out.println("4.Leer");
            System.out.println("5.Salir");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    try {
                        URL url = new URL("https://dummyjson.com/products");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
                        JSONArray jsonArray = jsonObject.getJSONArray("products");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject product = jsonArray.getJSONObject(i);
                            String title = product.getString("title");
                            String descripcion = product.getString("description");
                            Double price = product.getDouble("price");
                            System.out.printf("El producto con titulo %s, %s y con precio : %.2f ",title,descripcion,price);

                        }
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }while (opcion!=5);
    }
}

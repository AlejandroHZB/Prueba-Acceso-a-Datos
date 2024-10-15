import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MenuJson {
    public static void main(String[] args) {

        int opcion = 0;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("1.LEER");
            System.out.println("2.BUSCAR");
            System.out.println("3.FILTRAR");
            System.out.println("4.EXPORTAR");
            System.out.println("5.SALIR");
            System.out.println("ELIGE UNA OPCION");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("LEER JSON");
                    URL url = null;
                    try {
                        url = new URL("https://dummyjson.com/products");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String lectura = bufferedReader.readLine();
                        JSONObject jsonObject = new JSONObject(lectura);
                        JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("products"));

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject product = jsonArray.getJSONObject(i);
                            String title = product.getString("title");
                            String description = product.getString("description");
                            Double price = product.getDouble("price");
                            System.out.printf("El producto %s tiene como precio %.2f y una descripcion de %s\n",
                                    title, price, description);
                        }

                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 2:
                    try {
                        Scanner leer = new Scanner(System.in);
                        System.out.println("Introduce el id del prodecto");
                        int id = leer.nextInt();
                        url = new URL("https://dummyjson.com/products");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String lectura = bufferedReader.readLine();
                        JSONObject jsonObject = new JSONObject(lectura);
                        JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("products"));

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject product = jsonArray.getJSONObject(i);
                            if(id== product.getInt("id")) {
                                String title = product.getString("title");
                                String description = product.getString("description");
                                Double price = product.getDouble("price");
                                System.out.printf("El producto %s tiene como precio %.2f y una descripcion de %s\n",
                                        title, price, description);
                            }
                        }

                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Introduce preio maximo");
                    int maxA = sc.nextInt();
                    System.out.println("Introduce preio minimo");
                   int minA =  sc.nextInt();
                    filtrarPrecio(minA,maxA);
                    break;
                case 4:
                    exportarFichero();
                    break;
            }

        } while (opcion != 5);


    }
    public static void filtrarPrecio(int min,int max){
        try {

            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lectura = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(lectura);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("products"));

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject product = jsonArray.getJSONObject(i);
                double price = product.getDouble("price");
                if(price>min && price<max) {
                    String title = product.getString("title");
                    String description = product.getString("description");
                    System.out.printf("El producto %s tiene como precio %.2f y una descripcion de %s\n",
                            title, price, description);
                }
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportarFichero(){

        File file = new File("src/main/java/entrada.txt");
        PrintWriter printWriter = null;
        try {
             printWriter = new PrintWriter(new FileWriter(file));

             URL url = new URL("https://dummyjson.com/products");
             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             String lectura = bufferedReader.readLine();
             JSONObject jsonObject = new JSONObject(lectura);
             JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("products"));
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject product = jsonArray.getJSONObject(i);
                    double price = product.getDouble("price");
                    String title = product.getString("title");
                    String description = product.getString("description");
                    String exportarProducto = String.format("El producto %s tiene como precio %.2f y una descripcion de %s" ,title, price, description);


                }

            } catch (MalformedURLException e) {
            System.out.println("Error");
            } catch (IOException e) {
            System.out.println("Error");
            }
        System.out.println("Exportacion completada");
    }

}

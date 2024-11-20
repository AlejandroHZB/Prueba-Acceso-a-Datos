import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entrada {
    public static void main(String[] args) {

        //Connection

        String connectionString = "mongodb+srv://Mongo:Mongo@cluster0.hnlzx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("academia");
        MongoCollection collection = database.getCollection("usuarios");

       // Document documentInsecion = new org.bson.Document();
       // documentInsecion.append("Nombre", "Borja");
       // documentInsecion.append("Apellido", "Perez");
       // documentInsecion.append("Edad", "40");
       // documentInsecion.append("correo", "wllo@asas");

        List<Document> lisaInsercion = Arrays.asList(
                new Document().append("Nombre","Juan").append("Apellido","Gomez").append("Edad",20).append("Correo","asassaas@aa"),
                new Document().append("Nombre","Ana").append("Apellido","Lopez").append("Edad",30).append("Correo","ole@aa"),
                new Document().append("Nombre","Pedro").append("Apellido","Sol").append("Edad",21).append("Correo","asasasaaaqs@aa")
        );

        collection.insertMany(lisaInsercion);




        //database
        //collection
            //create -> insertOne / many
            //Update -> update
            //delete -> delete
            //select -> find

    }
}

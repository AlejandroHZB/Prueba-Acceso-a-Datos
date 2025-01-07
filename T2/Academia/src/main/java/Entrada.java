import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entrada {
    public static void main(String[] args) {

        //database
            //collection
                //create -> insertOne / many
                 //Update -> update
                 //delete -> delete
                 //select -> find

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

        //INSERT

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

        //FIND
        /*
        Document filtroEdad = new Document().append("edad",new Document().append("$gt",45).append("$lt",60));
        FindIterable resultado = collection.find(filtroEdad);
        MongoCursor<Document> cursor = resultado.iterator();

        while(cursor.hasNext()){
            Document document = cursor.next();
            String nombre = document.getString("nombre");
            String apellido = document.getString("apellido");
            int edad = document.getInteger("edad");
            System.out.println(nombre + " " + apellido + " " + edad );
        }*/

        //UPDATE

        Document docOriginal = new Document().append("nombre","Borja").append("edad",new Document().append("$lte",40));
        Document docUpdate = new Document().append("$set",new Document("edad",50));
        UpdateResult result =  collection.updateMany(docOriginal,docUpdate);
        System.out.printf("El resultado de la actualizacion ha afectado a %d registros",result.getModifiedCount());

        //DELETE
        Document delDoc = new Document().append("edad",new Document().append("lt",70));
       // collection.deleteOne(delDoc);

        //

        DeleteResult deleteResult = collection.deleteMany(delDoc);
        System.out.println("El resultado del borrado es de : " + deleteResult.getDeletedCount());



    }
}

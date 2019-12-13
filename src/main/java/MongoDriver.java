import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDriver {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    public static MongoCollection<Document> getMongoCollection() {
        if (collection == null) {
            mongoClient = MongoClients.create();
            database = mongoClient.getDatabase("bucephalus");
            collection = database.getCollection("stock_prices");
        }

        return collection;
    }
}

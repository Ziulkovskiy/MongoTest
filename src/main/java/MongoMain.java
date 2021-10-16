import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

public class MongoMain {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = new MongoClient();
        DB database = mongoClient.getDB("myMongoDb");
        mongoClient.getDatabaseNames().forEach(System.out::println);
        database.createCollection("customers", null);
        System.out.println("After creating collection");
        database.getCollectionNames().forEach(System.out::println);

        DBCollection collection = database.getCollection("customers");
        /*BasicDBObject document = new BasicDBObject();
        document.put("name", "Shubham");
        document.put("company", "Baeldung");
        collection.insert(document);*/

       /* BasicDBObject query = new BasicDBObject();
        query.put("name", "Shubham");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "John");

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        collection.update(query, updateObject);*/

        /*BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John");
        DBCursor cursor = collection.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }*/
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John");

        collection.remove(searchQuery);

    }
}

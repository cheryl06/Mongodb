/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 *
 * @author cheryldsouza
 */
public class querysix {
    public static void main(String[] args) throws UnknownHostException {
        //Connect to mongoDB
        MongoClient mongo = new MongoClient();
        //Connect to database and collection
        DB db = mongo.getDB("db");
        DBCollection partialCollection = db.getCollection("tags_import");
        //Create object that queries for MovieIDs that contain MST3k
        DBObject partial = new BasicDBObject("tag", "MST3K");
        //Use cursor to walk through collection one step at a time
        DBCursor cursor = partialCollection.find(partial);
        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }
    
}

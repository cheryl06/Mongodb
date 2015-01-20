/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package mongodb;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import java.net.UnknownHostException;
import java.util.List;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;


/**
 *
 * @author cheryldsouza
 */
public class Ratings_5 {
     public static void main(String[] args) throws UnknownHostException {
                MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("db");
		DBCollection Collection = db.getCollection("ratings");
                
                //Specifying Rating = 5 in BasicDBObject since we want to find out movie id's for which Rating = 3
                BasicDBObject object =new BasicDBObject("Rating",3);
                
                //Creating List to find out distinct movie ids which have rating = 3
                List MovieId = Collection.distinct("MovieID", object);
                
                System.out.println("The Movie Id's with rating 3: \n");
                
                for(int i=0; i < MovieId.size(); i++)
                {
                    System.out.println(MovieId.get(i).toString());
                }
                
                
                
          }
}

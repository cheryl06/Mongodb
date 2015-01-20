/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mongodb;

import com.mongodb.DB;
import java.net.UnknownHostException;
import com.mongodb.DBCollection;
import java.util.List;
import com.mongodb.MongoClient;


/**
 *
 * @author cheryldsouza
 */
public class Distinct_titles {
     public static void main(String[] args) throws UnknownHostException {
		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("db");
		DBCollection Collection = db.getCollection("movies_import");
                
                //Creating list object to store the distinct Movie titles
                List listed = Collection.distinct("Title");
                
                System.out.println("The distinct Movie titles are : \n"); 
                
                //For loop is used to parse the entire list od Distinct titles and display results
                for(int i=0; i < listed.size(); i++)
                {
                    System.out.println(listed.get(i).toString());
                }
    }
    
}

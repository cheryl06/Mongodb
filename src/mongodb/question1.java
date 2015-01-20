

package mongodb;
import java.net.UnknownHostException;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


/**
 *
 * @author cheryldsouza
 */
public class question1 {
public static void main(String[] args) throws UnknownHostException {
		
		MongoClient mongoclient = new MongoClient();
		DB db = mongoclient.getDB("db");
		DBCollection collection = db.getCollection("ratings");
		
		
		
		DBObject group_Movies = new BasicDBObject("_id","$MovieID");
                
		group_Movies.put("avgerageRating",new BasicDBObject("$avg","$Rating"));
		DBObject obj = new BasicDBObject("$group",group_Movies);
		
		
		AggregationOutput out = collection.aggregate(obj);
		
		
                for(DBObject objs : out.results()){
			String id = objs.get("_id").toString();
			String num = objs.get("avgerageRating").toString();
			System.out.println("MovieID "+id+" "+"has an average rating of "+ num);
		}
	}    
}

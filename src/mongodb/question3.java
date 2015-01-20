

package mongodb;
import java.net.UnknownHostException;
import java.util.List;
import java.util.ArrayList;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author cheryldsouza
 */
public class question3 {
  
		public static void main(String []args) throws UnknownHostException, MongoException
	{
		
		Mongo mongo=new Mongo();
		DB db=mongo.getDB("db");
		DBCollection movies_coll=db.getCollection("movies_import");
		
         //query all the genres
	   
	     DBCursor genreCur=movies_coll.find();
	    
	     ArrayList<String> list=new ArrayList<String>();
	    while(genreCur.hasNext())
	    {
	    	//the genre's list is called
	    	DBObject object=genreCur.next();
	    	BasicDBObject basicobj=new BasicDBObject();
	    	
	    	String Genre=(String) object.get("Genres");
	    	
	    	//the genres are split and placed in array
	    	String []a=Genre.split("\\|");
	    	
	    	int aLength=a.length;
	    	
	    	for(int i=0;i<aLength;i++)
	    	{
	    	list.add(a[i]);
	    	}	    	
	    }
	    
	// main part
        System.out.println("Number of movies in each genre are");
        
        Map m=new HashMap();
        
        for(String t:list)
        {
        	Integer sum=(Integer) m.get(t);
        	m.put(t, (sum==null)?1:sum+1);
        	
        }
         
        printMapResult(m);  

	}
	   
	public static void printMapResult(Map<String,Integer> m)
	{   
		  Set<String> set=m.keySet();
		  
		  for(Iterator<String> it=set.iterator();it.hasNext();)
		  {
			  Object genre=it.next();
						
			  System.out.println("No. of movies in  "+genre+" genre is "+m.get(genre)+".");
		  }
	 }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mongodb;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;


/**
 *
 * @author cheryldsouza
 */
public class tagsimport {
     public static void main(String []args) throws UnknownHostException, MongoException
    {
    
		Mongo mongo=new Mongo();  
		
		
		List<String> databases = mongo.getDatabaseNames();
		for(String str : databases){
			System.out.println(str);
		}
		
		
		
		DB db=mongo.getDB("db");
		
		
		DBCollection dbCollection=db.getCollection("tags_import");
    	
		FileReader filereader=null;
		BufferedReader bufferreader=null;
		
		
		try
		   {
			   filereader=new FileReader("/Users/cheryldsouza/Documents/UPITT/Data Analytics/ml-10M100K/tags.dat");
			   bufferreader=new BufferedReader(filereader);
			   System.out.println("Mongodb Tags File");
	           
			   String read=bufferreader.readLine();			 
		  
	       	while(read != null)
	       	{
	     	    System.out.println(read);
				 		
				String []reads = read.split("::");
			
				//inserting keys
				
				BasicDBObject object = new BasicDBObject();
				
				//UserID::MovieID::Tag::Timestamp
				
				object.append("UserID", reads[0]);
				
				object.append("MovieID", reads[1]);
				
				object.append("Tag",reads[2]);
				
				object.append("Timestamp",reads[3]);
				
				dbCollection.insert(object);
				read=bufferreader.readLine();
	       	}
				
		    }
	    	catch(FileNotFoundException e)
		     {
			    System.out.println("No documents found. Please try again");
			    System.exit(-1);
		       }
	   
		   catch(IOException e)
		     {
			   System.out.println("FAILED");
	           System.exit(-1);
		      }
    }
}
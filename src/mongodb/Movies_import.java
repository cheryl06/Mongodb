/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

/**
 *
 * @author cheryldsouza
 */
public class Movies_import {
     public static void main(String []args) throws UnknownHostException, MongoException, FileNotFoundException, IOException
    {
    	 
		Mongo mongo=new Mongo();  //creating an instance of mongodb called mongo
		
		//using mongo object to get the database name
		List<String> databases = mongo.getDatabaseNames();
		for(String string : databases){
			System.out.println(string);
		}
		
		
		//assigning db variable to mongoDB directory 'db' created in the terminal
		DB db=mongo.getDB("db");
		
	
		DBCollection Collection=db.getCollection("movies_import");
    	
		FileReader filereader=null;
		BufferedReader bufferreader=null;
		
		
		try
		   {
			   filereader=new FileReader("/Users/cheryldsouza/Documents/UPITT/Data Analytics/ml-10M100K/movies.dat");
			   bufferreader=new BufferedReader(filereader);
			   System.out.println("Mongodb Files");
	           
			   String read=bufferreader.readLine();			 
		  
	       	while(read != null)
	       	{
	     	    System.out.println(read);
				 		
				String []reads = read.split("::");
			
				
				
				BasicDBObject object = new BasicDBObject();
				
				
				
				object.append("MovieID", reads[0]);
				
				object.append("Title",reads[1]);
				
				object.append("Genres",reads[2]);
				
			
				Collection.insert(object);
				read=bufferreader.readLine();
	       	}
				
		    }
	    	catch(FileNotFoundException e)
		     {
			    System.out.println("Documents not found");
			    System.exit(-1);
		       }
	   
		   catch(IOException e)
		     {
			   System.out.println("FAILED");
	           System.exit(-1);
		      }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mongodb;
import com.mongodb.AggregationOutput;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;


/**
 *
 * @author cheryldsouza
 */
public class question2 {
   public static void main(String[]args) throws UnknownHostException, MongoException
	{
		
		
		 Mongo mongoclient=new Mongo();
  
		
		DB db=mongoclient.getDB("db");

		DBCollection Collection=db.getCollection("tags_import");
   
		
		//Need to enter the userid
	    System.out.println("Enter the User Id here");
	    Scanner userid=new Scanner(System.in);
	    String UserId=userid.next();
	
	  
	    BasicDBObject user=new BasicDBObject();
	    user.put("UserID", UserId);
	    
      
	    
	    DBCursor usercursor=Collection.find();
	    usercursor=Collection.find(user);              
	   
	  
	   	
	    
	    while(usercursor.hasNext()){
	        DBObject object= usercursor.next();
	        String MovieID=(String) object.get("MovieID");
	       
	         System.out.println("MovieID is "+MovieID);
	       
	       //for each Movie Id find the target id
	        BasicDBObject targetid=new BasicDBObject();
	        targetid.put("MovieID", MovieID);
	        
	        DBCursor moviecursor=Collection.find();
	        moviecursor=Collection.find(targetid); 
	        
	        int count=moviecursor.count();
		    System.out.println("This movie has been rated "+count+" users"); 
		    System.out.println(count);
	    
		    while(moviecursor.hasNext()){
		     DBObject object2= moviecursor.next();
		     String folluserID=(String) object2.get("UserID");
		     System.out.println("The following  Users are familiar to the given user  "+folluserID);
		    }
		    System.out.println();
	    }
	        
	}

}




    

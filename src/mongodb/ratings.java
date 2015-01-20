

package mongodb;
import java.io.*;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class ratings {
    
     public static void main(String[] args) throws IOException{
    
     FileReader f = null;
                 BufferedReader reader=null;

                 //Creating MongoClient object to get the name of the database
             MongoClient mongoclient = new MongoClient();
                DB dbobj = mongoclient.getDB("db");
             
             DBCollection coll = dbobj.getCollection("ratings");
                 try {
               
                     //Finding the file using File class object
             File files=new File("/Users/cheryldsouza/D/Data Analytics/ml-10M100K/ratings.dat"); 
                
             f=new FileReader(files);           
                                  
             String line;
                
             //Reading file using BufferedReader
                 reader= new BufferedReader(f);
                 
                 //Reading till end of file
               while((line=reader.readLine()) != null) {
               
                   //Replacing "::" with "," to maintain compatibility with MongoDB operations
                   line=line.replaceAll("::", ","); 
               String[] array=line.split(",");
               BasicDBObject ratings = new BasicDBObject();
                        ratings.append("UserID", Integer.parseInt(array[0]));
                        ratings.append("MovieID", Integer.parseInt(array[1]));
                        ratings.append("Rating", Double.parseDouble(array[2]));
                        ratings.append("Timestamp",array[3]);
                        
                        //Inserting values into collection ratings
                        coll.insert(ratings);
                        System.out.println(line);
              
               }
            }
                
               catch(IOException e)
               {
                System.out.println(e);
               }

                
               
                try{
                        
                        
                        f.close();
                }
                catch(IOException e3){
                        e3.printStackTrace();
                        
                }
                try
                {
                    reader.close();
                }
                catch(IOException e1){
                        e1.printStackTrace();
                        
                }

    
     }
}

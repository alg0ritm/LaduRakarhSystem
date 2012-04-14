package ttu.rakarh1.backend.dao ;
import java.sql.* ;
import java.util.*;
import ttu.rakarh1.log.MyLogger ;



public class dbconnection {

     String pwd = "";
     String usr = "";
     String url = "";
     Connection db_connection=null ;	



 public Connection getConnection() {
       // MyLogger.Log("db_connection.getConnection():","KYSITI ANDMEBAASIYHENDUS");	
  if (this.db_connection == null)
   {
    try
    {  
      // MyLogger.Log("db_connection.getConnection():","TEEN UUE REAALSE ANDMEBAASIYHENDUSE");	
      ResourceBundle bundle = ResourceBundle.getBundle("DBConnection");
      Class.forName(bundle.getString("Driver"));
      this.url = bundle.getString("URL");
      this.usr = bundle.getString("usr");
      this.pwd = bundle.getString("pwd");
      this.db_connection = DriverManager.getConnection(this.url, this.usr, this.pwd);      
    }
  catch(Exception ex)
    {  
			MyLogger.Log("db_connection.getConnection():",ex.getMessage());
	 }
	}
   
return this.db_connection;
}


 public void close() {

  try {
  if (this.db_connection != null)
   {
       // MyLogger.Log("db_connection.getConnection():","PANIN REAALSE ANDMEBAASIYHENDUSE KINNI");	
       this.db_connection.close();
	}   

         }
    catch(Exception ex)
    {
			MyLogger.Log("db_connection.close():",ex.getMessage());
    }


}


}



package ttu.rakarh1.dao ;
import  ttu.rakarh1.log.MyLogger ;
import  java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Hibernate;

public class SessionManager {

   private Session session = null ;
	public void close()
	{
	try
	   {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	     if (session != null)
	     {
	      session.close();
		  MyLogger.Log("SessionManager - panin sessiooni kinni","");
	     }
		 }
	     catch(Exception ex)
		{ 
			MyLogger.Log("SessionManager.close():",ex.getMessage());
		} 
	

}

}
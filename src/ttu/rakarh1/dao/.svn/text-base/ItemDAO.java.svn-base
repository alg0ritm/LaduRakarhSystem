package ttu.rakarh1.dao;



import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.backend.model.data.Item;

public class ItemDAO 
{
	private List<Item> itemList;
	public List<Item> getItems_fromDB()
	{
		MyLogger logger = new MyLogger();
		itemList = null;
		Session session = null;
		try 
		{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			itemList = session.createQuery("from Product as a").list();
			
		}
		catch(Exception e)
		{
			MyLogger.LogMessage("Error in creating/executing HQL query");
		}
		return itemList;
		}
}



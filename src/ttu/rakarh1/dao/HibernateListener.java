package ttu.rakarh1.dao;
import javax.servlet.*;
import javax.servlet.http.*;
public class HibernateListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory(); // Just call the static initializer of that class    
	}

	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getSessionFactory().close(); // Free all resources
	}
}

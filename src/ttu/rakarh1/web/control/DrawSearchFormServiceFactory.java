package ttu.rakarh1.web.control;

import java.util.ResourceBundle;

import ttu.rakarh1.backend.model.service.DrawSearchFormService;
import ttu.rakarh1.backend.model.service.DrawSearchFormServiceImpl;
import ttu.rakarh1.backend.model.service.ProductCatalogTree;
import ttu.rakarh1.log.MyLogger;

public class DrawSearchFormServiceFactory {

	String SERVICE_TYPE = "";	
	DrawSearchFormService factoredDrawSearchFormService = null;
	
	public DrawSearchFormService getService()
	{
		try
		{            
			ResourceBundle bundle = ResourceBundle.getBundle("ApplicationSetup");
			this.SERVICE_TYPE = bundle.getString("service_type");

			if (this.SERVICE_TYPE.equals("emulator"))
			{
				//factoredDrawSearchFormService =  new ttu.rakarh1.web.control.factoredDrawSearchFormService();
			}
			if (this.SERVICE_TYPE.equals("real_backend_service"))
			{
				factoredDrawSearchFormService =  new DrawSearchFormServiceImpl();
			}     


		}
		catch(Exception ex)
		{  
			MyLogger.Log("ProductCatalogServiceFactory.getTree():",ex.getMessage());
		}
		return factoredDrawSearchFormService;
	}
}

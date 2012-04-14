package ttu.rakarh1.web.control;

import java.util.ResourceBundle;

import ttu.rakarh1.backend.model.service.DrawSearchFormService;
import ttu.rakarh1.backend.model.service.DrawSearchFormServiceImpl;
import ttu.rakarh1.backend.model.service.LoginService;
import ttu.rakarh1.backend.model.service.LoginServiceImpl;
import ttu.rakarh1.log.MyLogger;

public class LoginServiceFactory
{
	String SERVICE_TYPE = "";	
	LoginService factoredLoginServiceFactory = null;
	
	public LoginService getService()
	{
		try
		{            
			ResourceBundle bundle = ResourceBundle.getBundle("ApplicationSetup");
			this.SERVICE_TYPE = bundle.getString("service_type");

			if (this.SERVICE_TYPE.equals("emulator"))
			{
				//factoredLoginServiceFactory =  new ttu.rakarh1.web.control.factoredLoginServiceFactory();
			}
			if (this.SERVICE_TYPE.equals("real_backend_service"))
			{
				factoredLoginServiceFactory =  new LoginServiceImpl();
			}     


		}
		catch(Exception ex)
		{  
			MyLogger.Log("LoginServiceFactory.getTree():",ex.getMessage());
		}
		return factoredLoginServiceFactory;
	}
}


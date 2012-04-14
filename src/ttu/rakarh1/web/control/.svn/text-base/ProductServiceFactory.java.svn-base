package ttu.rakarh1.web.control;
import java.util.*;
import ttu.rakarh1.log.MyLogger ;
import ttu.rakarh1.backend.model.service.* ;

public class ProductServiceFactory {

	String SERVICE_TYPE = "";	
    ProductService factoredProductService = null;
	
	public ProductService getService()
	{
		try
		{            
			ResourceBundle bundle = ResourceBundle.getBundle("ApplicationSetup");
			this.SERVICE_TYPE = bundle.getString("service_type");

			if (this.SERVICE_TYPE.equals("emulator"))
			{
				factoredProductService =  new ttu.rakarh1.web.control.ProductServiceEmulator();
			}
			if (this.SERVICE_TYPE.equals("real_backend_service"))
			{
				factoredProductService =  new ttu.rakarh1.backend.model.service.ProductServiceImpl();
			}     


		}
		catch(Exception ex)
		{  
			MyLogger.Log("ProductServiceFactory.getService():",ex.getMessage());
		}
		return factoredProductService;
	}


}

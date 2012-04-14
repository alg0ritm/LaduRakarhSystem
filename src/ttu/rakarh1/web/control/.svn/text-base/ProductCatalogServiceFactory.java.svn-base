package ttu.rakarh1.web.control;
import java.util.*;
import ttu.rakarh1.log.MyLogger ;
import ttu.rakarh1.backend.model.service.* ;

public class ProductCatalogServiceFactory {

	String SERVICE_TYPE = "";	
    ProductCatalogTree factoredProductCatalogTree = null;
	
	public ProductCatalogTree getTreeService()
	{
		try
		{            
			ResourceBundle bundle = ResourceBundle.getBundle("ApplicationSetup");
			this.SERVICE_TYPE = bundle.getString("service_type");

			if (this.SERVICE_TYPE.equals("emulator"))
			{
				factoredProductCatalogTree =  new ttu.rakarh1.web.control.ProductCatalogTreeEmulator();
			}
			if (this.SERVICE_TYPE.equals("real_backend_service"))
			{
				factoredProductCatalogTree =  new ttu.rakarh1.backend.model.service.ProductCatalogTreeImpl();
			}     


		}
		catch(Exception ex)
		{  
			MyLogger.Log("ProductCatalogServiceFactory.getTree():",ex.getMessage());
		}
		return factoredProductCatalogTree;
	}


}

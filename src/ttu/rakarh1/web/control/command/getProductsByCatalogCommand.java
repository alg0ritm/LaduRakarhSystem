package ttu.rakarh1.web.control.command;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.service.ProductCatalogTree;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.ProductCatalogServiceFactory;
import ttu.rakarh1.web.control.ProductServiceFactory;
import ttu.rakarh1.web.control.StateHandler;

public class getProductsByCatalogCommand implements Command {


	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException  {
		int operation_result = 0;

		try {
			int selected_catalog_id = 0;
			List<ttu.rakarh1.backend.model.data.Product> products = null;
	     	String request_selected_catalog_id ="";
			request_selected_catalog_id = request.getParameter("catalog");
			selected_catalog_id = Integer.parseInt(request_selected_catalog_id);
			ProductService ProductService = null;
			ProductServiceFactory ProductServiceFactory = new ProductServiceFactory();
			ProductService = ProductServiceFactory.getService();



			if(selected_catalog_id>0)
			{
				products = ProductService.getProductsByCatalog(selected_catalog_id);
				request.setAttribute ("products", products);

				ProductCatalogTree ProductCatalogTree = null;
				ProductCatalogServiceFactory ProductCatalogServiceFactory = new ProductCatalogServiceFactory();
				ProductCatalogTree = ProductCatalogServiceFactory.getTreeService();
				ProductCatalog selectedCatalog = ProductCatalogTree.getProductCatalogById(selected_catalog_id);
				MyLogger.LogMessage("No null in + getProductCatalogById(" + selected_catalog_id + ");");
				stateHandler.setSelectedCatalog(selectedCatalog);

				request.setAttribute(Constant.SHOW_ADD_PRODUCT, "true");
			}
			operation_result = -1;
		} catch (Exception ex) {
			operation_result = 0;
			MyLogger.Log("getProductsByCatalogCommand.execute():",ex.getMessage());
		}
		return operation_result;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}

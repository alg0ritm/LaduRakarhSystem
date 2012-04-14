package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.service.ProductCatalogTree;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.ProductCatalogServiceFactory;
import ttu.rakarh1.web.control.StateHandler;

public class getProductCatalogTreeCommand implements Command
{

	public int execute(HttpServletRequest request, HttpServletResponse response,
			StateHandler stateHandler) throws ServletException, IOException
	{

		int operation_result = -1;
		int selected_product_catalog_id = 0;
		String request_selected_product_catalog_id = "";
		List<ttu.rakarh1.backend.model.data.ProductCatalog> CatalogList = null;

		ProductCatalogTree ProductCatalogTree = null;
		ProductCatalogServiceFactory ProductCatalogServiceFactory = new ProductCatalogServiceFactory();
		ProductCatalogTree = ProductCatalogServiceFactory.getTreeService();
		try
		{
			if (request.getParameter("catalog") != null)
			{
				request_selected_product_catalog_id = request.getParameter("catalog");
				try
				{
					selected_product_catalog_id = Integer
							.parseInt(request_selected_product_catalog_id);
					if(selected_product_catalog_id>0) {
						ProductCatalog selectedCatalog = ProductCatalogTree.getProductCatalogById(selected_product_catalog_id);
						stateHandler.setSelectedCatalog(selectedCatalog);
					}

				} catch (Exception ex)
				{
					MyLogger.Log(
							"getProductCatalogTreeCommand.execute() - not numeric catalog id:",
							ex.getMessage());
				}
			}




			CatalogList = ProductCatalogTree.getTreeWithOneOpenPath(selected_product_catalog_id);

			request.setAttribute("CatalogTree", CatalogList);
			operation_result = 1;
		} catch (Exception ex)
		{
			operation_result = -1;
			MyLogger.Log("getProductCatalogTreeCommand.execute():", ex.getMessage());
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

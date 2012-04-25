package ttu.rakarh1.web.control.command;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.ProductServiceFactory;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.ProductSearchRequestProcessor;
import ttu.rakarh1.web.forms.SearchForm;

public class searchProductCommand implements Command, Constant {


	@Override
	public int execute(final HttpServletRequest request, final HttpServletResponse response, final StateHandler stateHandler)
	throws ServletException, IOException {
		int operation_result = 0;

		try {
			ProductService ProductService = null;
			ProductServiceFactory ProductServiceFactory = new ProductServiceFactory();
			ProductSearchRequestProcessor ProductSearchRequestProcessor  = null ;
			SearchForm SearchForm = null ;
			ProductSearchRequestProcessor= new ProductSearchRequestProcessor ();
			HttpSession session = request.getSession();
			SearchForm testSearchForm = (ttu.rakarh1.web.forms.SearchForm) session.getAttribute("SearchForm");
			if(testSearchForm!=null) {
				testSearchForm.performBasicValidation(request);

			}
			SearchForm = ProductSearchRequestProcessor.getFormDataFromRequest(request);
			ProductSearchCriteria ProductSearchCriteria = null;
			ProductSearchCriteria = SearchForm.ConvertToModelData();
			MyLogger.LogMessage("GET MODEL DATA OK ->" + SearchForm.getModelDataOK());
			if (SearchForm.getModelDataOK() == 1)
			{
				ProductService = ProductServiceFactory.getService();
				SearchForm.setShowAddProduct(ProductService.showAddProduct(ProductSearchCriteria.getItem_type_fk()));
			    List<ttu.rakarh1.backend.model.data.Product> products = null;
			    products = ProductService.searchProducts(ProductSearchCriteria, request);
				request.setAttribute ("products", products);
				/*MyLogger.LogMessage(Constant.SHOW_ADD_PRODUCT + " " +ProductSearchCriteria.getItem_type_fk() + " " + SearchForm.isShowAddProduct());
				request.setAttribute(Constant.SHOW_ADD_PRODUCT, SearchForm.isShowAddProduct()+"");*/
			}
			session.setAttribute("SearchForm", SearchForm);
			request.setAttribute ("SearchForm", SearchForm);
			operation_result = -1;
		} catch (Exception ex) {
			operation_result = 0;
			MyLogger.Log("searchProductCommand.execute():",ex.getMessage());
		}
		return operation_result;
	}

	@Override
	public void supplyFormWithErrors(final HttpServletRequest req, final HttpServletResponse res,
			final StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}

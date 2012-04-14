package ttu.rakarh1.web.forms;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.log.MyLogger;



public class ProductRequestProcessor {


	public ProductForm getFormDataFromRequest(HttpServletRequest req)
	{
		ProductForm ProductForm  = new ProductForm ();
		String product ="";
		if (req.getParameter("product_id") != null)
		{
			product = req.getParameter("product_id");
		}

		/*Enumeration en = req.getParameterNames();

        while (en.hasMoreElements()) {

            String paramName = (String) en.nextElement();
            MyLogger.LogMessage("paramName "+ paramName + " Value " + req.getParameter(paramName));

        }*/
		String product_code = req.getParameter("product_code");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String eshop_price = req.getParameter("store_price");
		String sale_price = req.getParameter("sale_price");
		String product_catalog = req.getParameter("catalog");
		ProductForm.setItem(Integer.parseInt(product));
		ProductForm.setProducerCode(product_code);
		ProductForm.setName(name);
		ProductForm.setDescription(description);
		try {

			ProductForm.setStorePrice(Float.parseFloat(eshop_price));
			ProductForm.setSalePrice(Float.parseFloat(sale_price));
			ProductForm.setUnitTypeFk(Integer.parseInt(product_catalog));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("getFormDataFromRequest() not available product primary attributes");
		}
		return ProductForm;
	}


	public ArrayList<Integer> getRemovableItemsDataFromRequest(HttpServletRequest req) {

		ArrayList<Integer> productIds = new ArrayList<Integer>();
		if (req.getParameter("product_id") != null)
		{
			String[] products = req.getParameterValues("product_id");
			for(int i = 0; i<products.length; i++ ) {
				productIds.add(Integer.parseInt(products[i]));
			}

		}

		Enumeration en = req.getParameterNames();

        while (en.hasMoreElements()) {

            String paramName = (String) en.nextElement();
            MyLogger.LogMessage("paramName "+ paramName + " Value " + req.getParameter(paramName));

        }

        return productIds;
		/*String product_code = req.getParameter("product_code");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String eshop_price = req.getParameter("eshop_price");
		String max_customer_discount = req.getParameter("max_customer_discount");
		String product_catalog = req.getParameter("catalog");
		ProductForm.setItem(Integer.parseInt(product));
		ProductForm.setProducerCode(product_code);
		ProductForm.setName(name);
		ProductForm.setDescription(description);
		ProductForm.setStorePrice(Float.parseFloat(eshop_price));
		ProductForm.setSalePrice(Float.parseFloat(max_customer_discount));
		ProductForm.setUnitTypeFk(Integer.parseInt(product_catalog));
		return ProductForm;

		return null;*/

	}



}

package ttu.rakarh1.web.forms;
import java.util.*;
import java.text.*;
import ttu.rakarh1.log.MyLogger ;
import ttu.rakarh1.backend.model.data.*;
import javax.servlet.http.*;

public class ProductSearchRequestProcessor {


	public SearchForm getFormDataFromRequest(HttpServletRequest req)
	{
		SearchForm SearchForm  = new SearchForm ();
		String name="";
		String product_code="";
		String min_price="";
		String max_price ="";
		String unit_type_fk="";
		String supplier_enterprise_fk="";
		String item_type_fk="";
		String catalog ="";
		ArrayList<String> generalAttributes = null;
		if(req.getParameter("catalog") !=null)
		{
			catalog = req.getParameter("catalog");
		}
		if (req.getParameter("product_code") != null)
		{product_code = req.getParameter("product_code");}
		if (req.getParameter("name") != null)
		{name = req.getParameter("name"); }
		if (req.getParameter("min_price") != null)
		{min_price = req.getParameter("min_price");}
		if (req.getParameter("max_price") != null)
		{max_price = req.getParameter("max_price");}
		if (req.getParameter("unit_type_fk") != null)
		{unit_type_fk = req.getParameter("unit_type_fk");}
		if (req.getParameter("supplier_enterprise_fk") != null)
		{supplier_enterprise_fk = req.getParameter("supplier_enterprise_fk");}
		if(req.getParameter("attributes")!=null)
		{
			SearchForm.setGeneralAttributes(req.getParameter("attributes"));
		}
		SearchForm.setProduct_code(product_code);
		SearchForm.setName(name);
		SearchForm.setMin_price(min_price);
		SearchForm.setMax_price(max_price);
		SearchForm.setSupplier_enterprise_fk(supplier_enterprise_fk);
		SearchForm.setUnit_type_fk(unit_type_fk);
		SearchForm.setItem_type_fk(catalog);
		
		return SearchForm;
	}
	


}

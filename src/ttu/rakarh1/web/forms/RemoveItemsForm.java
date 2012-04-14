package ttu.rakarh1.web.forms;

import java.util.ArrayList;
import java.util.Iterator;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;

public class RemoveItemsForm
{
	private ArrayList<Product> productsList;
	public ProductCatalog getCatalog()
	{
		return catalog;
	}

	public void setCatalog(ProductCatalog catalog)
	{
		this.catalog = catalog;
	}

	public String getHtml()
	{
		return html;
	}

	public void setHtml(String html)
	{
		this.html = html;
	}

	private ProductCatalog catalog;
	private String html;

	public ArrayList<Product> getProductsList()
	{
		return productsList;
	}

	public void setProductsList(ArrayList<Product> productsList)
	{
		this.productsList = productsList;
	}

	public void generateHtml()
	{
		String userAction = "remove_items";
		String retString = "";
		retString+="<div class=\"formd\">"
		+"<form name=\"takeForm\" id=\"takeForm\" onSubmit=\"return checkAnswerForItemRemoval();\" action=c?user_action="+ userAction + " method=post>"+
			"<table>"+
				"<tr><td></td><td><input type=hidden name=catalog value="+ catalog.getProduct_catalog() + "></input></td><td></td><td></td></tr>"+
				"<tr><td>Nimetus</td><td>Kustutada?</td><td></td><td></td></tr>";
		Iterator it = productsList.iterator();
		while(it.hasNext()) {
			Product next = (Product) it.next();
			retString += "<tr><td>"+ next.getName()+"</td><td><input type=\"checkbox\" name=\"product_id\" value=\""+next.getProduct()+"\"/></td><td></td></tr>";
		}
		retString+="<tr><td></td><td><input type=\"submit\" value=\"Kustuta valitud\"/></td><td></td></tr>";
		retString+="</table></form></div>";
		this.html = retString;







	}


}

package ttu.rakarh1.backend.model.data;

import java.util.HashMap;

import ttu.rakarh1.log.MyLogger;

public class HorisontalMenu
{
	/*
	 * ADD, MOVE, SEARCH, LOG_OUT, TAKE_ON_THE_ACCOUNT, REMOVE_FROM_THE_ACCOUNT,
	 */

	private boolean isAdd;
	private boolean isMove;
	private boolean isSearch;
	private boolean isLogOut;
	private boolean isTakeOnTheAccount;
	private boolean isRemoveItems;
	public boolean isRemoveItems()
	{
		return isRemoveItems;
	}

	private boolean isRemoveFromTheAccount;
	private Product selectedProduct;
	private ProductCatalog selectedCatalog;
	private String menuResult;

	public String getMenuResult()
	{
		return menuResult;
	}

	HashMap<String, String> map = new HashMap<String, String>();

	public boolean isAdd()
	{
		return isAdd;
	}

	public void setAdd(boolean isAdd)
	{
		this.isAdd = isAdd;
	}

	public Product getSelectedProduct()
	{
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct)
	{
		this.selectedProduct = selectedProduct;
	}

	public boolean isMove()
	{
		return isMove;
	}

	public void setMove(boolean isMove)
	{
		this.isMove = isMove;
	}

	public boolean isSearch()
	{
		return isSearch;
	}

	public void setSearch(boolean isSearch)
	{
		this.isSearch = isSearch;
	}

	public boolean isLogOut()
	{
		return isLogOut;
	}

	public void setLogOut(boolean isLogOut)
	{
		this.isLogOut = isLogOut;
	}

	public boolean isTakeOnTheAccount()
	{
		return isTakeOnTheAccount;
	}

	public void setTakeOnTheAccount(boolean isTakeOnTheAccount)
	{
		this.isTakeOnTheAccount = isTakeOnTheAccount;
	}

	public boolean isRemoveFromTheAccount()
	{
		return isRemoveFromTheAccount;
	}

	public void setRemoveFromTheAccount(boolean isRemoveFromTheAccount)
	{
		this.isRemoveFromTheAccount = isRemoveFromTheAccount;
	}

	public void setMap(HashMap<String, String> map2)
	{
		this.map = map2;

	}

	public HashMap<String, String> getMap()
	{
		return map;
	}

	public void setMenuResult(String menuResult)
	{
		this.menuResult = menuResult;
	}

	public void setMenuResult()
	{

		String result = "";

		MyLogger.LogMessage("seleted catalog is null? " + selectedCatalog == null ? "yes" : "no");
		String userString= " <> Hello Anton Vesselov || " + "<a href=\"javascript:show_confirm()\">Log out</a>";

		if (selectedCatalog != null)
		{
			if (isSearch)
			{
				result += "<a href=?searchform=yes&catalog="
						+ selectedCatalog.getProduct_catalog() + ">Otsi</a>";
			}
			if(selectedCatalog.getSubCatalogs().size() == 0)
			{
				isAdd = true;
				isRemoveItems = true;
			}
		}



		if (isAdd)
		{
			result += " || <a href=?user_action=new_product_form&catalog="
				+ selectedCatalog.getProduct_catalog() + ">Lisa toode</a>";
		}

		if(isRemoveItems) {
			result += " || <a href=?user_action=remove_items_form&catalog="
				+ selectedCatalog.getProduct_catalog() + ">Kustuta tooteid</a>";
		}

		result +=  userString;

		if (isMove)
		{
			result += "<br><a href=?user_action=move_product_form&catalog="
					+ selectedCatalog.getProduct_catalog() + "&product_id="
					+ selectedProduct.getProduct() + ">Liiguta toode</a>";
		}



		if (isTakeOnTheAccount)
		{
			result += " || <a href=?user_action=take_product_form&catalog="
					+ selectedCatalog.getProduct_catalog() + "&product_id="
					+ selectedProduct.getProduct() + ">Võtta arvele</a>";
		}
		if (isRemoveFromTheAccount)
		{
			result += " || <a href=?user_action=remove_product_form&catalog="
					+ selectedCatalog.getProduct_catalog() + "&product_id="
					+ selectedProduct.getProduct() + ">Võtta arvelt</a>";
		}



		this.menuResult = result;
	}

	public ProductCatalog getSelectedCatalog()
	{
		return selectedCatalog;
	}

	public void setSelectedCatalog(ProductCatalog selectedCatalog)
	{
		this.selectedCatalog = selectedCatalog;
	}

	public void setRemoveItems(boolean b)
	{
		this.isRemoveItems = b;

	}

}

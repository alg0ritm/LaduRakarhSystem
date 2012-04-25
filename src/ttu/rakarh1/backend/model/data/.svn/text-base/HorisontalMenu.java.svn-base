package ttu.rakarh1.backend.model.data;

import java.util.HashMap;

import ttu.rakarh1.log.MyLogger;

public class HorisontalMenu
{
	/*
	 * ADD, MOVE, SEARCH, LOG_OUT, TAKE_ON_THE_ACCOUNT, REMOVE_FROM_THE_ACCOUNT,
	 */

	private boolean isAdd;
	private boolean isBasicSearch;
	private boolean isLogOut;
	private boolean isMove;

	private boolean isRemoveFromTheAccount;

	private boolean isRemoveItems;
	private boolean isSearch;
	private boolean isTakeOnTheAccount;
	HashMap<String, String> map = new HashMap<String, String>();
	private String menuResult;

	private ProductCatalog selectedCatalog;
	private Product selectedProduct;
	public HashMap<String, String> getMap()
	{
		return map;
	}
	public String getMenuResult()
	{
		return menuResult;
	}

	public ProductCatalog getSelectedCatalog()
	{
		return selectedCatalog;
	}

	public Product getSelectedProduct()
	{
		return selectedProduct;
	}

	public boolean isAdd()
	{
		return isAdd;
	}

	public boolean isBasicSearch()
	{
		return isBasicSearch;
	}

	public boolean isLogOut()
	{
		return isLogOut;
	}

	public boolean isMove()
	{
		return isMove;
	}

	public boolean isRemoveFromTheAccount()
	{
		return isRemoveFromTheAccount;
	}

	public boolean isRemoveItems()
	{
		return isRemoveItems;
	}

	public boolean isSearch()
	{
		return isSearch;
	}

	public boolean isTakeOnTheAccount()
	{
		return isTakeOnTheAccount;
	}

	public void setAdd(final boolean isAdd)
	{
		this.isAdd = isAdd;
	}

	public void setBasicSearch(final boolean isBasicSearch)
	{
		this.isBasicSearch = isBasicSearch;
	}

	public void setLogOut(final boolean isLogOut)
	{
		this.isLogOut = isLogOut;
	}

	public void setMap(final HashMap<String, String> map2)
	{
		this.map = map2;

	}

	public void setMenuResult()
	{

		String result = "";

		MyLogger.LogMessage("seleted catalog is null? " + selectedCatalog == null ? "yes" : "no");
		String userString= " <> Hello Anton Vesselov || " + "<a href=\"javascript:show_confirm()\">Log out</a>";

		if (isBasicSearch)
		{
			result += "<a href=?searchform=yes>Otsi</a>";
		}


		if (selectedCatalog != null )
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

	public void setMenuResult(final String menuResult)
	{
		this.menuResult = menuResult;
	}

	public void setMove(final boolean isMove)
	{
		this.isMove = isMove;
	}

	public void setRemoveFromTheAccount(final boolean isRemoveFromTheAccount)
	{
		this.isRemoveFromTheAccount = isRemoveFromTheAccount;
	}

	public void setRemoveItems(final boolean b)
	{
		this.isRemoveItems = b;

	}

	public void setSearch(final boolean isSearch)
	{
		this.isSearch = isSearch;
	}

	public void setSelectedCatalog(final ProductCatalog selectedCatalog)
	{
		this.selectedCatalog = selectedCatalog;
	}

	public void setSelectedProduct(final Product selectedProduct)
	{
		this.selectedProduct = selectedProduct;
	}

	public void setTakeOnTheAccount(final boolean isTakeOnTheAccount)
	{
		this.isTakeOnTheAccount = isTakeOnTheAccount;
	}

}

package ttu.rakarh1.web.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.enums.ProductTransactionTypes;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.User;
import ttu.rakarh1.log.MyLogger;

public class OperationOnProductForm
{
	public int reqOccurence = 3;
	Product product;
	User user;
	public HashMap getFormatErrors()
	{
		return formatErrors;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public void setFormatErrors(HashMap formatErrors)
	{
		this.formatErrors = formatErrors;
	}

	Float storePrice;
	int ModelDataOK = 0;

	public int getModelDataOK()
	{
		return ModelDataOK;
	}

	public void setModelDataOK(int modelDataOK)
	{
		ModelDataOK = modelDataOK;
	}

	public int getReqOccurence()
	{
		return reqOccurence;
	}

	public void setReqOccurence(int reqOccurence)
	{
		this.reqOccurence = reqOccurence;
	}

	int count;
	private String comment="";
	private ArrayList<ItemStore> itemStoreList;
	private String chosenStore="";
	private String chosenAmount="";
	private String chosenCost="";
	private int product_id;
	private ProductTransactionTypes transactionType;
	private String htmlForm;
	protected HashMap formatErrors = new HashMap();
	private String chosenStoreTo;

	public void setChosenStoreTo(String chosenStoreTo)
	{
		this.chosenStoreTo = chosenStoreTo;
	}

	public String getHtmlForm()
	{
		return htmlForm;
	}

	public void setHtmlForm(String htmlForm)
	{
		this.htmlForm = htmlForm;
	}

	public String getChosenCost()
	{
		return chosenCost;
	}

	public void setChosenCost(String chosenCost)
	{
		this.chosenCost = chosenCost;
	}

	public int getProduct_id()
	{
		return product_id;
	}

	public void setProduct_id(int product_id)
	{
		this.product_id = product_id;
	}

	public String getChosenStore()
	{
		return chosenStore;
	}

	public void setChosenStore(String chosenStore)
	{
		this.chosenStore = chosenStore;
	}

	public String getChosenAmount()
	{
		return chosenAmount;
	}

	public void setChosenAmount(String chosenAmount)
	{
		this.chosenAmount = chosenAmount;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public Float getStorePrice()
	{
		return storePrice;
	}

	public void setStorePrice(Float storePrice)
	{
		this.storePrice = storePrice;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public ArrayList<ItemStore> getItemStoreList()
	{
		return itemStoreList;
	}

	public void setItemStoreList(ArrayList<ItemStore> itemStoreList)
	{
		this.itemStoreList = itemStoreList;
	}

	public void setTransactionType(ProductTransactionTypes type)
	{
		this.transactionType = type;

	}

	public ProductTransactionTypes getTransactionType()
	{
		return transactionType;
	}

	public String createDropDown(ArrayList<ItemStore> storesFrom)
	{
		Iterator it = storesFrom.iterator();
		ItemStore current = null;
		String result = "";

		while (it.hasNext())
		{
			current = (ItemStore) it.next();
			String storeString = "<option>" + current.getStore() + "</option>";
			result += storeString;
		}
		return result;
	}

	public void performFieldsBasicValidation(HttpServletRequest request)
	{

	}

	public String getErrorByField(String Field)
	{
		String field_error = "";
		String bns_error;
		String format_error;
		String chk_field = Field;

		if (formatErrors != null)
		{
			format_error = (String) formatErrors.get(chk_field);
			if (format_error != null)
			{
				field_error = format_error;
			}

		}

		return field_error;
	}

	public String getChosenStoreTo()
	{
		return chosenStoreTo;
	}

	public void performBasicValidation(HttpServletRequest request)
	{
		int validationResult = 0;

	}

	private int performValidationRemove(HttpServletRequest request)
	{
		System.out.println("INSIDE TakeOnTheAccountRemove CHECK");
		System.out.println("INSIDE CHECK");
		System.out.println("INSIDE CHECK 2");
		try
		{

			if (request.getParameter("chosenStore") == null)
			{
				formatErrors.put("chosenStore", "puudub ChosenStore");
			}

			if (request.getParameter("chosenAmount") == null)
			{
				formatErrors.put("chosenAmount", "puudub ChosenAmount");
			}

			if (request.getParameter("chosenCost") == null)
			{
				formatErrors.put("chosenCost", "puudub chosenCost");
			}

			if (formatErrors.size() == 0)
			{
				return 1;
			}
		} catch (Exception ex)
		{
			MyLogger.Log("OperationOnProductForm.ConvertToModelData():", ex.getMessage());
		}
		return 0;
	}

	private int performValidationAdd(HttpServletRequest request)
	{
		System.out.println("INSIDE TakeOnTheAccountADD CHECK");
		System.out.println("INSIDE CHECK");
		System.out.println("INSIDE CHECK 2");
		int chosenAmount = 0;
		try
		{

			if (request.getParameter("chosenStore") == null)
			{
				formatErrors.put("chosenStore", "puudub ChosenStore");
			}

			if (request.getParameter("chosenAmount") != null)
			{
				try
				{
					chosenAmount = Integer.parseInt((String)request.getParameter("chosenAmount"));
					if (chosenAmount <= 0)
					{
						formatErrors.put("chosenAmount", "puudub ChosenAmount");
					}
				} catch (Exception e)
				{
					formatErrors.put("chosenAmount", "puudub ChosenAmount");
					System.out.println("Error with validation");
				}

			}

			if (request.getParameter("chosenCost") == null)
			{
				formatErrors.put("chosenCost", "puudub chosenCost");
			}

			if (formatErrors.size() == 0)
			{
				return 1;
			}
		} catch (Exception ex)
		{
			MyLogger.Log("OperationOnProductForm.ConvertToModelData():", ex.getMessage());
		}
		return 0;

	}

	private int performValidationMove(HttpServletRequest request)
	{
		System.out.println("INSIDE TakeOnTheAccountForm CHECK");
		System.out.println("INSIDE CHECK");
		System.out.println("INSIDE CHECK 2");
		try
		{

			if (request.getParameter("chosenStore") == null)
			{
				formatErrors.put("chosenStore", "puudub ChosenStore");
			}

			if (request.getParameter("chosenStoreTo") == null)
			{
				formatErrors.put("chosenStoreTo", "puudub ChosenStoreTo");
			}

			if (request.getParameter("chosenAmount") == null)
			{
				formatErrors.put("chosenAmount", "puudub ChosenAmount");
			}

			if (formatErrors.size() == 0)
			{
				return 1;
			}
		} catch (Exception ex)
		{
			MyLogger.Log("OperationOnProductForm.ConvertToModelData():", ex.getMessage());
		}
		return 0;

	}

	public void supplyWithRequestData(HttpServletRequest request)
	{
		// TODO Auto-generated method stub

	}

}

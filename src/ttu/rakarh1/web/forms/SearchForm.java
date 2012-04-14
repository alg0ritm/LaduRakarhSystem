package ttu.rakarh1.web.forms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.model.data.BasicForm;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;
import ttu.rakarh1.log.MyLogger;

public class SearchForm extends BasicForm {
	private String product_code="" ;
	private String name="" ;
	private String description="" ;
	private String min_price = "" ;
	private String max_price = "" ;

	private int ModelDataOK = 0;
	public HashMap format_errors= new HashMap<String,String>();
	public HashMap business_errors;
	private String item ;
	private String unit_type_fk;
	private String supplier_enterprise_fk;
	private String item_type_fk;
	private String store_price;
	private String sale_price;
	private String producer;
	private String producer_code;
	private String created;
	private String maxSale_price;
	private String minSale_price;
	private String catalog;
	private String catName;
	private ArrayList<String> generalAttributes;
	private String generalAttributesStr;
	private boolean showAddProduct;

	public boolean isShowAddProduct()
	{
		return showAddProduct;
	}

	public void setShowAddProduct(boolean showAddProduct)
	{
		this.showAddProduct = showAddProduct;
	}

	public String getGeneralAttributes()
	{
		if(generalAttributes!=null)
			return listToString(generalAttributes);
		else return " ";
	}

	public void setGeneralAttributes(String str)
	{
		this.generalAttributesStr = str;
		this.generalAttributes = stringToList(str);

	}

	private ArrayList<String> stringToList(String str)
	{
		ArrayList<String> generalAttrLocal = new ArrayList<String>();
		int start = 0;
		int finalInd = str.length();

		int count = 0;

		for(int st=0; st<finalInd; st++)
		{

			char end = str.charAt(st);

			if(Character.isSpaceChar(end))
			{
				count++;
				String local = str.substring(start, st);
				generalAttrLocal.add(local);
				start = st;
			}
			if(st==finalInd-1)
			{
				String local = str.substring(start, finalInd);
				generalAttrLocal.add(str.substring(start, finalInd));
			}
		}
		return generalAttrLocal;
	}

	private String listToString(ArrayList<String> list)
	{
		Iterator listIter = list.iterator();
		String retString ="";
		while(listIter.hasNext())
		{
			retString+=listIter.next();
		}
		return retString.trim();
	}
	public void setProduct_code (String product_code)
	{
		this.product_code = product_code;
	}

	public void setName (String name)
	{
		this.name = name;
	}

		public void setDescription (String description)
	{
		this.description = description;
	}

	public void setMin_price(String min_price)
	{
		this.min_price = min_price;
	}

		public void setMax_price(String max_price)
	{
		this.max_price = max_price;
	}


	public int getModelDataOK()
	{
		return this.ModelDataOK;
	}


	public String getProduct_code()
	{
		return this.product_code;
	}

	public String getName()
	{
		return this.name ;
	}

	public String getDescription ()
	{
		return this.description ;
	}

	public String getMin_price ()
	{
		return this.min_price ;
	}


	public String getMax_price ()
	{
		return this.max_price ;
	}




	public ProductSearchCriteria ConvertToModelData()
	{
		ttu.rakarh1.backend.model.data.ProductSearchCriteria ProductSearchCriteria = new ProductSearchCriteria();
		format_errors = new HashMap() ;

		try
		{

			if (!(getMax_price().equals("")))
			{
			try
			{
				ProductSearchCriteria.setMax_price(Integer.parseInt(getMax_price()));
			}
			catch(Exception ex)
			{
				format_errors.put("max_price","formaat vale");
			}
			}
			if (!(getMin_price().equals("")))
			{
			try
			{
				ProductSearchCriteria.setMin_price(Integer.parseInt(getMin_price()));
			}
			catch(Exception ex)
			{
				format_errors.put("min_price","formaat vale");
			}
            }
			if(!(getSupplier_enterprise_fk().equals("")))
			{
				try
				{
					ProductSearchCriteria.setSupplier_enterprise_fk(Integer.parseInt(getSupplier_enterprise_fk()));
				}
				catch(Exception E)
				{
					format_errors.put("supplier_enterprise_fk","formaat vale");
				}
			}
			if(!(getItem_type_fk().equals("")))
			{
				try
				{
					ProductSearchCriteria.setItem_type_fk(Integer.parseInt(getItem_type_fk()));
				}
				catch(Exception E)
				{
					format_errors.put("item_type_fk","formaat vale");
				}
			}
			if(!(getUnit_type_fk().equals("")))
			{
				try
				{
					ProductSearchCriteria.setUnit_type_fk(Integer.parseInt(getUnit_type_fk()));
				}
				catch(Exception E)
				{
					format_errors.put("unit_type_fk","formaat vale");
				}
			}

			if(!(getGeneralAttributes().isEmpty()))
			{
				try
				{
					ProductSearchCriteria.setGenAttrList(generalAttributes);
				}
				catch(Exception e)
				{
					format_errors.put("generalAttributes","something wrong");
				}
			}
        	ProductSearchCriteria.setName(getName());
			ProductSearchCriteria.setProduct_code(getProduct_code());

			if (format_errors.size() == 0)
			{
				ModelDataOK = 1;
			}
		}
		catch(Exception ex)
		{
			MyLogger.Log("SearchForm.ConvertToModelData():",ex.getMessage());
		}
		return ProductSearchCriteria ;
	}

	public String getErrorByField (String Field)
	{
		String field_error ="";
		String bns_error;
		String format_error;
		String chk_field = Field ;

		if (format_errors != null)
		{
			format_error = (String) format_errors.get(chk_field);
			if (format_error != null)
			{
				field_error = format_error ;
			}

		}

		return field_error;
	}




	public void setBusinessErrors (HashMap BusinessErrors)
	{
		this.business_errors = BusinessErrors;
	}

	public void setItem (String item)
	{
		this.item = item;
	}

	public void setUnit_type_fk(String unit_type_fk) {
		// TODO Auto-generated method stub
		this.unit_type_fk = unit_type_fk;
	}

	public void setSupplier_enterprise_fk(String supplier_enterprise_fk) {
		// TODO Auto-generated method stub
		this.supplier_enterprise_fk = supplier_enterprise_fk;
	}


	public void setItem_type_fk(String item_type_fk) {
		// TODO Auto-generated method stub
		this.item_type_fk = item_type_fk;
	}


	public void setStore_price(String store_price) {
		// TODO Auto-generated method stub
		this.store_price = store_price;
	}


	public void setSale_price(String sale_price) {
		// TODO Auto-generated method stub
		this.sale_price = sale_price;
	}


	public void setProducer(String producer) {
		// TODO Auto-generated method stub
		this.producer = producer;
	}


	public void setProducer_code(String producer_code) {
		// TODO Auto-generated method stub
		this.producer_code = producer_code;
	}


	public void setCreated(String created) {
		// TODO Auto-generated method stub
		this.created = created;
	}


	public String getItem() {
		return item;
	}



	public String getUnit_type_fk() {
		return unit_type_fk;
	}

	public String getSupplier_enterprise_fk() {
		return supplier_enterprise_fk;
	}


	public String getItem_type_fk() {
		return item_type_fk;
	}


	public String getStore_price() {
		return store_price;
	}


	public String getSale_price() {
		return sale_price;
	}


	public String getProducer() {
		return producer;
	}


	public String getProducer_code() {
		return producer_code;
	}


	public HashMap getFormat_errors()
	{
		return format_errors;
	}

	public void setFormat_errors(HashMap format_errors)
	{
		this.format_errors = format_errors;
	}

	public String getCreated() {
		return created;
	}

	public String getMaxSale_price() {
		return maxSale_price;
	}

	public String getMinSale_price() {
		return minSale_price;
	}

	public void setMaxSale_price(String price)
	{
		this.maxSale_price = price;
	}

	public void setMinSale_price(String price)
	{
		this.minSale_price = price;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String setCatName()
	{
		return catName;
	}

	public String getCatName()
	{
		return catName;
	}

	@Override
	public void performBasicValidation(HttpServletRequest request)
	{
		if(request.getParameter("product_code")==null)
		{
			format_errors.put("product_code", "product code ei saa olla tyhi");
		}
		if (format_errors.size() == 0)
		{
			setModelDataOK(1);

		}
	}

	public void setModelDataOK(int modelDataOK)
	{
		ModelDataOK = modelDataOK;
	}






}

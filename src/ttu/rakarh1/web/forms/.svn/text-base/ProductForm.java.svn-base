package ttu.rakarh1.web.forms;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.log.MyLogger;

public class ProductForm implements java.io.Serializable
{

	private int item;
	private int unitTypeFk;
	private int supplierEnterpriseFk;
	private int itemTypeFk;
	private String name;
	private float storePrice;
	private float salePrice;
	private String producer;
	private String description;
	private String producerCode;
	private String singleItem;
	private int upperItemFk;
	private String serialNo;
	private Date created;
	private HashMap format_errors;
	private int ModelDataOK;
	private Object business_errors;
	private boolean showAddproduct;


	public int getItem()
	{
		return this.item;
	}

	public void setItem(int item)
	{
		this.item = item;
	}

	public int getUnitTypeFk()
	{
		return this.unitTypeFk;
	}

	public void setUnitTypeFk(int unitTypeFk)
	{
		this.unitTypeFk = unitTypeFk;
	}

	public int getSupplierEnterpriseFk()
	{
		return this.supplierEnterpriseFk;
	}

	public void setSupplierEnterpriseFk(int supplierEnterpriseFk)
	{
		this.supplierEnterpriseFk = supplierEnterpriseFk;
	}

	public int getItemTypeFk()
	{
		return this.itemTypeFk;
	}

	public void setItemTypeFk(int itemTypeFk)
	{
		this.itemTypeFk = itemTypeFk;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getStorePrice()
	{
		return this.storePrice;
	}

	public void setStorePrice(float storePrice)
	{
		this.storePrice = storePrice;
	}

	public float getSalePrice()
	{
		return this.salePrice;
	}

	public void setSalePrice(float salePrice)
	{
		this.salePrice = salePrice;
	}

	public String getProducer()
	{
		return this.producer;
	}

	public void setProducer(String producer)
	{
		this.producer = producer;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getProducerCode()
	{
		return this.producerCode;
	}

	public void setProducerCode(String producerCode)
	{
		this.producerCode = producerCode;
	}

	public String getSingleItem()
	{
		return this.singleItem;
	}

	public void setSingleItem(String singleItem)
	{
		this.singleItem = singleItem;
	}

	public int getUpperItemFk()
	{
		return this.upperItemFk;
	}

	public void setUpperItemFk(int upperItemFk)
	{
		this.upperItemFk = upperItemFk;
	}

	public String getSerialNo()
	{
		return this.serialNo;
	}

	public void setSerialNo(String serialNo)
	{
		this.serialNo = serialNo;
	}

	public Date getCreated()
	{
		return this.created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public Product ConvertToModelData()
	{
		ttu.rakarh1.backend.model.data.Product Product = new Product();
		format_errors = new HashMap();

		try
		{

			if (getItem()>0)
			{
				Product.setProduct(getItem());
			}

			try
			{
				if(getProducerCode()==null || getProducerCode().length()==0)
					format_errors.put("product_code", "puudub product_code");
				Product.setProduct_code(getProducerCode());

			}catch(Exception ex)
			{
				MyLogger.Log("ConvertToModelData():", "getProducerCode()");
				format_errors.put("product_code", "puudub producer code");
			}

			try
			{
				if(getUnitTypeFk()<=0)
					format_errors.put("unit_type", "puudub unit_type");

				Product.setProduct_catalog(getUnitTypeFk());

			} catch (Exception ex)
			{
				MyLogger.Log("ConvertToModelData():", "getUnitTypeFk()");
				format_errors.put("unit_type", "puudub unit_type");
			}

			try
			{
				if(getStorePrice()<=0) {
					format_errors.put("eshop_price", "puudub store_price");

				}
				Product.setStore_price(getStorePrice());
			} catch (Exception ex)
			{
				format_errors.put("eshop_price", "hind puudub voi formaat vale");
				MyLogger.Log("ConvertToModelData():", "getStorePrice()");
			}
			try
			{
				if(getSalePrice()<=0) {
					format_errors.put("sale_price", "puudub sale_price");
				}
				Product.setSale_price(getSalePrice());
			} catch (Exception ex)
			{
				format_errors.put("sale_price", "vale formaat v6i number");
				MyLogger.Log("ESHOP_PRICE.ConvertToModelData():", "getSalePrice()");
			}

			if (getName() == "")
			{
				format_errors.put("name", "nimi puudub");
			} else
			{
				Product.setName(getName());
			}


			Product.setDescription(getDescription());

			Iterator it = format_errors.keySet().iterator();
			while (it.hasNext())
			{
				Object key = it.next();
				String error_msg = (String) format_errors.get(key);
				MyLogger.Log("VIGA TOOTE ANDMETES :#" + error_msg + "#", "");
			}

			if (format_errors.size() == 0)
			{
				ModelDataOK = 1;
			}
		} catch (Exception ex)
		{
			MyLogger.Log("ProductForm.ConvertToModelData():", ex.getMessage());
		}
		return Product;
	}

	public String getErrorByField(String Field)
	{
		String field_error = "";
		String bns_error;
		String format_error;
		String chk_field = Field;


		if (format_errors != null)
		{
			format_error = (String) format_errors.get(chk_field);
			if (format_error != null)
			{
				field_error = format_error;
			}

		}

		if (business_errors != null)
		{
			bns_error = (String) ((HashMap) business_errors).get(chk_field);
			if (bns_error != null)
			{
				field_error = field_error + bns_error;
			}

		}
		return field_error;
	}

	public void getDataFromModel(Product Product)
	{
		setItem(Product.getProduct());
		setProducerCode(Product.getProduct_code());
		setName(Product.getName());
		setDescription(Product.getDescription());
		setStorePrice(Product.getStore_price());
		setSalePrice(Product.getSale_price());
		setUnitTypeFk(Product.getProduct_catalog());
	}

	public int getModelDataOK()
	{
		return ModelDataOK;
	}

	public void setModelDataOK(int data)
	{
		this.ModelDataOK = data;
	}

	public void setBusinessErrors(HashMap allErrors)
	{
		this.business_errors = allErrors;

	}

	public HashMap getBusinessErrors()
	{
		return (HashMap) this.business_errors;

	}

	public void setShowAddProduct(boolean showAddProduct)
	{
		this.showAddproduct = showAddproduct;
	}

	public boolean isShowAddProduct()
	{
		return this.showAddproduct;
	}


}

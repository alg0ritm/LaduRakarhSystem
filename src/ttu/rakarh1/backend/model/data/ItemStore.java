package ttu.rakarh1.backend.model.data;

public class ItemStore
{
	int store;
	String name;
	int count;
	private Product product;
	
	public int getStore()
	{
		return store;
	}
	public void setStore(int store)
	{
		this.store = store;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public void setProduct(Product product)
	{
		this.product = product;
		
	}
	public Product getProduct()
	{
		return product;
	}
	
	
	
}

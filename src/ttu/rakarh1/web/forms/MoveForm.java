package ttu.rakarh1.web.forms;

import ttu.rakarh1.backend.model.data.User;

public class MoveForm
{
	private int warehouseFrom;
	private int wareHouseTo;
	private User movedBy;
	public String item;
	public String catalog;
	public String getItem()
	{
		return item;
	}
	public void setItem(String item)
	{
		this.item = item;
	}
	public String getCatalog()
	{
		return catalog;
	}
	public void setCatalog(String catalog)
	{
		this.catalog = catalog;
	}
	public int getWarehouseFrom()
	{
		return warehouseFrom;
	}
	public void setWarehouseFrom(int warehouseFrom)
	{
		this.warehouseFrom = warehouseFrom;
	}
	public int getWareHouseTo()
	{
		return wareHouseTo;
	}
	public void setWareHouseTo(int wareHouseTo)
	{
		this.wareHouseTo = wareHouseTo;
	}
	public User getMovedBy()
	{
		return movedBy;
	}
	public void setMovedBy(User movedBy)
	{
		this.movedBy = movedBy;
	}
	

}

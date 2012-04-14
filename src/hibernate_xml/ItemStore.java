package hibernate_xml;

// default package
// Generated 31.07.2011 14:20:28 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * ItemStore generated by hbm2java
 */
public class ItemStore implements java.io.Serializable
{

	private long itemStore;
	private Long storeFk;
	private Long itemFk;
	private BigDecimal itemCount;

	public ItemStore()
	{
	}

	public ItemStore(long itemStore)
	{
		this.itemStore = itemStore;
	}

	public ItemStore(long itemStore, Long storeFk, Long itemFk, BigDecimal itemCount)
	{
		this.itemStore = itemStore;
		this.storeFk = storeFk;
		this.itemFk = itemFk;
		this.itemCount = itemCount;
	}

	public long getItemStore()
	{
		return this.itemStore;
	}

	public void setItemStore(long itemStore)
	{
		this.itemStore = itemStore;
	}

	public Long getStoreFk()
	{
		return this.storeFk;
	}

	public void setStoreFk(Long storeFk)
	{
		this.storeFk = storeFk;
	}

	public Long getItemFk()
	{
		return this.itemFk;
	}

	public void setItemFk(Long itemFk)
	{
		this.itemFk = itemFk;
	}

	public BigDecimal getItemCount()
	{
		return this.itemCount;
	}

	public void setItemCount(BigDecimal itemCount)
	{
		this.itemCount = itemCount;
	}

}

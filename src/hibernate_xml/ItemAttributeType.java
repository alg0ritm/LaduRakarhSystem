package hibernate_xml;

// default package
// Generated 31.07.2011 14:20:28 by Hibernate Tools 3.4.0.CR1

/**
 * ItemAttributeType generated by hbm2java
 */
public class ItemAttributeType implements java.io.Serializable
{

	private long itemAttributeType;
	private String typeName;
	private String multipleAttributes;
	private Long dataType;

	public ItemAttributeType()
	{
	}

	public ItemAttributeType(long itemAttributeType)
	{
		this.itemAttributeType = itemAttributeType;
	}

	public ItemAttributeType(long itemAttributeType, String typeName, String multipleAttributes,
			Long dataType)
	{
		this.itemAttributeType = itemAttributeType;
		this.typeName = typeName;
		this.multipleAttributes = multipleAttributes;
		this.dataType = dataType;
	}

	public long getItemAttributeType()
	{
		return this.itemAttributeType;
	}

	public void setItemAttributeType(long itemAttributeType)
	{
		this.itemAttributeType = itemAttributeType;
	}

	public String getTypeName()
	{
		return this.typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	public String getMultipleAttributes()
	{
		return this.multipleAttributes;
	}

	public void setMultipleAttributes(String multipleAttributes)
	{
		this.multipleAttributes = multipleAttributes;
	}

	public Long getDataType()
	{
		return this.dataType;
	}

	public void setDataType(Long dataType)
	{
		this.dataType = dataType;
	}

}

package ttu.rakarh1.backend.model.data;

import java.util.ArrayList;
import java.util.HashMap;

public class FormAttribute {
	private String name;
	private int isRequired;
	private String errorMsg;
	private int parentItem;
	private int dataType;
	private String value;
	private String tableName;
	private String valueText;
	private int valueNumber;
	private int columnType;
	private HashMap formAttrMap;
	
	public FormAttrField getValueText()
	{
		return (FormAttrField) formAttrMap.get("value_text");
	}

	public void setValueText(FormAttrField value)
	{
		formAttrMap.put("value_text", value);
	}

	public FormAttrField getValueNumber()
	{
		return (FormAttrField) formAttrMap.get("value_number");
	}

	public void setValueNumber(FormAttrField value)
	{
		formAttrMap.put("value_number", value);
	}

	public FormAttribute()
	{
		formAttrMap = new HashMap<String, FormAttrField>();
	}
	
	public void addMapEntry(String key, FormAttrField value)
	{
		formAttrMap.put(key, value);
	}
	
	public FormAttrField getMapEntry(String key)
	{
		return (FormAttrField) formAttrMap.get(key);
	}
	
	public FormAttrField getItemType() {
		return (FormAttrField) formAttrMap.get("item_type");
	}
	public void setItemType(FormAttrField value) {
		formAttrMap.put("item_type", value);
	}
	public int getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(String str) {
		if(str.equals("Y"))
			this.isRequired = 1;
		else
			this.isRequired = 0;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getParentCatalog() {
		return parentItem;
	}
	public void setParentCatalog(int parentCatalog) {
		this.parentItem = parentCatalog;
	}
	public FormAttrField getName() {
		return (FormAttrField) formAttrMap.get("type_name");
	}
	public void setName(FormAttrField currentAttrField) {
		formAttrMap.put("type_name", currentAttrField);
	}

	public void setDataType(FormAttrField currentAttrField) {
		formAttrMap.put("data_type", currentAttrField);
	}

	public FormAttrField getDataType() {
		return (FormAttrField) formAttrMap.get("data_type");
	}

	public void setItemAttrTypeFk(FormAttrField currentAttrField)
	{
		formAttrMap.put("item_attribute_type_fk", currentAttrField);
	}
	
	public FormAttrField getItemAttrTypeFk() {
		return (FormAttrField) formAttrMap.get("item_attribute_type_fk");
	}

	

	
	

}

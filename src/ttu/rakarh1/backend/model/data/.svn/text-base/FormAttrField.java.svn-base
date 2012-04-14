package ttu.rakarh1.backend.model.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FormAttrField {
	private String table;
	private String columnName;
	private String columnValue;
	private int columnType;
	private String value;
	public String virtValue;
	private String valueText;
	private int valueNumber;
	private HashMap<String, String> errors;
	
	public String getValueText()
	{
		return valueText;
	}
	public void setValueText(String valueText)
	{
		this.valueText = valueText;
	}
	public int getValueNumber()
	{
		return valueNumber;
	}
	public void setValueNumber(int valueNumber)
	{
		this.valueNumber = valueNumber;
	}
	public String getVirtValue() {
		return virtValue;
	}
	public void setVirtValue(String virtValue) {
		this.virtValue = virtValue;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public int getColumnType() {
		return columnType;
	}
	public void setColumnType(int i) {
		this.columnType = i;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public void createErrorMap()
	{
		this.errors = new HashMap<String, String>();
	}
	public void setError(String key, String desc)
	{
		errors.put(key, desc);
	}
	
	public int errorsExist()
	{
		return this.errors.size();
	}
	
	public HashMap<String, String> getErrors()
	{
		return this.errors;
	}
	
	public String printFirstError() {
	    Iterator it = this.errors.entrySet().iterator();
        Map.Entry pairs = (Map.Entry)it.next();
        return (String) pairs.getValue();
	}

	
		

}



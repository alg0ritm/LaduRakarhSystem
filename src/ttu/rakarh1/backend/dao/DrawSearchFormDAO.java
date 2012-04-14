package ttu.rakarh1.backend.dao;

import java.util.List;

import ttu.rakarh1.backend.model.data.FormAttribute;

public interface DrawSearchFormDAO {
	public void setDbConnection(dbconnection dbconnection);
	public List<FormAttribute> getItemFormAttributes(int item);
	public List<FormAttribute> getItemFormAttributes(int item, int item2);
	public List<FormAttribute> setItemFormAttributes(int selected_item_type, String producerCode);
}

package ttu.rakarh1.web.view;

import java.util.ArrayList;
import java.util.Iterator;

import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.web.forms.MoveForm;

public class MoveProductFormUI
{
	public String generateMoveProductForm(MoveForm moveProductForm, ArrayList<ItemStore> storesFrom, ArrayList<ItemStore> avStores)
	{
		String retString = "";
		retString += "<div class=\"formd\"><form action=c?user_action=moveProduct method=post><table>";
		retString += "<tr><td colspan=2>id:" + moveProductForm.getItem()
			+ ".<input type=hidden name=catalog value=" + moveProductForm.getCatalog()
			+ "><input type=hidden name=product_id value='" + moveProductForm.getItem()
			+ "'></td><td></td></tr>";
		 retString+="<tr><td>Laost:</td><td><select name=name=warehouse_from>";
		 retString+=createDropDown(storesFrom);
		 retString+="</select></td></tr>";
		 retString+="<tr><td>Lattu:</td><td><select name=name=warehouse_to>";
		 retString+=createDropDown(avStores);
		 retString+="</select></td></tr>";
		 retString+="<tr><td>Kogus:</td><td><input type=text name=quantity value='"+"'></td><td>tk.</td></tr>";
		 retString+="<tr><td>Kommentaar:</td><td><textarea name=comment rows ='2' cols ='20'"+"></textarea></td><td></tr>";
		 retString+="</div>";
		return retString;
	}

	public String createDropDown(ArrayList<ItemStore> storesFrom){
		Iterator it = storesFrom.iterator();
		ItemStore current = null;
		String result="";

		while(it.hasNext()){
			current = (ItemStore) it.next();
			String storeString = "<option>" + current.getStore() + "</option>";
			result+=storeString;
		}


		return result;
	}

}

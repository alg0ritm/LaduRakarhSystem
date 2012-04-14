package ttu.rakarh1.web.view;

import java.util.ArrayList;
import java.util.Iterator;

import ttu.rakarh1.backend.enums.ProductTransactionTypes;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.web.forms.TakeOnTheAccountForm;

public class TakeOnTheAccountFormUI
{
	public String generateTakeOnTheAccountForm(TakeOnTheAccountForm takeOnTheAccountForm)
	{
		String userAction = (takeOnTheAccountForm.getTransactionType()==ProductTransactionTypes.TAKE)?"take_product":"remove_product";
		String retString = "";
		retString += "<div class=\"formd\"><form name=\"takeForm\" id=\"takeForm\" action=c?user_action="+userAction +" method=post><table>";
		retString += "<tr><td colspan=2>id:" + takeOnTheAccountForm.getProduct().getProduct()
			+ ".<input type=hidden name=catalog value=" + takeOnTheAccountForm.getProduct().getProduct_catalog()
			+ "><input type=hidden name=product_id value='" + takeOnTheAccountForm.getProduct().getProduct()
			+ "'></td><td></td></tr>";
		retString+="<tr><td>Nimetus:</td><td>" + takeOnTheAccountForm.getProduct().getName() + "</td><tr>";
		 retString+="<tr><td>Lattu:</td><td><select name=chosenStore>";
		 retString+=createDropDown(takeOnTheAccountForm.getItemStoreList());
		 retString+="</select></td></tr>";
		 retString+="<tr><td>Kogus:</td><td><input type=text name=chosenAmount value='"+"'></td><td>tk.</td></tr>";
		 retString+="<tr><td>Lao hind:</td><td><input type=text name=chosenCost value='"+"'></td><td>tk.</td></tr>";
		 retString+="<tr><td>Kommentaar:</td><td><textarea name=comment rows ='2' cols ='15'"+"></textarea></td><td></tr>";
		 retString+="<tr><td></td><td><input type=submit  value = 'Liiguta'></td></tr>";
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

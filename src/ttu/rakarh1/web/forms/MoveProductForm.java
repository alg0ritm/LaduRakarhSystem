package ttu.rakarh1.web.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.log.MyLogger;

public class MoveProductForm extends OperationOnProductForm
{
	public static int reqOccurence = 2;
	ArrayList<ItemStore> availableItemStoreList = new ArrayList<ItemStore>();
	private int chosenStoreToId;

	public int getChosenStoreToId()
	{
		return chosenStoreToId;
	}

	public void setChosenStoreToId(int chosenStoreToId)
	{
		this.chosenStoreToId = chosenStoreToId;
	}

	public void setAvailableItemStoreList(ArrayList<ItemStore> availableItemStoreList)
	{
		this.availableItemStoreList = availableItemStoreList;

	}

	public ArrayList<ItemStore> getAvailableItemStoreList()
	{
		return availableItemStoreList;
	}

	public String getHtmlForm()
	{

		String userAction = "move_product";
		String retString = "";
		retString += "<div class=\"formd\"><form name=\"takeForm\" id=\"takeForm\" action=c?user_action="
				+ userAction + " method=post><table>";
		retString += "<tr><td colspan=2>id:" + this.getProduct().getProduct()
				+ ".<input type=hidden name=catalog value="
				+ this.getProduct().getProduct_catalog()
				+ "><input type=hidden name=product_id value='" + this.getProduct().getProduct()
				+ "'></td><td></td></tr>";
		retString += "<tr><td>Nimetus:</td><td>" + this.getProduct().getName() + "</td><tr>";
		retString += "<tr><td>Laost:</td><td><select id=chosenStore name=chosenStore onchange=\"hideNotAvailableStores('chosenStore', 'chosenStoreTo')\">";
		retString += createDropDown(this.getItemStoreList());
		retString += "<tr><td>Lattu:</td><td><select id=chosenStoreTo name=chosenStoreTo>";
		retString += createDropDown(this.getAvailableItemStoreList());
		retString += "</select>" + this.getErrorByField("chosenStoreTo") + "</td></tr>";
		retString += "<tr><td>Kogus:</td><td><input type=text name=chosenAmount value='"+this.getChosenAmount()
				+ "'></td><td>tk." + this.getErrorByField("chosenAmount") + "</td></tr>";
		retString += "<tr><td>Kommentaar:</td><td><textarea name=comment rows ='2' cols ='15'"
				+ ">"+this.getComment()+"</textarea></td><td></tr>";
		retString += "<tr><td></td><td><input type=submit  value = 'LiigutaaaB'></td></tr>";
		retString += "</div>";
		return retString;

	}

	public void performBasicValidation(HttpServletRequest request)
	{
		int result = 0;
		try
		{

			formatErrors.clear();
			try {
				if(request.getParameter("chosenAmount")!=null && !request.getParameter("chosenAmount").equals("")) {
					setChosenAmount(request.getParameter("chosenAmount"));
					result = Integer.parseInt(getChosenAmount());
				}
				else {
					setChosenAmount("");
					formatErrors.put("chosenAmount", "no value for field chosenAmount");
				}
			}

			catch(Exception E) {
				formatErrors.put("chosenAmount", "wrong format for field chosenAmount");
			}

			try {
				if(Integer.parseInt(request.getParameter("chosenStoreTo"))>0) {
					setChosenAmount(request.getParameter("chosenStoreTo"));
					result = Integer.parseInt(request.getParameter("chosenStoreTo"));
				}
				else {
					setChosenAmount("");
					formatErrors.put("chosenAmount", "no value for field chosenStoreTo");
				}
			}catch(Exception e) {
				formatErrors.put("chosenAmount", "no value for field chosenStoreTo");
			}
			if(request.getParameter("comment")!=null && !request.getParameter("comment").equals(""))
				setComment(request.getParameter("comment"));
			else
				setComment("");
			setChosenStore(request.getParameter("chosenStore"));


			if (formatErrors.size() == 0)
			{
				setModelDataOK(1);
			}
		} catch (Exception ex)
		{
			MyLogger.Log("OperationOnProductForm.ConvertToModelData():", ex.getMessage());
		}


	}

	public void supplyWithRequestData(HttpServletRequest request)
	{
		// TODO Auto-generated method stub

	}

}

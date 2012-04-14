package ttu.rakarh1.web.forms;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.log.MyLogger;



public class TakeOnTheAccountForm extends OperationOnProductForm
{
	public int reqOccurence = 3;

	public int getReqOccurence()
	{
		return reqOccurence;
	}

	public void setReqOccurence(int reqOccurence)
	{
		this.reqOccurence = reqOccurence;
	}

	public String getHtmlForm() {

			String userAction = "take_product";
			String retString = "";
			retString += "<div class=\"formd\"><form name=\"takeForm\" id=\"takeForm\" action=c?user_action="+userAction +" method=post onsubmit='return validateForm();'><table>";
			retString += "<tr><td colspan=2>id:" + this.getProduct().getProduct()
				+ ".<input type=hidden name=catalog value=" + this.getProduct().getProduct_catalog()
				+ "><input type=hidden name=product_id value='" + this.getProduct().getProduct()
				+ "'></td><td></td></tr>";
			retString+="<tr><td>Nimetus:</td><td>" + this.getProduct().getName() + "</td><tr>";
			retString+="<tr><td>Lattu:</td><td><select name=chosenStore>";
			retString+=createDropDown(this.getItemStoreList());
			retString+="</select>";
			retString+=this.getErrorByField("chosenStore") + "</td></tr>";
			 retString+="<tr><td>Kogus:</td><td><input type=text name=chosenAmount value='"+this.getChosenAmount()+"'></td><td>tk.";
			 retString+=this.getErrorByField("chosenAmount") + "</td></tr>";
			 retString+="<tr><td>Lao hind:</td><td><input type=text name=chosenCost value='"+this.getChosenCost()+"'></td><td>tk." + this.getErrorByField("chosenCost") + "</td></tr>";
			 retString+="<tr><td>Kommentaar:</td><td><textarea name=comment rows ='2' cols ='15'>"+this.getComment()+"</textarea></td><td></tr>";
			 retString+="<tr><td></td><td><input type=submit  value = 'V6ta arvele'></td></tr>";
			 retString+="</div>";
			 System.out.println("TEST GREBEL1");
			 System.out.println("TEST GREBEL2");
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
				if(request.getParameter("chosenCost")!=null && !request.getParameter("chosenCost").equals("")) {
					setChosenCost(request.getParameter("chosenCost"));
					result = Integer.parseInt(getChosenCost());
				}
				else {
					setChosenCost("");
					formatErrors.put("chosenCost", "no value for field chosenAmount");
				}
			}
			catch(Exception E) {
				formatErrors.put("chosenCost", "Wrong format for field chosenCost");
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



	public String getErrorByField(String Field)
	{
		String field_error = "";
		String bns_error;
		String format_error;
		String chk_field = Field;


		if (formatErrors != null)
		{
			format_error = (String) formatErrors.get(chk_field);
			if (format_error != null)
			{
				field_error = format_error;
			}

		}

		return field_error;
	}

	public void supplyWithRequestData(HttpServletRequest request)
	{



	}




}

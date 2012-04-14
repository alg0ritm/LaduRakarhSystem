package ttu.rakarh1.web.view;

import java.util.List;

import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.forms.ProductForm;

public class DrawUpdateForm
{
	public String generateUpdateForm(ProductForm ProductForm, int selectedCatalog, String action)
	{
		String retString = "";
		retString += "<div class=\"formd\"><form action=c?user_action="+action+" method=post><table>";
		retString += "<tr><td colspan=2>id:" + ProductForm.getItem()
				+ ".<input type=hidden name=catalog value=" + selectedCatalog
				+ "><input type=hidden name=product_id value='" + ProductForm.getItem()
				+ "'></td><td></td></tr>";
		retString += "<tr><td>tootja kood:</td><td><input type=text name=product_code value='"
				+ ProductForm.getProducerCode() + "'></td></tr>";
		retString += "<tr><td>nimetus:</td><td><input type=text name=name value='"
				+ ProductForm.getName() + "' size=50></td><td>"
				+ ProductForm.getErrorByField("name") + "</td></tr>";
		retString += "<tr><td>ladumise hind:</td><td><input type=text name=store_price value='"
				+ ProductForm.getStorePrice() + "' size=50></td><td>"
				+ ProductForm.getErrorByField("eshop_price") + "</td></tr>";
		retString += "<tr><td>muugi hind:</td><td><input type=text name=sale_price value='"
				+ ProductForm.getSalePrice()
				+ "' size=50></td><td>"
				+ ProductForm.getErrorByField("sale_price") + "</td></tr>";
		retString += "<tr><td valign=top>kirjeldus:</td><td><textarea name=description rows=10 cols=50>"
				+ ProductForm.getDescription() + "</textarea></td></tr>";
		return retString;
	}

	public String generateInsertForm(ProductForm ProductForm, int selectedCatalog, String action)
	{
		String retString = "";
		retString += "<div class=\"formd\"><form action=c?user_action="+action+" method=post><table>";
		retString +="<tr><input type=hidden name=catalog value=" + selectedCatalog
				+ "><input type=hidden name=product_id value='"+ ProductForm.getItem()
				+ "'></td><td></td></tr>";
		retString += "<tr><td>tootja kood:</td><td><input type=text name=product_code value='" + ProductForm.getProducerCode() + "' size=50></td>"
				+ "<td>"+ProductForm.getErrorByField("product_code") + "</td></tr>";
		retString += "<tr><td>nimetus:</td><td><input type=text name=name value='" + ProductForm.getName()
				+ "' size=50></td>"
				+ "<td>"+ProductForm.getErrorByField("name") + "</td></tr>";
		retString += "<tr><td>ladumise hind:</td><td><input type=text name=store_price value='" + ProductForm.getStorePrice()
				+ "' size=50></td>"
				+ "</td>"
				+ "<td>"+ ProductForm.getErrorByField("eshop_price") + "</td></tr>";
		retString += "<tr><td>muugi hind:</td><td><input type=text name=sale_price value='" + ProductForm.getSalePrice()
				+ "' size=50></td>"
				+ "<td>"+ ProductForm.getErrorByField("sale_price") + "</td></tr>";
		retString += "<tr><td valign=top>kirjeldus:</td><td><textarea name=description rows=10 cols=50>"+ ProductForm.getDescription()
				+ "</textarea></td></tr>";
		return retString;
	}

	public String generateSpecialUpdateForm(List<FormAttribute> formAttributes, int selectedCatalog, String actionType)
	{
		String retString = "";
		String baseString = "";
		retString += "<tr><td colspan=2>------Special Attributes------</td></tr>";
		int cnt = 0;
		String prevName = "";
		String newName = "";
		//do enum
		String action = (actionType=="formAttributesUpdate")?"UPDATE":"INSERT";
		for (FormAttribute attr : formAttributes)
		{
			if(action=="UPDATE")
			{
				MyLogger.LogMessage("ACTION UPDATE");
			}
			else
			{
				MyLogger.LogMessage("ACTION INSERT");
			}
			cnt++;
			String value = attr.getName().getValue();
			String column = attr.getName().getColumnName();
			MyLogger.LogMessage("attr.getName().getValue() " + attr.getName().getValue());
			MyLogger.LogMessage("attr.getName().getColumnName() " + attr.getName().getColumnName());
			MyLogger.LogMessage("BEFORE attr.getValueText().getValue()");

			String valueText = (attr.getValueText()!=null)?attr.getValueText().getValue():"";
			String virtValue = (attr.getName()!=null)?attr.getName().getVirtValue():"";
			int isRequired = attr.getIsRequired();
			MyLogger.LogMessage("isRequired " + isRequired);

			newName = value;
			if (prevName == newName)
				value = "";
			String valueNumber = String.valueOf((attr.getValueNumber()!=null)?attr.getValueNumber().getValue():"");
			String baseValue = "";
			if(virtValue!=null)
				baseValue = virtValue;
			else if (valueText == null)
				baseValue = valueNumber;
			else
				baseValue = valueText;
			retString += "<tr><td>";
			retString += value;
			retString += (isRequired == 1) ? " * " : "";
			retString +="</td><td>";

			retString += "<input type=text name='" + value + "' value='"
					+ baseValue + "'></td>";
			if (attr.getName().errorsExist() > 0)
			{
				retString+="<td>" + attr.getName().printFirstError() + "</td>";
				MyLogger.LogMessage("Errors exist");
				//String errorCode = attr.getName().getErrors().get(1);
				//retString += errorCode;
			}
			retString+="</tr>";

			prevName = value;
		}
		retString+="<input type=hidden name='action' value='"+actionType+"'>";

		if (cnt > 0)
			return baseString + retString;
		return baseString;
	}

	public String generateSubmitButton()
	{
		String retString = "";
		retString += "<tr><td colspan=2><input type=submit value=Salvesta></td></tr></table>";
		retString += "</form></div>";
		return retString;
	}

}

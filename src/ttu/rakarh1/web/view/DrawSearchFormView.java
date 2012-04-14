package ttu.rakarh1.web.view;

import java.util.*;

import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.forms.SearchForm;

public class DrawSearchFormView {
	
		public String generateSearchForm(SearchForm searchForm, ProductCatalog selectedCatalog)
		{
			
				String retString="";
				retString+="<div class=\"formd\"><form name=\"special\" action=c?searchform=yes&catalog="+selectedCatalog.getProduct_catalog()+" method=post><table>";
			   retString+="<tr><td>tootja kood:</td><td><input type=text name=product_code value='" + searchForm.getProduct_code() + "'></td><td>" + searchForm.getErrorByField("product_code") + "</td></tr>";
			   retString+="<tr><td>nimetus:</td><td><input type=text name=name value='" + searchForm.getName() + "' size=50></td><td>" + searchForm.getErrorByField("name") + "</td></tr>";
			   retString+="<tr><td>minimaalne hind:</td><td><input type=text name=min_price value='" + searchForm.getMin_price() + "' size=50></td><td>" + searchForm.getErrorByField("min_price") + "</td></tr>";
			   retString+="<tr><td>maksimaalne hind:</td><td><input type=text name=max_price value='" + searchForm.getMax_price() + "' size=50></td><td>" + searchForm.getErrorByField("max_price") + "</td></tr>";
			   retString+="<tr><td>Otsitav kategooria:</td><td>" + selectedCatalog.getName() + "</td><td></td></tr>";
	          return retString;
		}
		
		public  String generateSpecialSearchForm(SearchForm searchForm, List<FormAttribute> formAttributes, ProductCatalog selectedCatalog )
		{
			String retString="";
			String baseString ="";
			
			retString+="<tr><td colspan=2>------Special Attributes------</td></tr>";
			int cnt=0;
			for (FormAttribute attr: formAttributes)
            {
				cnt++;
				String value = attr.getName().getValue();
				String column = attr.getName().getColumnName();
				String virtValue = attr.getName().getVirtValue();
				//MyLogger.LogMessage("generateGeneralSearchForm : VALUE " + value + "COLUMN" + column + "getTable()" + ran + "getColumnType()" + ran1);
				if(virtValue == null)
					virtValue = "";
				retString+="<tr><td>"+value+"</td><td><input type=text name='" + value +"' value='" + virtValue + "'></td></tr>";
			}
			if(cnt>0)
				return baseString + retString;
			return baseString;
		}
		
		public String generateGeneralSearchForm(SearchForm searchForm)
		{
			String retString="";
			retString+="<div class=\"formd\"><form name=\"general\" action=c?searchform=yes method=post><table>";
			retString+="<tr><td>tootja kood:</td><td><input type=text name=product_code value='" + searchForm.getProduct_code() + "'></td></tr>";
			retString+="<tr><td>nimetus:</td><td><input type=text name=name value='" + searchForm.getName() + "' size=50></td><td>" + searchForm.getErrorByField("name") + "</td></tr>";
			retString+="<tr><td>minimaalne hind:</td><td><input type=text name=min_price value='" + searchForm.getMin_price() + "' size=50></td><td>" + searchForm.getErrorByField("min_price") + "</td></tr>";
			retString+="<tr><td>maksimaalne hind:</td><td><input type=text name=max_price value='" + searchForm.getMax_price() + "' size=50></td><td>" + searchForm.getErrorByField("max_price") + "</td></tr>";
			retString+="<tr><td>Attribuudid:</td><td><input type=text name=attributes value='"+ searchForm.getGeneralAttributes();
			retString+= "' size=50></td><td></td></tr>";
			
			
			return retString;
		}
		
		public static String submitButton()
		{
			String retString = "";
			retString+="<tr><td colspan=2><input type=submit value=Otsi></td></tr></table>";
			retString+="</form></div>";
			return retString;
		}
			  
	  

}

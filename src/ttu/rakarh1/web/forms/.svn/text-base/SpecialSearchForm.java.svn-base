package ttu.rakarh1.web.forms;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.log.MyLogger;

public class SpecialSearchForm
{
	final String REQUIRED_ATTR = "REQUIRED ATTR";
	final String REQUIRED_INT = "REQUIRED INT";
	public static Pattern ALPHA = Pattern.compile("[A-Za-z]+");

	public void getSpecialFormData(HttpServletRequest req, List<FormAttribute> formAttributes)
	{

		Enumeration paramNames = req.getParameterNames();

		while (paramNames.hasMoreElements())
		{
			String paramName = (String) paramNames.nextElement();
			String paramValue = req.getParameter(paramName);
			MyLogger.LogMessage("param name " + paramName + "param Value"
					+ req.getParameter(paramName));
			for (FormAttribute fa : formAttributes)
			{
				if (fa.getName().getValue().equals(paramName) && paramValue != "")
				{
					fa.getName().setVirtValue(paramValue);
				}
			}
		}

	}
	
	public String getSpecialFormDataInsert(HttpServletRequest req, List<FormAttribute> formAttributes)
	{

		Enumeration paramNames = req.getParameterNames();
		String producerCode = null;

		while (paramNames.hasMoreElements())
		{
			String paramName = (String) paramNames.nextElement();
			String paramValue = req.getParameter(paramName);
			MyLogger.LogMessage("param name " + paramName + "param Value"
					+ req.getParameter(paramName));
			for (FormAttribute fa : formAttributes)
			{
				if(paramName.equals("product_code"))
				{
					producerCode = paramValue;
				}
				if (fa.getName().getValue().equals(paramName) && paramValue != "")
				{
					fa.getName().setVirtValue(paramValue);
				}
			}
		}
		return producerCode;

	}

	public int getSpecialFormDataErrors(HttpServletRequest req, List<FormAttribute> formAttributes)
	{
		Enumeration paramNames = req.getParameterNames();
		int errors = 0;
		
	    while(paramNames.hasMoreElements())
	    {
	    	MyLogger.LogMessage("getSpecialFormDataErrors paramNames.hasMoreElements()");
	    	String paramName = (String)paramNames.nextElement();
	    	String paramValue = req.getParameter(paramName);
	    	MyLogger.LogMessage("param name " + paramName + "param Value" + req.getParameter(paramName));
	    	for(FormAttribute fa : formAttributes)
	    	{
	    		MyLogger.LogMessage("getSpecialFormDataErrors paramNames.hasMoreElements() formAttributes");
	    		if(fa.getName().getValue().equals(paramName))
	    		{
	    			
	    			int columnType = fa.getName().getColumnType();
	    			MyLogger.LogMessage("getSpecialFormDataErrors paramNames.hasMoreElements() formAttributes columnType" + columnType);
	    			MyLogger.LogMessage("java.sql.Types.NUMERIC " + java.sql.Types.NUMERIC );
	    			
	    			int isRequired = fa.getIsRequired();
	    			fa.getName().setVirtValue(paramValue);
	    			fa.getName().createErrorMap();
	    			MyLogger.LogMessage("paramVal" + paramValue);
	    			if(isRequired==1 && paramValue==""){
	    				MyLogger.LogMessage("getSpecialFormDataErrors paramNames.hasMoreElements() formAttributes REQUIRED_ATTR");
	    				fa.getName().setError(REQUIRED_ATTR, "'*' elementid on vaja sisestada");
	    				errors = 1;
	    			}
	    			if(columnType==java.sql.Types.NUMERIC && checkAlphaNumeric(paramValue) ) 
	    			{
	    				MyLogger.LogMessage("getSpecialFormDataErrors paramNames.hasMoreElements() formAttributes REQUIRED_INT");
	    				fa.getName().setError(REQUIRED_INT, "väli ei tohi sisaldada arve");
	    				errors = 1;
	    			}
	    			
	    			
	    			
	    		}
	    	}
	    }
		return errors;
	    
	}
	
	
	
	

	

	public static boolean checkAlphaNumeric(String s)
	{
		if (s == null)
		{
			return false;
		} 
		else
		{
			Matcher m = ALPHA.matcher(s);
			return m.matches();
		}
	}

}

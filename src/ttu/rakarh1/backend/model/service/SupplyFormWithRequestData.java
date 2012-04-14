package ttu.rakarh1.backend.model.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ttu.rakarh1.backend.model.data.User;
import ttu.rakarh1.log.MyLogger;

public class SupplyFormWithRequestData
{

	public Object fillForm(Object object, HttpServletRequest request)
	{

		// TODO Auto-generated method stub
		 Object obj = null;
		 Class cls = null;
		try
		{
			obj = object;
		} catch (Exception e)
		{

			StackTraceElement[] stacktrace = e.getStackTrace();
			for(StackTraceElement elem : stacktrace)
			{
				MyLogger.LogMessage(elem.toString());
			}


		}
		 MyLogger.LogMessage("Current Class " + cls);
	     Method[] methods = obj.getClass().getMethods();
	     Field[] fields = obj.getClass().getFields();
	     MyLogger.LogMessage("BEFORE FIELDS COUNT");
	     MyLogger.LogMessage("BEFORE FIELDS COUNT");
	     MyLogger.LogMessage("BEFORE FIELDS COUNT2");
	     MyLogger.LogMessage("BEFORE FIELDS COUNT2");
	     MyLogger.LogMessage("FIELDS COUNT "+ fields.length);
	     MyLogger.LogMessage("METHODS COUNT "+ methods.length);
	     for(Field fieldTest : fields)
	     {
	    	 try
			{
				MyLogger.LogMessage("PRINTING FIELDS" +fieldTest.get(obj)+" ");
			} catch (IllegalArgumentException e)
			{
				MyLogger.LogMessage("ERROR PRINTING FIELDS() " + e.getStackTrace());
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				MyLogger.LogMessage("ERROR PRINTING FIELDS() " + e.getStackTrace());
				e.printStackTrace();
			}
	     }
	     int reqOccurenceInt = 0;
	     int occurence = 0;
	     try {
	    	 MyLogger.LogMessage("Current Class " + cls);
	    	 System.out.println("HELLO J REBEL");
	    	 System.out.println("HELLO J REBEL 2 ");
	    	 System.out.println("HELLO J REBEL 3 ");
	    	// Field reqOccurence = OperationOnProductForm.class.getField("reqOccurence");
	    	 MyLogger.LogMessage("Current Class " + cls);
	    	 //reqOccurenceInt = (Integer) reqOccurence.get(obj);

	     }
	     catch(Exception e)
	     {
	    	MyLogger.LogMessage("No field reqOccurence found in class " + cls);
	    	MyLogger.LogMessage("fillForm() " + e.getStackTrace());
	    	return null;
	     }

	     for(Method method : methods)
	     {
	    	 String methodName = method.getName();
	    	 String fieldName=elemenateGet(method.getName());
	    	 fieldName = firstLetterToLower(fieldName);
	    	 //fieldName = firstLetterToUpper(fieldName);

	    	 if(request.getParameter(fieldName)!=null && !methodName.contains("get"))
	    	 {
	    		 String paramValue = request.getParameter(fieldName);
	    		 Class[] parameterTypes = method.getParameterTypes();
	    		 String paramType = "";
	    		 MyLogger.LogMessage("PARAMETERS COUNT "+ parameterTypes.length);
	    		 for(Class parameterType: parameterTypes)
	    		 {
	    			 paramType = parameterType.toString();
	    			 MyLogger.LogMessage("Taking parameters "+ parameterType + "on the class "+ cls + " method " + methodName);
	    		 }


	    		 Class[] parameterTypes1 = method.getExceptionTypes();
	    		 for(Class parameterType: parameterTypes1)
	    			 MyLogger.LogMessage("Taking parameters1 "+ parameterTypes.getClass().getName() + "on the class "+ cls + " method " + methodName);



	    		 try {
	    			 MyLogger.LogMessage("Trying to call method "+ methodName + " start");
	    			 method.setAccessible(true);
	    			 MyLogger.LogMessage("Trying to call method "+ methodName + " middle");
	    			 int value = 0;
	    			 boolean useInt = false;
	    			 if(!paramType.contains("String"))
	    				 useInt = true;
	    			 MyLogger.LogMessage("VALUE "+ value);
	    			 MyLogger.LogMessage("useInt "+ useInt);
	    			 MyLogger.LogMessage("paramValue "+  paramValue);
	    			 MyLogger.LogMessage("value "+  value);
	    			 //String cast = parameterTypes[1].getClass().getName();
	    			 MyLogger.LogMessage("Trying to call method "+ methodName + "on the class "+ cls);
    			    Object o = method.invoke(obj, useInt?(Integer.parseInt(paramValue)):(String)paramValue);

    			    //out.format("%s() returned %b%n", mname, (Boolean) o);
    			    occurence++;

	    			// Handle any exceptions thrown by method to be invoked.
	    			} catch (Exception x) {
	    			    Throwable cause = x.getCause();
	    			    MyLogger.LogMessage("Error trying to call method "+ methodName + "on the class "+ cls + ". Reason "+cause.getMessage());
	    			}




	    	 }
	    	 if(methodName.equals("setUser")) {
	    		 HttpSession session = request.getSession();
	    		 try
				{
	    			 Object o = method.invoke(obj, (User)session.getAttribute("user"));
				} catch (IllegalArgumentException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 }
	     }

	     //if(reqOccurenceInt<=occurence)
	    	 return obj;
	     //return null;
	}

	private String elemenateGet(String name)
	{
		// TODO Auto-generated method stub
		String newMethodName = name.substring(3);
		MyLogger.LogMessage("Field Name "+ newMethodName);
		return newMethodName;


	}

	private String firstLetterToUpper(String fieldName)
	{
		String newFieldName = fieldName.substring(1);
		String letter = fieldName.substring(0, 1);
		letter = letter.toUpperCase();
		newFieldName = letter+newFieldName;
		return newFieldName;

	}

	private String firstLetterToLower(String fieldName)
	{
		String newFieldName = fieldName.substring(1);
		String letter = fieldName.substring(0, 1);
		letter = letter.toLowerCase();
		newFieldName = letter+newFieldName;
		MyLogger.LogMessage("Field Name "+ newFieldName);
		return newFieldName;

	}
}

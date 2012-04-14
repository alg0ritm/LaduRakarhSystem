package ttu.rakarh1.log ;

import org.apache.log4j.*;
import java.util.*;
import java.io.*;


public class MyLogger  {

	static Logger logger = Logger.getLogger(MyLogger.class);

	public  static void Log(String method_name,String msg)
	{
		String log_row="APP_ERROR:" + " method=" + method_name + " error_message=" + msg;

		try
		{logger.info(log_row);}
		catch(Exception ex)
		{ System.out.println("MyLogger.Log():" + ex.getMessage());}
	}

	public static void LogMessage(String msg)
	{
		String log_row="APP_MESSAGE:"  + msg;

		try
		{ logger.info(log_row);}
		catch(Exception ex)
		{ System.out.println("MyLogger.Log():" + ex.getMessage());}

	}
}

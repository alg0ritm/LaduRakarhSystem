<%-- 
    Document   : index
    Created on : Feb 28, 2009, 8:22:37 AM
    Author     : Meyyappan Muthuraman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        <s:form action="HelloWorld" >
            <s:textfield name="userName" label="User Name" />
            <s:submit />
        </s:form>
    </body>
</html>

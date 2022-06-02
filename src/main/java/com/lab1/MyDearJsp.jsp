<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsingServlet</title>
</head>
<body>
<h1>2020211001000714------huangxinghao</h1>
<h3>request.getParameter()、request.getParameterNames()、request.getWriter()</h3>
<%
    Enumeration p=request.getParameterNames();
    while(p.hasMoreElements()){
        String name=(String) p.nextElement();
        String value=request.getParameter(name);
        out.print(name + ":" + value);
        out.print("</br>");
    }
%>
<hr>
<h3>EL</h3>
name:${param.name}  </br>
class:${param.Class}    </br>
id:${param.ID}  </br>
submit:${param.submit}  </br>
</body>
</html>

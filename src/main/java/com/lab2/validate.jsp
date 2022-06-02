<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<h2>2020211001000714-HuangXinghao</h2>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="user" class="com.huangxinghao.lab2.Login" scope="request">
    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
    <jsp:setProperty name="user" property="username" />
    <jsp:setProperty name="user" property="password" />
</jsp:useBean>
<%
   //todo 3: use if check username is admin and ppassword is admin
    if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
%>
    <%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"></jsp:forward>
    <%--todo 5: else part{ --%>
<%}else{
// todo 6: print username or password error message
    out.println("username or password error");
%>
    <%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp"></jsp:include>
    <%--todo 8: close else --%>
<%}%>
</body>
</html>
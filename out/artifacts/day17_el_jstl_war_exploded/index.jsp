<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--page是配置jsp页面的--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" errorPage="500.jsp"  language="java" buffer="8kb" %>
<%--buffer是程序的大小
    import是导包的意思--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%List list =new ArrayList(); %>
  <%int a = 3/0;%>
  <c:catch></c:catch>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 马超
  Date: 2021/6/1
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

      <%
        System.out.println("hello,jsp");
        int i = 5;
        String contextPath = request.getContextPath();
        out.println(contextPath);
      %>
      <%!
        int i =3 ;


      %>
      <%=
      i
      %>
      <h1>hi,~jsp</h1>
      <%
        response.getWriter().write("response.......");
      %>

  </body>
</html>

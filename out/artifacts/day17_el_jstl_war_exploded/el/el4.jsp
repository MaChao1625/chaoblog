<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隐式对象</title>
</head>
<body>
${pageContext.request}<br>
<h3>动态获取虚拟目录，对路径进行编写</h3>
${pageContext.request.contextPath}
<%
    response.sendRedirect(request.getContextPath()+"");
%>

</body>
</html>

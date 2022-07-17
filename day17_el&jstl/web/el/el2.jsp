<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>
<%
    //在域中获取数据
    session.setAttribute("name","李四");
    request.setAttribute("name","张三");
    session.setAttribute("age",14);
%>

<h3>
    获取值
</h3>
${requestScope.name}<br>
${sessionScope.age}<br>
${name}

</body>
</html>

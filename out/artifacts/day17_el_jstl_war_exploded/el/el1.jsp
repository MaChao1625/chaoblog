<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3>4}
    \${5>6}
<h3>算数用算符</h3>
${3+4}<br>
${3 div 4}
${3 mod 4}
${3==4}<br>
${3>4 or 3<4}<br>
<h4>
    empty运算符
</h4>
<%
    String str = "";
    request.setAttribute("str",str);
    List list = new ArrayList();
    request.setAttribute("list",list);
%>
<%--    empt用来判断字符串，集合，数组对象是否不能为null并且长度大于0--%>
${not empty str}
${not empty list}

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! int a = 1;%>
<%!int b = 2;%>

<%
    int c = a + b;
    out.println(c);
    a = c;
    out.println(c);

%>


</body>
</html>

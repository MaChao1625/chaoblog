<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="cn.itcast.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--需求：在request域中有一个存有User对象的List集合，需要使用jstl+el将list集合展示到jsp页面的表格table中--%>
<html>
<head>
    <title>test</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("马超", 14, new Date()));
    list.add(new User("郑云婷", 15, new Date()));
    list.add(new User("归浩乐", 16, new Date()));
    list.add(new User("曹杰", 17, new Date()));
    request.setAttribute("list", list);

%>
<table border="1px" width="500" align="center">
    <%--表头--%>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <%--数据行--%>

    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count % 2!=0}">
            <tr bgcolor="red">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birstr}</td>
            </tr>

        </c:if>
        <c:if test="${s.count  % 2==0}">
            <tr bgcolor="yellow">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birstr}</td>
            </tr>

        </c:if>


    </c:forEach>

</table>

</body>
</html>

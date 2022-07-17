<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    ** + ** = **--%>
<%
    String operator=request.getParameter("operator");
    int n1=Integer.parseInt(request.getParameter("n1"));
    int n2=Integer.parseInt(request.getParameter("n2"));
    int result=0;
    if("+".equals(operator)){
        result= n1+n2;
    }
    else if("-".equals(operator)){
        result=n1-n2;
    }
    else if("*".equals(operator)){
        result=n1*n2;
    }
    else {
        result=n1/n2;
    }
    request.setAttribute("n1", n1);
    request.setAttribute("n2", n2);
    request.setAttribute("result", result); //往request作用域里放一个值
%>
<form>
    <input name="n1" value="<%= request.getAttribute("n1")==null?"":request.getAttribute("n1") %>">
    <select name="operator">
        <option value="+" <%= "+".equals(operator)?"selected":"" %>>+</option>
        <option value="-" <%= "-".equals(operator)?"selected":"" %>>-</option>
        <option value="*" <%= "*".equals(operator)?"selected":"" %>>*</option>
        <option value="/" <%= "/".equals(operator)?"selected":"" %>>/</option>

    </select>
    <input name="n2" value="<%= request.getAttribute("n2")==null?"":request.getAttribute("n2") %>">
    <input type="submit" value="=" onclick="return check();" >
    <input name="result" value="<%= request.getAttribute("result")==null?"":request.getAttribute("result") %>">
</form>

</body>
</html>

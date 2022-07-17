<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="computer.jsp" method="post">
    <input name="n1" value="" type="text"/>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>

    </select>
    <input type="text" name="n2">
    <input type="submit" value="提交"/>
</form>
</body>
</html>

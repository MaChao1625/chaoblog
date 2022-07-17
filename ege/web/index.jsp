<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center><h3>实现简单的计算</h3></center>
<form action="${pageContext.request.contextPath}/calculateServlet" method="post">
    <div class="form-group">
        <label for="value1">值1：</label>
        <input type="text" class="form-control" id="value1" name="value1" placeholder="请输入值1" value="${value1}">
    </div>
    <div class="form-group">
<%--        第一种方法用下拉链表--%>
        <%--<select name="operate">
          <option value="">请选择</option>
          <option value="+">+</option>
          <option value="-">-</option>
          <option value="*">*</option>
          <option value="/">/</option>
        </select>--%>
<%--第二种方法用单选框--%>
        <%--<input type="radio" name="operate" value="+">+<br>
        <input type="radio" name="operate" value="-">-<br>
        <input type="radio" name="operate" value="*">*<br>
        <input type="radio" name="operate" value="/">/<br>--%>

<%--    第三种方法是错误的，不能通过按钮来获取到value的值--%>
    <%--<button type="button" name="operate" value="+">+</button>
    <button type="button" name="operate" value="-">-</button>
    <button type="button" name="operate" value="*">*</button>
    <button type="button" name="operate" value="/">/</button>
--%>

    </div>
    <div class="form-group">
        <label for="value2">值2：</label>
        <input type="text" class="form-control" id="value2" name="value2" placeholder="请输入值2" value="${value2}">
    </div>


    <div class="form-group" style="text-align: center">
        <input class="btn" type="submit" value="提交"/>
        <input class="bt" type="reset" value="重置"/>
        <input class="btn" type="button" value="返回"/>
    </div>

    ${msg}
</form>
</body>

</html>

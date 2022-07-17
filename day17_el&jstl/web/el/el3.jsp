<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象的数据</title>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(18);
    user.setBirthday(new Date());//new Date()是获取当前的时间
    request.setAttribute("u",user);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("sname","李四");
    map.put("gender","男");
    map.put("user",user);
    request.setAttribute("map",map);
%>
<h3>el获取对象中的值</h3>
${requestScope.u}<br>
${requestScope.u.name}<br>
${u.age}<br>
${u.birthday}<br>
<%--获取birthday的一个年份--%>
${u.birthday.year}<br>
<%--月份是从0开始的所以得到的值小1--%>
${u.birthday.month}<br>

${u.birstr}
<h2>el获取list集合中的值</h2>
${list[0]}
${list[1]}
${list[2].name}
<h3>el获取Map中的值</h3>
${map.gender}
${map["gender"]}
${map.sname}<br>
${map.user.name}
</body>
</html>

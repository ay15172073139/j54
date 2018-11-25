<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/11/23
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" border="1" width="60%">
    <tr align="center">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <c:forEach var="k" varStatus="st" items="${requestScope.list}">
    <tr align="center">
        <td>${st.count}</td>
        <td>${k.name}</td>
        <td>${k.age}</td>
    </tr></c:forEach>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/12/5
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form method="post" action="demo6">
  <%--<input type="text" name="name"><br />--%>
  <%--<input type="text" name="age"><br />--%>
  <%--<input type="checkbox" name="hover" value="学习">--%>
  <%--<input type="checkbox" name="hover" value="写代码">--%>
  <%--<input type="checkbox" name="hover" value="看视频">--%>
  <%--<input type="checkbox" name="hover" value="看笔记">--%>
    <input type="text" name="peo[0].name">
    <input type="text" name="peo[0].age">
    <input type="text" name="peo[1].name">
    <input type="text" name="peo[1].age">
  <input type="submit" value="提交"/>
  <a href="demo7?age=123&name=abc">跳转</a>
  <a href="demo8/123/abc">跳转</a>
</form>
  </body>
</html>

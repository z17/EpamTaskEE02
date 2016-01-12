<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean deleteStatus = (Boolean) request.getAttribute("deleteStatus");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Удалить тариф</title>
    <link rel="stylesheet" href="/style/style.css" type="text/css" />
</head>
<body>
<div class="wrapper">
    <%
        if (deleteStatus) {
            out.print("Удалено");
        } else {
            out.print("Ошибка");
        }
    %>
    <div><a href="/">На главную</a></div>
</div>
</body>
</html>

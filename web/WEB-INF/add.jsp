<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean valid = (Boolean) request.getAttribute("validForm");
    Boolean insertStatus = (Boolean) request.getAttribute("insertStatus");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Добавить тариф</title>
    <link rel="stylesheet" src="//normalize-css.googlecode.com/svn/trunk/normalize.css" type="text/css" />
    <link rel="stylesheet" src="/style/style.css" type="text/css" />
    <link rel="stylesheet" src="${pageContext.request.contextPath}/style/style.css" type="text/css" />

</head>
<body>
<div class="wrapper">
    <%
    if (valid != null) {
        if (valid) {
            if (insertStatus) {
                out.print("Добавлен успешно");
            } else {
                out.print("Ошибка добавления");
            }
        } else {
            out.print("Ошибка ввода данных");
        }
    }
    %>
    <h2>Добавить тариф</h2>
    <form method="POST">
        <label>Имя:
            <input type="text" name="name"/>
        </label><br>
        <label>
            Цена за минуту:
            <input type="text" name="minute_price"/>
        </label><br>
        <label>
            Абонентская плата:
            <input type="text" name="month_price"/>
        </label><br>
        <label>
            Описание:<br>
            <textarea name="description"></textarea>
        </label><br>
        <input type="submit" name="submit">
    </form>
</div>
</body>
</html>

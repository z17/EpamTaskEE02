<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean valid = (Boolean) request.getAttribute("validForm");
%>
<html>
<head>
    <title>Добавить тариф</title>
</head>
<body>
<div class="wrapper">
    <%
        if (valid != null) {
            if (valid) {
                %>
                Тариф добавлен
                <%
            } else {
                %>
                Ошибка в ввода данных
                <%

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

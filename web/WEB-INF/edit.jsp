<%@ page import="tariffs.Tariff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Tariff tariff = (Tariff) request.getAttribute("tariff");
    Boolean validForm = (Boolean) request.getAttribute("validForm");
    Boolean updateStatus = (Boolean) request.getAttribute("updateStatus");
%>
<html>
<head>
    <title>Редактировать тариф</title>
    <link rel="stylesheet" href="/style/style.css" type="text/css" />
</head>
<body>
<div class="wrapper">
    <h2>Редактировать тариф</h2>
    <%
    if (tariff != null) {

        if (validForm != null && !validForm) {
            out.println("<p>Неверные данные</p>");
        }
        if (updateStatus != null) {
            if (updateStatus) {
                out.println("<p>Данные обновлены</p>");
            } else {
                out.println("<p>Ошибка обновления</p>");
            }
        }
        %>
        <form method="POST">
            <label>
                Имя:
                <input type="text" name="name" value="<%=tariff.getName()%>"/>
            </label><br>
            <label>
                Цена за минуту:
                <input type="text" name="minute_price" value="<%=tariff.getMinutePrice()%>"/>
            </label><br>
            <label>
                Абонентская плата:
                <input type="text" name="month_price" value="<%=tariff.getMonthPrice()%>"/>
            </label><br>
            <label>
                Описание:<br>
                <textarea name="description"><%=tariff.getDescription()%></textarea>
            </label>
            <input type="submit" name="submit">
        </form>
        <%
    } else {
        out.print("ERROR ID");
    }
    %>
    <div><a href="/">На главную</a></div>
</div>
</body>
</html>

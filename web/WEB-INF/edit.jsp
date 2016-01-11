<%@ page import="tariffs.Tariff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Tariff tariff = (Tariff) request.getAttribute("tariff");
%>
<html>
<head>
    <title>Добавить тариф</title>
    <link rel="stylesheet" src="//normalize-css.googlecode.com/svn/trunk/normalize.css" type="text/css" />
    <link rel="stylesheet" src="/style/style.css" type="text/css" />
</head>
<body>
<div class="wrapper">
    <h2>Редактировать тариф</h2>
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
</div>
</body>
</html>

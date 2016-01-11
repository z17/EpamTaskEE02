<%@ page import="tariffs.Tariff" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Collection<Tariff> tariffs = (Collection<Tariff>) request.getAttribute("tariffs");
%>
<html>
<head>
    <title>Tariffs list</title>
    <link rel="stylesheet" src="//normalize-css.googlecode.com/svn/trunk/normalize.css" type="text/css" />
    <link rel="stylesheet" src="/style/style.css" type="text/css" />
    <link rel="stylesheet" src="http://blweb.ru/wp-content/themes/blweb_new/style.css" type="text/css" />
</head>
<body>
    <div class="wrapper">
        <h1>Список тарифов</h1>
        <% if (tariffs != null) {
            for (Tariff tariff:tariffs) { %>
            <div class="item">
                <h2><%=tariff.getName()%></h2>
                <p><%=tariff.getDescription()%></p>
                <p><%=tariff.getMinutePrice()%> руб/минута</p>
                <p><%=tariff.getMonthPrice()%> руб абонентская плата</p>
            </div>
        <% }
        } else {
        %>
            Нет тарифов
        <% } %>
    </div>
</body>
</html>

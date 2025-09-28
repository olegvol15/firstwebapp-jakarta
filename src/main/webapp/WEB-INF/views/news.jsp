<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Новини</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="container">
    <h1 class="page-title">Новини</h1>
    <div class="stack">
        <%
            java.util.List<org.example.laptops.models.NewsItem> news =
                    (java.util.List<org.example.laptops.models.NewsItem>) request.getAttribute("news");
            for (var n : news) {
        %>
        <a class="card link" href="#" onclick="return false">
            <img class="thumb" src="<%=request.getContextPath()+ n.getImagePath()%>" alt="news">
            <div>
                <div class="badge">Оновлення</div>
                <h3 style="margin:6px 0 6px;font-size:24px"><%= n.getTitle() %></h3>
                <p class="subtle" style="font-size:18px;margin:0"><%= n.getSummary() %></p>
            </div>
        </a>
        <% } %>
    </div>
</div>
</body>
</html>



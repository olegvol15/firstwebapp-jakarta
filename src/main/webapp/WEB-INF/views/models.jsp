<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Моделі ноутбуків</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="container">
    <h1 class="page-title">Моделі</h1>
    <div class="stack">
        <%
            java.util.List<org.example.laptops.models.LaptopModel> models =
                    (java.util.List<org.example.laptops.models.LaptopModel>) request.getAttribute("models");
            for (var m : models) {
        %>
        <a class="card link" href="<%=request.getContextPath()%>/maker/model?id=<%= m.getId() %>">
            <img class="thumb" src="<%=request.getContextPath()+ m.getThumbPath()%>" alt="model">
            <div>
                <h3 style="margin:4px 0 6px;font-size:28px"><%= m.getName() %></h3>
                <p class="subtle" style="font-size:18px;margin:0"><%= m.getShortDesc() %></p>
            </div>
        </a>
        <% } %>
    </div>
</div>
</body>
</html>



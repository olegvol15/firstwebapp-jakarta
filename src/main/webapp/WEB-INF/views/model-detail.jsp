<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Модель — деталі</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="container">
    <%
        org.example.laptops.models.LaptopModel model =
                (org.example.laptops.models.LaptopModel) request.getAttribute("model");
    %>
    <h1 class="page-title"><%= model.getName() %></h1>
    <p class="subtle" style="font-size:18px"><%= model.getShortDesc() %></p>
    <div class="gallery" style="margin-top:10px">
        <% for (String img : model.getGallery()) { %>
        <img src="<%=request.getContextPath()+ img%>" alt="photo">
        <% } %>
    </div>
    <div class="hr"></div>
    <a class="button" href="<%=request.getContextPath()%>/maker/models">← Повернутися до моделей</a>
</div>
</body>
</html>


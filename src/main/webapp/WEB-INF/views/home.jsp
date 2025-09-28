<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Lenovo — Загальна інформація</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css?v=<%=System.currentTimeMillis()%>">
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="container">
    <%
        org.example.laptops.models.Manufacturer m =
                (org.example.laptops.models.Manufacturer) request.getAttribute("m");
    %>

    <div class="row" style="align-items:flex-start;gap:28px">
        <div>
            <h1 class="page-title" style="margin:0"><%= m.getName() %></h1>
            <p class="subtle" style="font-size:18px;max-width:760px">
                Міжнародна технологічна компанія, відома лінійками ноутбуків ThinkPad, Legion та Yoga.
                Зосереджується на інноваціях, надійності та глобальній присутності.
            </p>
        </div>
<%--        <img src="<%=request.getContextPath()+ m.getLogoPath()%>" alt="Lenovo logo"--%>
<%--             style="height:64px;border-radius:10px;border:1px solid var(--line);background:#fff;padding:8px">--%>
    </div>

    <div class="hr"></div>

    <div class="card">
        <dl class="kv">
            <dt>Штаб-квартира</dt><dd><%= m.getHqCountry() %> (Пекін / Моррісвілл, США)</dd>
            <dt>Кількість співробітників</dt><dd><%= m.getEmployees() %>+</dd>
            <dt>Основні напрями</dt><dd>Ноутбуки, ПК, робочі станції, аксесуари, ІоТ, дата-центри</dd>
            <dt>Бренди/лінійки</dt><dd>ThinkPad, ThinkBook, Legion, Yoga, IdeaPad</dd>
            <dt>Присутність</dt><dd>180+ країн, мережа R&amp;D та виробничих центрів</dd>
        </dl>
    </div>

    <div class="hr"></div>

    <div class="row" style="align-items:stretch">
        <div class="card" style="flex:1">
            <div class="badge">Переваги</div>
            <ul style="margin:10px 0 0 18px;line-height:1.8">
                <li>Надійність бізнес-класу (серія ThinkPad)</li>
                <li>Потужні ігрові рішення (серія Legion)</li>
                <li>Преміальні трансформери (серія Yoga, OLED/роздільні петлі)</li>
                <li>Гарне співвідношення ціни та можливостей (IdeaPad/ThinkBook)</li>
            </ul>
        </div>
        <div class="card" style="flex:1">
            <div class="badge">Фокус на інноваціях</div>
            <ul style="margin:10px 0 0 18px;line-height:1.8">
                <li>Сертифікації MIL-STD для довговічності</li>
                <li>Системи охолодження й енергоефективність</li>
                <li>Безпека: TPM, сканери відбитків, шторки камери</li>
                <li>Екологічні матеріали та пакування</li>
            </ul>
        </div>
    </div>

    <div class="hr"></div>

    <div class="row">
        <a class="button" href="<%=request.getContextPath()%>/maker/history">Детальніше про історію</a>
        <a class="button" href="<%=request.getContextPath()%>/maker/models" style="background:#111827;border-color:#0b0c0f">Дивитися моделі</a>
    </div>
</div>
</body>
</html>



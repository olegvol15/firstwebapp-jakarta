<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Lenovo — Історія розвитку</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css?v=<%=System.currentTimeMillis()%>">
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="container">
    <h1 class="page-title">Історія розвитку</h1>

    <div class="card" style="margin-bottom:18px">
        <p class="subtle" style="margin:0">
            Витоки компанії беруть початок у Китаї. За десятиліття Lenovo перетворилася на глобального лідера ПК-ринку.
            Ключовим етапом стало придбання підрозділу ПК IBM у 2005 році, разом з легендарною серією ThinkPad.
        </p>
    </div>

    <div class="stack">
        <div class="card">
            <div class="badge">1984–2004</div>
            <h3 style="margin:6px 0 10px">Заснування та становлення</h3>
            <p class="subtle" style="margin:0">
                Компанія зародилася як невеликий стартап, сфокусований на локальному ринку.
                Поступово вийшла на міжнародну арену, інвестуючи у R&amp;D та виробництво.
            </p>
        </div>

        <div class="card">
            <div class="badge">2005</div>
            <h3 style="margin:6px 0 10px">Інтеграція IBM PC та ThinkPad</h3>
            <p class="subtle" style="margin:0">
                Придбання бізнесу ПК IBM вивело Lenovo до топ-гравців ринку. Серія ThinkPad стала символом
                надійності та бізнес-стандартом для багатьох корпорацій.
            </p>
        </div>

        <div class="card">
            <div class="badge">2010-ті</div>
            <h3 style="margin:6px 0 10px">Диверсифікація та геймінг</h3>
            <p class="subtle" style="margin:0">
                Запуск лінійки Legion для ігор, розвиток Yoga та IdeaPad, розширення портфеля аксесуарів і сервісів.
            </p>
        </div>

        <div class="card">
            <div class="badge">Сьогодні</div>
            <h3 style="margin:6px 0 10px">Глобальна присутність</h3>
            <p class="subtle" style="margin:0">
                Розгалужена мережа R&amp;D і виробництва, фокус на безпеці, якості та сталому розвитку.
            </p>
        </div>
    </div>

    <div class="hr"></div>

    <div class="gallery" style="margin-bottom:14px">
        <img src="<%=request.getContextPath()%>/images/h1.jpg" alt="Штаб-квартира Lenovo">
        <img src="<%=request.getContextPath()%>/images/h2.jpg" alt="Ранні ThinkPad">
        <img src="<%=request.getContextPath()%>/images/h3.jpg" alt="Сучасні ноутбуки Lenovo">
    </div>

    <div class="row">
        <a class="button" href="https://www.lenovo.com/" target="_blank" rel="noopener">Офіційний ресурс</a>
        <a class="button" href="<%=request.getContextPath()%>/maker/models" style="background:#111827;border-color:#0b0c0f">Перейти до моделей</a>
    </div>
</div>
</body>
</html>




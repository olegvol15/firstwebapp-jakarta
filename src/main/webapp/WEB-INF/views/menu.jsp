<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String uri = request.getRequestURI();
    String ctx = request.getContextPath();
%>
<header class="header">
    <div class="header-inner">
        <a class="brand" href="<%=ctx%>/maker">
            <span class="brand-badge">Lenovo</span>
            <span class="brand-name">Laptop Manufacturer</span>
        </a>
        <nav class="nav">
            <a href="<%=ctx%>/maker" class="<%= uri.endsWith("/maker") ? "active" : "" %>">Загальна інформація</a>
            <a href="<%=ctx%>/maker/history" class="<%= uri.contains("/history") ? "active" : "" %>">Історія</a>
            <a href="<%=ctx%>/maker/news" class="<%= uri.contains("/news") ? "active" : "" %>">Новини</a>
            <a href="<%=ctx%>/maker/models" class="<%= (uri.contains("/models") || uri.contains("/model")) ? "active" : "" %>">Моделі ноутбуків</a>
        </nav>
    </div>
</header>

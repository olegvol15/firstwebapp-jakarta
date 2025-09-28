<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Статистика тексту</title>
</head>
<body>
<h1>Статистика тексту</h1>
<form action="<%=request.getContextPath()%>/text-stats" method="post">
    <textarea name="text" rows="8" cols="80" required></textarea><br><br>
    <button type="submit">Проаналізувати</button>
</form>
<p><a href="<%=request.getContextPath()%>/index.jsp">← Назад</a></p>
</body>
</html>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Калькулятор (3 числа)</title>
    <style>
        label{display:block;margin:8px 0}
        .result{border:1px solid #333;padding:6px 10px;background:#f7f7f7;display:inline-block}
    </style>
</head>
<body>
<h1>Обчислення з трьох чисел</h1>

<form action="<%=request.getContextPath()%>/calc" method="post">
    <label>Число 1: <input type="number" name="num1" step="any" required></label>
    <label>Число 2: <input type="number" name="num2" step="any" required></label>
    <label>Число 3: <input type="number" name="num3" step="any" required></label>

    <fieldset style="margin:12px 0">
        <legend>Дія:</legend>
        <label><input type="radio" name="op" value="max" checked> Максимум</label>
        <label><input type="radio" name="op" value="min"> Мінімум</label>
        <label><input type="radio" name="op" value="avg"> Середнє арифметичне</label>
    </fieldset>

    <button type="submit">Обчислити</button>
</form>
<p><a href="<%=request.getContextPath()%>/calc.jsp">Калькулятор</a></p>
<p><a href="<%=request.getContextPath()%>/survey.jsp">Анкета</a></p>

</body>
</html>



<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Калькулятор</title>
    <style>
        body { font-family: system-ui, Arial, sans-serif; padding: 20px; }
        label { display:block; margin:8px 0; }
        .row { display:flex; gap:16px; align-items:center; }
        .result { margin-top:16px; padding:8px 12px; background:#f7f7f7; border:1px solid #ccc; display:inline-block; }
    </style>
</head>
<body>
<h1>Калькулятор (дві величини)</h1>

<form action="<%=request.getContextPath()%>/calc-adv" method="post">
    <div class="row">
        <label>Число A: <input type="number" name="a" step="any" required></label>
        <label>Число B: <input type="number" name="b" step="any" required></label>
    </div>

    <fieldset style="margin:12px 0">
        <legend>Операція</legend>
        <label><input type="radio" name="op" value="add" checked> Додавання (A + B)</label>
        <label><input type="radio" name="op" value="sub"> Віднімання (A − B)</label>
        <label><input type="radio" name="op" value="mul"> Множення (A × B)</label>
        <label><input type="radio" name="op" value="div"> Ділення (A ÷ B)</label>
        <label><input type="radio" name="op" value="pow"> Степінь (A ^ B)</label>
        <label><input type="radio" name="op" value="pct"> Відсотки (A% від B)</label>
    </fieldset>

    <button type="submit">Обчислити</button>
</form>

<p style="margin-top:12px"><a href="<%=request.getContextPath()%>/index.jsp">← На головну</a></p>
</body>
</html>

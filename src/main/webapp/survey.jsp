<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Анкета</title>
    <style>
        body{font-family:system-ui,Arial;padding:20px}
        label{display:block;margin:8px 0}
        .row{display:flex;gap:12px;align-items:center;flex-wrap:wrap}
        .err{color:#b00020;margin:0 0 8px 0}
        input[type=text], input[type=tel], input[type=email], input[type=number]{min-width:320px}
    </style>
</head>
<body>
<h1>Анкета</h1>

<form action="<%=request.getContextPath()%>/survey" method="post" accept-charset="UTF-8">
    <label>ПІБ:
        <input type="text" name="fullName" required placeholder="Прізвище Ім'я По батькові">
    </label>

    <label>Телефон:
        <input type="tel" name="phone" required placeholder="+380XXXXXXXXX">
    </label>

    <label>Email:
        <input type="email" name="email" required placeholder="name@example.com">
    </label>

    <div class="row">
        <label>Вік:
            <input type="number" name="age" min="0" max="120" required>
        </label>
    </div>

    <fieldset style="margin:12px 0">
        <legend>Стать</legend>
        <label><input type="radio" name="gender" value="male" checked> Чоловік</label>
        <label><input type="radio" name="gender" value="female"> Жінка</label>
        <label><input type="radio" name="gender" value="other"> Інше</label>
    </fieldset>

    <label><input type="checkbox" name="subscribe"> Хочете підписатися на нашу розсилку?</label>

    <button type="submit">Надіслати</button>
</form>

<p style="margin-top:12px"><a href="<%=request.getContextPath()%>/index.jsp">← На головну</a></p>
</body>
</html>


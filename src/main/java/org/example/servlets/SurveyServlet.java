package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {

    private static final Pattern NAME_RE = Pattern.compile("^[\\p{L}.'\\-\\s]{3,100}$");
    private static final Pattern PHONE_RE = Pattern.compile("^[+]?\\d[\\d\\s\\-()]{6,19}$");
    private static final Pattern EMAIL_RE = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String fullName = trim(req.getParameter("fullName"));
        String phone    = trim(req.getParameter("phone"));
        String email    = trim(req.getParameter("email"));
        String ageStr   = trim(req.getParameter("age"));
        String gender   = trim(req.getParameter("gender"));
        boolean subscribe = req.getParameter("subscribe") != null;

        List<String> errors = new ArrayList<>();

        if (fullName.isEmpty() || !NAME_RE.matcher(fullName).matches())
            errors.add("Некоректне ПІБ. Дозволені лише літери, пробіли, апостроф, дефіс (3–100 символів).");

        if (phone.isEmpty() || !PHONE_RE.matcher(phone).matches())
            errors.add("Некоректний номер телефону. Приклад: +380 67 123 45 67.");

        if (email.isEmpty() || !EMAIL_RE.matcher(email).matches())
            errors.add("Некоректний email.");

        int age = -1;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 0 || age > 120) errors.add("Вік має бути від 0 до 120.");
        } catch (NumberFormatException e) {
            errors.add("Вік має бути цілим числом.");
        }

        if (!( "male".equals(gender) || "female".equals(gender) || "other".equals(gender) ))
            errors.add("Оберіть стать.");

        if (!errors.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!doctype html><html lang='uk'><head><meta charset='UTF-8'><title>Помилка</title>");
                out.println("<style>body{font-family:system-ui,Arial;padding:20px} .err{color:#b00020}</style>");
                out.println("</head><body>");
                out.println("<h1>Будь ласка, виправте помилки</h1><ul class='err'>");
                for (String err : errors) out.println("<li>" + escape(err) + "</li>");
                out.println("</ul>");
                out.println("<p><a href='" + req.getContextPath() + "/survey.jsp'>← Повернутись до анкети</a></p>");
                out.println("</body></html>");
            }
            return;
        }

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!doctype html><html lang='uk'><head><meta charset='UTF-8'><title>Анкета — результат</title>");
            out.println("<style>body{font-family:system-ui,Arial;padding:20px} .box{border:1px solid #ccc;padding:10px;background:#f7f7f7}</style>");
            out.println("</head><body>");
            out.println("<h1>Дякуємо! Ось ваші дані:</h1>");
            out.println("<div class='box'><ul>");
            out.println("<li><strong>ПІБ:</strong> " + escape(fullName) + "</li>");
            out.println("<li><strong>Телефон:</strong> " + escape(phone) + "</li>");
            out.println("<li><strong>Email:</strong> " + escape(email) + "</li>");
            out.println("<li><strong>Вік:</strong> " + age + "</li>");
            out.println("<li><strong>Стать:</strong> " + humanGender(gender) + "</li>");
            out.println("<li><strong>Підписка:</strong> " + (subscribe ? "Так" : "Ні") + "</li>");
            out.println("</ul></div>");
            out.println("<p><a href='" + req.getContextPath() + "/survey.jsp'>← Заповнити ще раз</a></p>");
            out.println("</body></html>");
        }
    }

    private static String trim(String s){ return s == null ? "" : s.trim(); }
    private static String escape(String s){
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'","&#39;");
    }
    private static String humanGender(String g){
        switch (g){
            case "male": return "Чоловік";
            case "female": return "Жінка";
            default: return "Інше";
        }
    }
}


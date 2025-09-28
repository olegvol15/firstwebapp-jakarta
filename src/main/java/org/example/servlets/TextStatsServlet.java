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
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/text-stats")
public class TextStatsServlet extends HttpServlet {

    private static final String VOWELS = "аеєиіїоуюяыэё";
    private static final Locale UA = Locale.forLanguageTag("uk");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String text = req.getParameter("text");
        if (text == null) text = "";

        AtomicInteger vowelsCount = new AtomicInteger();
        AtomicInteger consonantsCount = new AtomicInteger();
        AtomicInteger punctCount = new AtomicInteger();
        List<String> vowelsList = new ArrayList<>();
        List<String> consonantsList = new ArrayList<>();
        List<String> punctList = new ArrayList<>();

        text.codePoints().forEach(cp -> {
            char[] chars = Character.toChars(cp);
            String s = new String(chars);
            String low = s.toLowerCase(UA);

            int type = Character.getType(cp);
            boolean isPunct =
                    type == Character.CONNECTOR_PUNCTUATION ||
                            type == Character.DASH_PUNCTUATION ||
                            type == Character.START_PUNCTUATION ||
                            type == Character.END_PUNCTUATION ||
                            type == Character.INITIAL_QUOTE_PUNCTUATION ||
                            type == Character.FINAL_QUOTE_PUNCTUATION ||
                            type == Character.OTHER_PUNCTUATION;

            if (isPunct) {
                punctCount.getAndIncrement();
                punctList.add(s);
            } else if (Character.isLetter(cp)) {
                if (VOWELS.contains(low)) {
                    vowelsCount.getAndIncrement();
                    vowelsList.add(s);
                } else {
                    consonantsCount.getAndIncrement();
                    consonantsList.add(s);
                }
            }
        });

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!doctype html><html lang='uk'><head><meta charset='UTF-8'><title>Статистика</title>");
            out.println("<style>ul{line-height:1.8} .box{border:1px solid #ccc;padding:8px;background:#f7f7f7;}</style>");
            out.println("</head><body>");
            out.println("<h1>Результат аналізу</h1>");
            out.println("<p><strong>Вхідний текст:</strong></p>");
            out.println("<div class='box'>" + escapeHtml(text).replace("\n","<br>") + "</div>");

            out.println("<h2>Підсумки</h2><ul>");
            out.println("<li>Голосних: <strong>" + vowelsCount + "</strong></li>");
            out.println("<li>Приголосних: <strong>" + consonantsCount + "</strong></li>");
            out.println("<li>Розділових знаків: <strong>" + punctCount + "</strong></li>");
            out.println("</ul>");

            out.println("<h3>Список голосних</h3><div class='box'>" + String.join(" ", vowelsList) + "</div>");
            out.println("<h3>Список приголосних</h3><div class='box'>" + String.join(" ", consonantsList) + "</div>");
            out.println("<h3>Список розділових</h3><div class='box'>" + String.join(" ", punctList) + "</div>");

            out.println("<p><a href='" + req.getContextPath() + "/text.jsp'>← Назад до форми</a></p>");
            out.println("</body></html>");
        }
    }

    private static String escapeHtml(String s) {
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'","&#39;");
    }
}

package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Кодування
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String s1 = req.getParameter("num1");
        String s2 = req.getParameter("num2");
        String s3 = req.getParameter("num3");
        String op = req.getParameter("op"); // "max" | "min" | "avg"

        double n1, n2, n3;
        try {
            n1 = Double.parseDouble(s1);
            n2 = Double.parseDouble(s2);
            n3 = Double.parseDouble(s3);
        } catch (Exception e) {
            writeError(resp, "Будь ласка, введіть коректні числові значення.");
            return;
        }

        double result;
        String title;

        switch (op == null ? "max" : op) {
            case "min":
                result = Math.min(n1, Math.min(n2, n3));
                title = "Мінімум";
                break;
            case "avg":
                result = (n1 + n2 + n3) / 3.0;
                title = "Середнє арифметичне";
                break;
            case "max":
            default:
                result = Math.max(n1, Math.max(n2, n3));
                title = "Максимум";
        }

        DecimalFormat df = new DecimalFormat("#.######"); // охайний формат

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!doctype html><html lang='uk'><head><meta charset='UTF-8'>");
            out.println("<title>Результат</title>");
            out.println("<style>.result{border:1px solid #333;padding:6px 10px;background:#f7f7f7;display:inline-block}</style>");
            out.println("</head><body>");
            out.println("<h2>Введені числа</h2>");
            out.println("<ul>");
            out.println("<li>Число 1: " + df.format(n1) + "</li>");
            out.println("<li>Число 2: " + df.format(n2) + "</li>");
            out.println("<li>Число 3: " + df.format(n3) + "</li>");
            out.println("</ul>");

            out.println("<h2>" + title + ":</h2>");
            out.println("<div class='result'>" + df.format(result) + "</div>");

            out.println("<p><a href='" + req.getContextPath() + "/index.jsp'>← Повернутись</a></p>");
            out.println("</body></html>");
        }
    }

    private void writeError(HttpServletResponse resp, String msg) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!doctype html><html lang='uk'><head><meta charset='UTF-8'><title>Помилка</title></head><body>");
            out.println("<h3 style='color:#b00'>" + msg + "</h3>");
            out.println("</body></html>");
        }
    }
}

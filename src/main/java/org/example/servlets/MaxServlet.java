package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/max")
public class MaxServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // Отримуємо параметри
        String n1 = req.getParameter("num1");
        String n2 = req.getParameter("num2");
        String n3 = req.getParameter("num3");

        double num1 = Double.parseDouble(n1);
        double num2 = Double.parseDouble(n2);
        double num3 = Double.parseDouble(n3);

        // Рахуємо максимум
        double max = Math.max(num1, Math.max(num2, num3));

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head><meta charset='UTF-8'><title>Результат</title></head><body>");
            out.println("<h2>Введені числа:</h2>");
            out.println("<ul>");
            out.println("<li>Число 1: " + num1 + "</li>");
            out.println("<li>Число 2: " + num2 + "</li>");
            out.println("<li>Число 3: " + num3 + "</li>");
            out.println("</ul>");
            out.println("<h2 style='color:green;'>Максимум: <span style='border:1px solid #000; padding:5px; background:#f0f0f0;'>" + max + "</span></h2>");
            out.println("<p><a href='" + req.getContextPath() + "/index.jsp'>Повернутись</a></p>");
            out.println("</body></html>");
        }
    }
}

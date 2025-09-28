package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

@WebServlet("/calc-adv")
public class CalcAdvancedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String sa = req.getParameter("a");
        String sb = req.getParameter("b");
        String op = req.getParameter("op");

        double a, b;
        try {
            a = Double.parseDouble(sa);
            b = Double.parseDouble(sb);
        } catch (Exception e) {
            render(resp, "Помилка: введіть коректні числа.", Double.NaN, sa, sb, op);
            return;
        }

        double res;
        String title;

        if (op == null) op = "add";

        switch (op) {
            case "sub":
                res = a - b; title = "A − B"; break;
            case "mul":
                res = a * b; title = "A × B"; break;
            case "div":
                if (b == 0.0) {
                    render(resp, "Помилка: ділення на нуль.", Double.NaN, sa, sb, op);
                    return;
                }
                res = a / b; title = "A ÷ B"; break;
            case "pow":
                res = Math.pow(a, b); title = "A ^ B"; break;
            case "pct":
                res = (a / 100.0) * b; title = "A% від B"; break;
            case "add":
            default:
                res = a + b; title = "A + B";
        }

        render(resp, title, res, sa, sb, op);
    }

    private void render(HttpServletResponse resp, String title, double result,
                        String sa, String sb, String op) throws IOException {
        DecimalFormat df = new DecimalFormat("#.########");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!doctype html><html lang='uk'><head><meta charset='UTF-8'>");
            out.println("<title>Калькулятор — результат</title>");
            out.println("<style>body{font-family:system-ui,Arial;padding:20px} .result{padding:8px 12px;background:#f7f7f7;border:1px solid #ccc;display:inline-block;margin-top:8px}</style>");
            out.println("</head><body>");
            out.println("<h1>Результат</h1>");
            out.println("<p><strong>Вхідні дані:</strong> A=" + sa + ", B=" + sb + "</p>");
            out.println("<p><strong>Операція:</strong> " + escape(title) + "</p>");
            if (Double.isNaN(result)) {
                out.println("<p style='color:#b00'>" + escape(title) + "</p>");
            } else {
                out.println("<div class='result'><strong>Відповідь:</strong> " + df.format(result) + "</div>");
            }
            out.println("<p style='margin-top:16px'><a href='"
                    + escape(reqContext(resp)) + "/calc.jsp'>← Назад до калькулятора</a></p>");
            out.println("</body></html>");
        }
    }

    private static String escape(String s) { return s == null ? "" : s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;"); }

    private static String reqContext(HttpServletResponse resp) {
        return "/servlets";
    }
}

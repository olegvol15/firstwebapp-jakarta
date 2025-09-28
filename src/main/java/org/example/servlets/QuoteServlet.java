package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String quote = "Bad programmers worry about the code. " +
                "Good programmers worry about data structures and their relationships";

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head><title>Quote</title></head><body>");
            out.println("<h1>Linus Torvalds Quote</h1>");
            out.println("<blockquote>" + quote + "</blockquote>");
            out.println("</body></html>");
        }
    }
}


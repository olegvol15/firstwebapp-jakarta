package org.example.laptops.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import org.example.laptops.repo.DataStore;

import java.io.IOException;

@WebServlet("/maker/news")
public class NewsServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("news", DataStore.getNews());
        req.getRequestDispatcher("/WEB-INF/views/news.jsp").forward(req, resp);
    }
}


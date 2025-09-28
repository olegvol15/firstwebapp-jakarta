package org.example.laptops.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import org.example.laptops.repo.DataStore;

import java.io.IOException;

@WebServlet("/maker")
public class HomeServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("m", DataStore.getManufacturer());
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }
}


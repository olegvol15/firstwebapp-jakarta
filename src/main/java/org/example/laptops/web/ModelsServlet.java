package org.example.laptops.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import org.example.laptops.repo.DataStore;

import java.io.IOException;

@WebServlet("/maker/models")
public class ModelsServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("models", DataStore.getModels());
        req.getRequestDispatcher("/WEB-INF/views/models.jsp").forward(req, resp);
    }
}


package org.example.laptops.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import org.example.laptops.models.LaptopModel;
import org.example.laptops.repo.DataStore;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/maker/model")
public class ModelDetailServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        Optional<LaptopModel> modelOpt = DataStore.findModel(id);
        if (modelOpt.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Model not found");
            return;
        }
        req.setAttribute("model", modelOpt.get());
        req.getRequestDispatcher("/WEB-INF/views/model-detail.jsp").forward(req, resp);
    }
}


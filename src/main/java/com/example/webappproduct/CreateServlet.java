package com.example.webappproduct;

import com.example.webappproduct.beens.Product;
import com.example.webappproduct.connectionDB.ProductDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            getServletContext()
                    .getRequestDispatcher("/create.jsp")
                    .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(name,price);
      int count = ProductDB.insert(product);
        request.setAttribute("product",product);
        response.sendRedirect(request.getContextPath()+ "/show");
    }
}

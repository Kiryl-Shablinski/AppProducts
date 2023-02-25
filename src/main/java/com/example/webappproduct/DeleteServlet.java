package com.example.webappproduct;

import com.example.webappproduct.beens.Product;
import com.example.webappproduct.connectionDB.ProductDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           int id = Integer.parseInt(request.getParameter("id"));
           Product product = ProductDB.selectOne(id);
           if (product != null) {
               ProductDB.delete(product);
               response.sendRedirect(request.getContextPath() + "/show");
           } else {
               getServletContext()
                       .getRequestDispatcher("/notFound.jsp")
                       .forward(request, response);
           }
       }catch (IOException o){
           getServletContext()
                   .getRequestDispatcher("/notFound.jsp")
                   .forward(request, response);
       }
    }
}

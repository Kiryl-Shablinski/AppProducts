package com.example.webappproduct;

import com.example.webappproduct.beens.Product;
import com.example.webappproduct.connectionDB.ProductDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           int id = Integer.parseInt(request.getParameter("id"));
           Product product = ProductDB.selectOne(id);
           if (product != null) {
               request.setAttribute("product", product);
               getServletContext()
                       .getRequestDispatcher("/edit.jsp")
                       .forward(request, response);
           } else {
               getServletContext()
                       .getRequestDispatcher("/notFound.jsp")
                       .forward(request, response);
           }
       }catch (Exception o){
           getServletContext()
                   .getRequestDispatcher("/notFound.jsp")
                   .forward(request, response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            Product product = new Product(id,name,price);
            ProductDB.update(product);
            response.sendRedirect(request.getContextPath() + "/show");
        }catch (Exception o){
            getServletContext()
                    .getRequestDispatcher("/notFound.jsp")
                    .forward(request,response);
        }
    }
}

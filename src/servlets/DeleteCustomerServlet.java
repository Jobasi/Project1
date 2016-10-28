package servlets;

import models.Customer;
import repositories.CustomerRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 13/10/2016.
 */
@WebServlet(name = "DeleteCustomerServlet", urlPatterns = {"/delete/*"})
public class DeleteCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1>Nice Try!!</h1>");
        printWriter.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = CustomerRepo.findCustomerById(Long.parseLong(request.getParameter("id")));
        CustomerRepo.delete(customer);
        response.sendRedirect("/customers.jsp");
    }
}

package servlets;

import helpers.Validation;
import models.Customer;
import patterns.CustomerBuilder;
import repositories.CustomerRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 07/10/2016.
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(Validation.validateEmail(request.getParameter("email"))){
                Customer customer = new CustomerBuilder(request.getParameter("first_name"), request.getParameter("last_name"))
                        .withPhone(Long.parseLong(request.getParameter("phone")))
                        .withEmail(request.getParameter("email"))
                        .build();
                CustomerRepo.save(customer);

                response.sendRedirect("/customers.jsp");
        } else {
            request.setAttribute("first_name", request.getParameter("first_name"));
            request.setAttribute("last_name", request.getParameter("last_name"));
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("phone", request.getParameter("phone"));
            request.setAttribute("error", "Please enter a valid email!!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/create.jsp");
            requestDispatcher.forward(request, response);


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/create.jsp");

    }

}

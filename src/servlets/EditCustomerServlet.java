package servlets;

import helpers.Validation;
import models.Customer;
import repositories.CustomerRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 12/10/2016.
 */
@WebServlet(name = "EditCustomerServlet", urlPatterns = {"/edit/*"})
public class EditCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        if(Validation.validateEmail(email)){
            Customer customer = CustomerRepo.findCustomerByEmail(email);

            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setPhoneNumber(Long.parseLong(phone));

            CustomerRepo.updateCustomer(customer);

            response.sendRedirect("/customers.jsp");
        } else {
            request.setAttribute("first_name", request.getParameter("first_name"));
            request.setAttribute("last_name", request.getParameter("last_name"));
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("phone", request.getParameter("phone"));
            request.setAttribute("error", "Please enter a valid email!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/create.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        Long customerId = Long.parseLong(pathInfo.substring(1));
        Customer customer = CustomerRepo.findCustomerById(customerId);

        request.setAttribute("first_name", customer.getFirstName());
        request.setAttribute("last_name", customer.getLastName());
        request.setAttribute("email", customer.getEmail());
        request.setAttribute("phone", customer.getPhoneNumber());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/edit.jsp");
        requestDispatcher.include(request, response);
    }

}

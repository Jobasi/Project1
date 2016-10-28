<%@ page import="repositories.CustomerRepo" %>
<%@ page import="java.io.IOException" %>
<%@ page import="models.Customer" %><%--
  Created by IntelliJ IDEA.
  User: nonso
  Date: 11/10/2016
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="bootstrap/base.jsp" />
    <title>Customers</title>

</head>
<body>
    <div class="container">
        <jsp:include page="bootstrap/nav.jsp" />
        <div class="row">
            <div class="col-lg-6">
                <ul class="list-unstyled">
                    <% for (Customer customer : CustomerRepo.fetchAllCustomers()){
                        try {
                            out.println("<li>"+customer.getFirstName()+", "+customer.getLastName()+"</li> " +"<span> <a role=\"button\" class=\"btn btn-info\" href=\"/edit/"+customer.getPersonId()+" \">Edit</a> <a role=\"button\" class=\"btn btn-danger\" href=\"/delete/customer?id="+customer.getPersonId()+" \">Delete</a></span>");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }%>
                </ul>
            </div>
            <div class="col-lg-3">
            </div>
            <div class="col-lg-3"></div>

        </div>

    </div>

</body>
</html>

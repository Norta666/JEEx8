package edu.nbcc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import edu.nbcc.user.*;

public class EmailServlet extends HttpServlet {

    int counter;

    public EmailServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException("GET not allowed");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String error = "";
        String url = "/index.jsp";

        if (request.getParameter("btnSubmit") != null) {
            try {

                String fName = request.getParameter("firstName");
                String lName = request.getParameter("lastName");
                String email = request.getParameter("emailAddress");

                IUser user = UserFactory.createInstance(fName, lName, email);

                if (!user.hasRequiredFields()) {
                    error = "All fields required";
                } else if (!user.isEmailValid()) {
                    error = "Invalid email";
                } else {
                    url = "/thanks.jsp";
                    counter++;
                    response.setContentType("text/html");
                    request.setAttribute("user", user);
                    request.setAttribute("counter", counter);
                }
            } catch (Exception ex) {
                error = ex.getMessage();
            }

            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            request.setAttribute("error", "Something went wrong");
        }
    }
}

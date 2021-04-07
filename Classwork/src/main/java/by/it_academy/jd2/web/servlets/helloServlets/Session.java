package by.it_academy.jd2.web.servlets.helloServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Session", urlPatterns = "/session")
public class Session extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String sessionFirstName = "First_Name";
        String sessionLastName = "Last_Name";

        HttpSession session = request.getSession();

        if (firstName != null && lastName != null) {

            session.setAttribute(sessionFirstName,firstName);
            session.setAttribute(sessionLastName,lastName);

            writer.println("Cookie is set for Both");
            writer.println("<p><span style='color: orange;'>Hello, " + lastName + " " + firstName + "!</span></p>");
        } else if (firstName == null && lastName != null ) {
            session.setAttribute(sessionLastName,lastName);
            writer.println("sess is set for lastName");
            writer.println("<p><span style='color: blue;'>Hello, " + lastName + " " + session.getAttribute(sessionFirstName) + "!</span></p>");

        } else if (lastName == null && firstName != null ) {
            session.setAttribute(sessionFirstName,firstName);
            writer.println("<p><span style='color: red;'>Hello, " + session.getAttribute(sessionLastName) + " " + firstName + "!</span></p>");
            writer.println("sess is set for firstName");

        } else {
            writer.println("No Data found");
        }
    }
}

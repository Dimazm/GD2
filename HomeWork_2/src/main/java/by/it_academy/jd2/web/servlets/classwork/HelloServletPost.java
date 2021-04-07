package by.it_academy.jd2.web.servlets.classwork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet(name = "HelloServletPost", urlPatterns = "/helloP")
    public class HelloServletPost extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            writer.write("<p><span style='color: Green;'>Hello, " + lastName + " " + firstName + "!</span></p>");
        }

    }

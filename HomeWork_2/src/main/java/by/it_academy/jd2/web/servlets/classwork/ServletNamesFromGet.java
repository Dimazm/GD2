package by.it_academy.jd2.web.servlets.classwork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletNamesFromGet", urlPatterns = "/names")
public class ServletNamesFromGet extends HttpServlet {
private String PARAM_NAME = "name";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.write("<p> Header" + request.getHeader("User-Agent") + "</p>");

        String[] req = request.getParameterMap().get(PARAM_NAME);
        if (req != null) {
            for (String names : req) {
                writer.write("<p><span style='color: green;'>" + names + "</span></p>");
            }
        } else writer.write("<p><span style='color: red;'" + "No Names in request" + "</span></p>");


    }

}

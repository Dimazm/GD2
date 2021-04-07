package by.it_academy.jd2.web.servlets.classwork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(name = "ServletNew", urlPatterns = "/print")

public class ServletNew extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Enumeration<String> params = req.getParameterNames();
        String[] values = req.getParameterValues("name");
        for (String val:values) {
            writer.println("Values is:" + val);
        }

        while (params.hasMoreElements()){
            String paramName = params.nextElement();
            writer.write("<p>"  + paramName + ": " + req.getParameter(paramName) + "</p>");
            writer.write("<p>" + params.nextElement() + "</p>");
        }

    }
}

package by.it_academy.jd2.web.servlets.classwork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PrintName", urlPatterns = "/print_v2")
public class PrintName extends HttpServlet {

    private String NAME_PARAMETER_HEADER = "ARRAY_NAME_PARAM";

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
      //  response.setHeader(NAME_PARAMETER_HEADER, "name");

        String header = request.getHeader(NAME_PARAMETER_HEADER);
        String[] names = request.getParameterMap().get(header);

        if (names != null) {
            for (String name : names) {
                writer.write("<p>" + header + ":" + name + "</p>");
            }
        }
    }
}

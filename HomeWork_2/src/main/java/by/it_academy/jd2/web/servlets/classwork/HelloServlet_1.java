package by.it_academy.jd2.web.servlets.classwork;

import by.it_academy.jd2.view.NameView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloServlet_1", urlPatterns = "/hello_1")
public class HelloServlet_1 extends HttpServlet {
    private NameView view = new NameView();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        view.addNames(name);
        if (name.equals("print")) {

            writer.println(view.getAll());
        } else {
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/names.jsp");
        }
    }

}

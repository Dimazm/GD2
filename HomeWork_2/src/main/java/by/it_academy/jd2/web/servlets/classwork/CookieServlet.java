package by.it_academy.jd2.web.servlets.classwork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "CookieServlet", urlPatterns = "/hello_C")

public class CookieServlet extends HttpServlet {
    private final static String FIRS_NAME_PARAM = "firstName";
    private final static String LAST_NAME_PARAM = "lastName";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter(FIRS_NAME_PARAM);
        String lastName = request.getParameter(LAST_NAME_PARAM);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Cookie myCookiesF = new Cookie(FIRS_NAME_PARAM, firstName);
        Cookie myCookiesL = new Cookie(LAST_NAME_PARAM, lastName);
        Cookie[] cookies = request.getCookies();
        myCookiesF.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        myCookiesL.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));


        if (firstName != null && lastName != null) {
            response.addCookie(myCookiesF);
            response.addCookie(myCookiesL);
            writer.println("Cookie is set for Both");
            writer.println("<p><span style='color: orange;'>Hello, " + lastName + " " + firstName + "!</span></p>");
        } else if (firstName == null && lastName != null && cookies != null) {
            for (Cookie c : cookies) {
                if (FIRS_NAME_PARAM.equals(c.getName())) {
                    response.addCookie(myCookiesL);
                    writer.println("Cookie is set for lastName");
                    writer.println("<p><span style='color: blue;'>Hello, " + lastName + " " + c.getValue() + "!</span></p>");
                }
            }
        } else if (lastName == null && firstName != null && cookies != null) {
            for (Cookie c : cookies) {
                if (LAST_NAME_PARAM.equals(c.getName())) {
                    response.addCookie(myCookiesF);
                    writer.println("Cookie is set for firstName");
                    writer.println("<p><span style='color: red;'>Hello, " + c.getValue() + " " + firstName + "!</span></p>");
                }
            }
        } else {
            writer.println("No Data found");
        }
    }


}


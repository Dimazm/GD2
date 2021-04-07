package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static by.it_academy.jd2.core.constants.ServletsConstants.*;

@WebServlet(name = "PersonaServlet", urlPatterns = "/persona")
public class PersonaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String header = request.getHeader(TYPE_OF_DATA);
        Person user = new Person("", "", "");
        String[] headerValues = request.getParameterMap().get(header);
        if (headerValues != null) {
            for (String value : headerValues) {
                if (value.equals(IS_COOKIE)) {
                    user.setFirstName(getCookiesValue(request, response, FIRST_NAME));
                    user.setSecondName(getCookiesValue(request, response, LAST_NAME));
                    user.setAge(getCookiesValue(request, response, AGE));
                    writer.println("Take from Cookies" + "</br>" + user);
                } else if (value.equals(IS_SESSION)) {
                    user.setFirstName(getSessionsValue(request, FIRST_NAME));
                    user.setSecondName(getSessionsValue(request, LAST_NAME));
                    user.setAge(getSessionsValue(request, AGE));
                    writer.println("Take from Session" + "</br>" + user);
                }
            }
        } else {
            throw new IllegalArgumentException("Please set param for header 'type' = cookie or session");
        }
    }

    public static String getCookiesValue(HttpServletRequest request, HttpServletResponse response, String param) {
        String value = request.getParameter(param);
        Cookie cookieValue = new Cookie(param, value);
        cookieValue.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));

        if (value == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                value = Arrays.stream(cookies)
                        .filter(c -> param.equalsIgnoreCase(c.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        } else {
            response.addCookie(cookieValue);
        }
        if (value == null) {
            throw new IllegalArgumentException("No Data found in cookies.\n Please set params for firstName, lastName, age");
        }
        return value;
    }

    public static String getSessionsValue(HttpServletRequest request, String param) {
        String value = request.getParameter(param);
        HttpSession session = request.getSession();
        if (value == null) {
            if (!session.isNew()) {
                value = (String) session.getAttribute(param);
            }
        } else {
            session.setAttribute(param, value);
        }
        if (value == null) {
            throw new IllegalArgumentException("No Data found in session. Please set params for firstName, lastName, age");
        }
        return value;
    }
}

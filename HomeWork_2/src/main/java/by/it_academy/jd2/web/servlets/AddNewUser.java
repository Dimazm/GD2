package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.PersonUser;
import by.it_academy.jd2.view.UsersView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.jd2.core.constants.MessengerConstants.*;

@WebServlet(name = "AddNewUser", urlPatterns = "/signUp")

public class AddNewUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        PersonUser user = new PersonUser();
        HttpSession session = request.getSession();
        user.setFirstName(getValueFromSession(request, FIRST_NAME));
        user.setLastName(getValueFromSession(request, LAST_NAME));
        user.setMiddleName(getValueFromSession(request, MIDDLE_NAME));
        user.setDateOfBirth(getValueFromSession(request, DATE_BIRTH));

        if (!request.getParameter(LOGIN_NAME).equals(session.getAttribute(LOGIN_NAME))) {
            user.setLogin(getValueFromSession(request, LOGIN_NAME));
            user.setPassword(getValueFromSession(request, PASSWORD));
        } else {
            throw new IllegalArgumentException("User with Name: " + request.getParameter(LOGIN_NAME) + " already exist!");
        }
        UsersView.addUser(user);
        session.setAttribute("users", UsersView.getUserList());
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/signIn.jsp");
    }

    public static String getValueFromSession(HttpServletRequest request, String param) {
        String value = request.getParameter(param);
        HttpSession session = request.getSession();
        if (value.isEmpty()) {
            if (!session.isNew()) {
                value = (String) session.getAttribute(param);
            }
        } else {
            session.setAttribute(param, value);
        }
        if (value == null) {
            throw new IllegalArgumentException("Please fill parameters");
        }
        return value;
    }
}

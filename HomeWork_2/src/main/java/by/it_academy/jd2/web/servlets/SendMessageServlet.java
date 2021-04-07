package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.PersonUser;
import by.it_academy.jd2.view.HistoryView;
import by.it_academy.jd2.view.UsersView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static by.it_academy.jd2.core.constants.MessengerConstants.*;

@WebServlet(name = "SendMessageServlet", urlPatterns = "/send")
public class SendMessageServlet extends HttpServlet {
    private final HistoryView history = new HistoryView();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        LocalDateTime time = LocalDateTime.now();

        String messageTime = time.format(DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss"));
        String loginName = (String)session.getAttribute("loginName");
        String usr = request.getParameter(USER_NAME);

        if (UsersView.getUser(usr) != null) {
            String message = request.getParameter(MESSAGE);
            history.addMessage(usr, loginName + " wrote: " + "\n"
                    + message + "   " + " | at time :" + messageTime);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/InChat");
        } else {
            writer.println("Wrong user name" + "\n" + "<p><a href=\"InChat\">Return</a></p>");
        }
    }
}
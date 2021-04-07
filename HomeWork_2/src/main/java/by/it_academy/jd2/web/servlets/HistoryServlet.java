package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.view.HistoryView;
import by.it_academy.jd2.view.UsersView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "HistoryServlet", urlPatterns = "/hist")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        LocalDateTime time = LocalDateTime.now();

        List<String> checkHistory = HistoryView.getUserHistory((String) session.getAttribute("loginName"));

        HistoryView.getListOfMessages(checkHistory, writer);


    }
}

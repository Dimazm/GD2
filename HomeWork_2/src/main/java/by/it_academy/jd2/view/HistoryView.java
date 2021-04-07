package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.PersonUser;
import org.apache.commons.lang3.ArrayUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryView {


    private static final Map<String, List<String>> history = new HashMap<>();

    public void addMessage(String loginName, String message) {
        if (history.get(loginName) == null) {
            List<String> listMessages = new ArrayList<>();
            listMessages.add(message);
            history.put(loginName, listMessages);
        } else
            history.get(loginName).add(message);
    }

    public static List<String> getUserHistory(String loginName) {
        return history.get(loginName);
    }

    public static void getListOfMessages(List<String> listOfMessages, PrintWriter writer) {
        if (listOfMessages != null) {
            for (String mes : listOfMessages) {
                writer.println("\n" + mes);
            }
        } else {
            writer.println("No History" + "\n" + "<p><a href=\"InChat\">Open Chat</a></p>");
        }
    }
}

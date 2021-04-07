package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.PersonUser;

import java.util.ArrayList;
import java.util.List;

public class UsersView {
    private static final List<PersonUser> userList = new ArrayList<>();

    public static void addUser(PersonUser userObject) {
        userList.add(userObject);
    }

    public static PersonUser getUser(String login) {
        for (PersonUser user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;

    }

    public static List<PersonUser> getUserList(){
        return userList;
    }
}

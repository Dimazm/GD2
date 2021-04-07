package by.it_academy.jd2.core;

import by.it_academy.jd2.view.NameView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {

        NameView view = new NameView();
        Scanner scanner = new Scanner(System.in);
        String next = null;
        System.out.println("Please inter the names");
        while (!(next = scanner.next()).equalsIgnoreCase("exit"))
        {
            view.addNames(next);
        }
        System.out.println(view.getAll());

    }
}

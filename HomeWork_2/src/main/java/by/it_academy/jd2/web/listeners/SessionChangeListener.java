package by.it_academy.jd2.web.listeners;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class SessionChangeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event){
        System.out.println("You have anew attribute: " + event.getName());
    }
}

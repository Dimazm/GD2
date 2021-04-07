package by.it_academy.jd2.core.dto;

import javax.swing.*;
import java.io.Serializable;
import java.text.DateFormat;

public class Person implements Serializable {
    private String firstName;
    private String secondName;
    private String age;


    public String getAge() {
        return age;
    }

    public Person(String firstName, String secondName, String age) {
        this.firstName = firstName;
        this.secondName = secondName;
           this.age = age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString(){
        return "The Person is : \n" +
                getFirstName() + " " +
                getSecondName() + " " +
                getAge() + " years old";
    }
}


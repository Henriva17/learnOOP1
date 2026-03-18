package com.henri;

import com.henri.model.Specialty;
import com.henri.model.User;

public class Application {
    public static void main(String[] args) {
        User studentA = new User();
        System.out.println(studentA.toString());
        User studentB = new User("john");
        System.out.println(studentB.toString());
        // int id, String name, String email, Specialty specialty
        User studentC = new User(001, "paul", "paul@).com", Specialty.MARKETING);
        System.out.println(studentC.toString());

        studentA.setName("Mike");
        studentA.setEmail("mike@.com");
        System.out.println(studentA.getName());
        System.out.println(studentA.getEmail());


    }
}

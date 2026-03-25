package com.henri;

import com.henri.model.User;
import com.henri.service.UserService;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("         INTERNSHIP PLATFORM ");
        System.out.println("====================================================");

        UserService userService = new UserService();
        User userAminaToSave = new User();
        userAminaToSave.setFullName("AMINA");
        userAminaToSave.setEmail("amina@gmail.com");
        userAminaToSave.setBirthDate(LocalDate.of(2002,1,1));

        userService.createNewUser(userAminaToSave);
        userService.createNewUser(userAminaToSave);

        System.out.println(userService.getAllUsers());


    }
}
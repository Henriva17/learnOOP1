package com.henri.service;

import com.henri.dao.UserDAO;
import com.henri.model.User;

import java.util.List;

/**
 * <blockquote><pre>
 * Author   : @Dountio
 * LinkedIn : @SidofDountio
 * GitHub   : @SidofDountio
 * Version  : V1.0
 * Email    : sidofdountio406@gmail.com
 * Since    : 3/25/26
 * </blockquote></pre>
 */


public class UserImplement{

    private final UserDAO userDAO ;

//    Constructor
    public UserImplement(UserDAO userDAO) {
        this.userDAO = userDAO ;
    }

    public User saveNewUser(User user) {
        System.out.println("Saving user");
        return this.userDAO.createNewUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }



}
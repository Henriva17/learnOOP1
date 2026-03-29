package com.henri.service;

import com.henri.dao.UserDAO;
import com.henri.model.User;

import java.util.List;
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
    public void deleteUser(User user) {
        System.out.println("Deleted existing user");
        userDAO.deleteUser(user);
    }
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
}
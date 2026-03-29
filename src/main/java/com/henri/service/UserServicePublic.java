package com.henri.service;

import com.henri.dao.UserDAO;
import com.henri.model.User;

import java.util.ArrayList;
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


public class UserServicePublic implements UserDAO {

    private List<User> USERLIST = new ArrayList<>();

    @Override
    public User createNewUser(User user) {
        USERLIST.add(user);
        return null;
    }

    @Override
    public void updateUser(User user) {


    }

    @Override
    public void deleteUser(User user) {


    }

    @Override
    public List<User> getAllUsers() {
       return USERLIST ;
    }
}

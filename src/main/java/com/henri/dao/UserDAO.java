package com.henri.dao;

import com.henri.model.User;

import java.util.List;

/**
 * <blockquote><pre>
 * Author   : @Dountio
 * LinkedIn : @SidofDountio
 * GitHub   : @SidofDountio
 * Version  : V1
 * Since    : 3/25/26
 * </blockquote></pre>
 */

public interface UserDAO {
   User  createNewUser(User user);
   void updateUser(User user);
   void deleteUser(User user);
   List<User> getAllUsers();
}

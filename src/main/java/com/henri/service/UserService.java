package com.henri.service;

import com.henri.dao.UserDAO;
import com.henri.enums.Role;
import com.henri.model.Company;
import com.henri.model.Student;
import com.henri.model.User;

import java.util.*;


public class UserService implements UserDAO {

    private final List<User> USER_LIST = new ArrayList<>();

    @Override
    public User createNewUser(User user) {
        for(User u : USER_LIST){
            if(user.getEmail().equals(u.getEmail())){
                System.out.println("Email already exist " + u.getEmail());
                return u;
            }
        }
        System.out.println("A new user with name " + user.getFullName() + " has been created");
        USER_LIST.add(user);
        return user;
    }
    // METHOD — replaces the User entry with a Student in the same list
    public Student promoteToStudent(User user, int studentId, String bio, String fieldOfStudy, String educationLevel,  int graduationYear, String university, Set<String> skills) {
        if (!USER_LIST.contains(user)) {
            throw new IllegalArgumentException("User not found in the system.");
        }
        int index = USER_LIST.indexOf(user);
        Student student = new Student(
                (int) user.getUserId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getLocation(),
                Role.STUDENT,
                studentId,
                bio,
                fieldOfStudy,
                educationLevel,
                graduationYear,
                university,
                new HashSet<>(skills));

        USER_LIST.set(index, student); // replace in the same slot
        System.out.println(user.getFullName() + " is now a Student.");
        return student;
    }

    public Company promoteToCompany(User user, int companyId, String description, String domain, String websiteLink, int companySize) {
        if (!USER_LIST.contains(user)) {
            throw new IllegalArgumentException("User not found in the system.");
        }

        int index = USER_LIST.indexOf(user);

        Company company = new Company(
                (int) user.getUserId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getLocation(),
                Role.COMPANY,
                companyId,
                description,
                domain,
                websiteLink,
                companySize

        );

        //private String websiteLink;
        //    private int companySize
        USER_LIST.set(index, company);
        System.out.println(user.getFullName() + " promoted to Company.");
        return company;
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < USER_LIST.size(); i++) {
            if (USER_LIST.get(i).getUserId() == user.getUserId()) {
                USER_LIST.set(i, user);
                System.out.println("User with name " + user.getFullName() + " has being updated");
                return;
            }
        }
        throw new IllegalArgumentException("User not found");
    }

    @Override
    public void deleteUser(User user) {

        System.out.println("User With name " + user.getFullName() + " has being deleted");
        USER_LIST.remove(user);
    }

    @Override
    public List<User> getAllUsers(){
        return USER_LIST;
    }
}

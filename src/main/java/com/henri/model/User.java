package com.henri.model;

import com.henri.enums.Role;
import com.henri.enums.Status;

import java.time.LocalDateTime;

public class User {
     private int userId;
     private String fullName;
     private String email;
     private String password;
     private String location;
     private String profilePicture;
     private  String linkedinLinkPage;
     private Role role;
     private Status status;
     private LocalDateTime createdAt;

    public User(){}
    public User(int userId, String fullName, String email, String password, String location, Role role ){
        if (fullName == null){
            throw new RuntimeException("Name required");
        }
        if (email == null || !email.contains("@")){
            throw new RuntimeException("Invalid email");
        }
        this.fullName = fullName;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.location = location;
        this.role = role;
        this.status = Status.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }
    // getters
    public int getUerId(){
         return userId;
    }
    public String getFullName(){
         return fullName;
    }
    public String getEmail(){
         return email;
    }
    public String getLocation(){
        return location;
    }
    public Role getRole(){
        return role;
    }
    public Status getStatus(){
        return status;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public String getprofilePicture(){
        return profilePicture;
    }
    public String getLinkedinProfileUrl(){
        return linkedinLinkPage;
    }
    // setters
    public void setFullName(String fullName){
         this.fullName = fullName;
    }
    public void setEmail(String email){
        this.email = email;
    }
   public void setLocation(String location){
        this.location =location;
   }
   public void setPassword(String password){
        this.password = password;
   }
    public void setprofilePicture(String profilePicture){
         this.profilePicture = profilePicture;
    }
    public void setProfilePicture(String profilePicture){
        this.profilePicture = profilePicture;
    }
    public void setLinkedinLinkPage(String linkedinLinkPage){
        this.linkedinLinkPage = linkedinLinkPage;
    }

    public  String toString(){
        return "User {id =" + userId + ", name = " + fullName + ", role = " + role + ", status=" + status + "}";
    }
}


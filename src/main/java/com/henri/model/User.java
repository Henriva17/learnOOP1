package com.henri.model;

public class User {
     private int id;
     private String name;
     private String email;
     private Specialty specialty;
     // about to create a constructor for User class
    // empty constructor must always be present
    public User(){

    }
    public User(String name){

        this.name = name;
    }
     public User(int id, String name, String email, Specialty specialty ){
         this.id = id;
         /*
         if(name == null) {
         throw new RuntimeException("Name must be Entered");
         }
         if(email.contains("@") || email == null){
             throw new RuntimeException("Email must be enterred and valid");
         }*/

         this.name = name;
         this.email = email;
         this.specialty = specialty;
     }
     public  String toString(){
         return "User {id =" + id + "name = " + name + "email = " + email + "speciality" + specialty;
     }

     // getters
    public  int getId(){
         return id;
    }
    public String getName(){
         return name;
    }
    public String getEmail(){
         return email;
    }
    public Specialty getSpecialty(){
         return specialty;
    }
    // setters
    public void setName(String uName ){
         name = uName;
    }
    public void setEmail(String uEmail){
         email = uEmail;
    }
}


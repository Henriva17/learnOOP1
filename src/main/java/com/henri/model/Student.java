package com.henri.model;

import com.henri.enums.Role;
import com.henri.enums.WorkMode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student extends User{

    private int studentId;
    private String fieldOfStudy;
    private String educationLevel;
    private int graduationYear;
    private String university; // still to discuss
    private String bio;         // still to discuss
    private Set<String> skills;
    private WorkMode workMode;
    private String githubLink;
    private String portfolioLink;
    private String cvFilePath;

    public Student(){
    }

    public Student(int userId, String fullName, String email, Role role, int studentId, String bio, HashSet<String> skills) {
        super(userId, fullName, email, role);
        this.studentId = studentId;
        this.bio = bio;
        this.skills = skills;
    }
    public Student(int userId, String fullName, String email, String password, String location, Role role, int studentId,String bio, String fieldOfStudy, String educationLevel, int graduationYear,
                   String university,HashSet<String> skills){

        super(userId, fullName, email, password, location, role);
        this.studentId = studentId;
        this.bio = bio;
        this.fieldOfStudy = fieldOfStudy;
        this.educationLevel = educationLevel;
        this.graduationYear = graduationYear;
        this.university = university;
        this.skills = skills;
    }




    public int getStudentId(){
        return studentId;
    }
    public String getFieldOfStudy(){
        return fieldOfStudy;
    }
    public String getEducationLevel(){
        return educationLevel;
    }
    public int getGraduationYear(){
        return graduationYear;
    }
    public String getUniversity(){
        return university;
    }
    public String getBio(){
        return bio;
    }
    public WorkMode getWorkMode(){return workMode;}
    public Set<String> getSkills(){
        return skills;
    }

    public WorkMode workMode(){
        return  workMode;
    }
    public String getGithubLink(){
        return githubLink;
    }
    public String getPortfolioLink(){
        return portfolioLink;
    }
    public String getCvFilePath(){
        return cvFilePath;
    }
    public void setBio( String bio){
        this.bio = bio;
    }
    public void setSkills(Set<String> skills){
        this.skills = skills;
    }
    public void setWorkMode(WorkMode workMode){
        this.workMode = workMode;
    }
    public void setGithubLink(String githubLink){
        this.githubLink = githubLink;
    }
    public void setPortfolioLink(String portfolioLink){
       this.portfolioLink = portfolioLink;
    }
    public void setCvFilePath(String cvFilePath){
       this.cvFilePath = cvFilePath;
    }


    @Override
    public String toString() {
        return "\n========== Student PROFILE ==========" +
                "\nStudent Id         : " + studentId +
                "\nFull Name         : " + getFullName() +
                "\nEmail             : " + getEmail() +
                "\nField Of Study    : " + (fieldOfStudy != null ? fieldOfStudy : "not specified") +
                "\nEducationLevel    : " + educationLevel +
                "\nGraduationYear    : " + graduationYear +
                "\nSkills            : " + (skills != null ? skills : "not specified") +
                "\nWorkMode          : " + (workMode != null ? workMode : "not specified") +
                "\nGithubLink        : " + (githubLink != null ? githubLink : "not specified") +
                "\nPortfolioLink     : " + portfolioLink +
                "\ncvFilePath        : " + cvFilePath +
                "\n==================================";
    }
}




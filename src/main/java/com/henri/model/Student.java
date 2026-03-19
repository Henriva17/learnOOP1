package com.henri.model;

import com.henri.enums.Role;
import com.henri.enums.WorkMode;

import java.util.List;

public class Student extends User{
    public int studentId;
    private String fieldOfStudy;
    private String educationLevel;
    private int graduationYear;
    private String university; // still to discuss
    private String bio;         // still to discuss
    private List<String> skills;
    private WorkMode workMode;
    private String githubLink;
    private String portfolioLink;
    private String cvFilePath;
    private String availability;
    public Student(){

    }
    public Student(int userId, String fullName, String email, String password, String location, Role role, int studentId, String fieldOfStudy, String educationLevel, int graduationYear,
                   String university){

        super(userId, fullName, email, password, location, role.STUDENT);
        this.studentId = studentId;
        this.fieldOfStudy = fieldOfStudy;
        this.educationLevel = educationLevel;
        this.graduationYear = graduationYear;
        this.university = university;
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
    public List<String> getSkills(){
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
    public String getAvailability(){
        return availability;
    }
    public void setBio( String bio){
        this.bio = bio;
    }
    public void setSkills(List<String> skills){
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
    public void setAvailability(String availability){
       this.availability = availability;
    }


    @Override
    public String toString() {
        return "Student{id=" + getStudentId() + ", name='" + getFullName() +
                "', university='" + university + "', field='" + fieldOfStudy + "'}";
    }



}

package com.henri.model;

import com.henri.enums.Role;
import com.henri.enums.WorkMode;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private long studentId;
    private String fieldOfStudy;
    private String educationLevel;
    private int graduationYear;
    private String university;
    private String bio;
    private List<String> skills;
    private WorkMode workMode;
    private String githubLink;
    private String portfolioLink;
    private String cvFilePath;

    public Student() {
        super();
        setRole(Role.STUDENT);
        this.skills = new ArrayList<>();
    }

    public Student(int userId, String fullName, String email, int studentId, String bio, List<String> skills) {
        super(userId, fullName, email, Role.STUDENT);
        validateStudentId(studentId);

        this.studentId = studentId;
        this.bio = bio;
        this.skills = skills != null ? new ArrayList<>(skills) : new ArrayList<>();
        setRole(Role.STUDENT);
    }

    public Student(int userId, String fullName, String email, String password, String location,
                   int studentId, String fieldOfStudy, String educationLevel,
                   int graduationYear, String university) {
        super(userId, fullName, email, password, location, Role.STUDENT);

        validateStudentId(studentId);
        validateFieldOfStudy(fieldOfStudy);
        validateEducationLevel(educationLevel);
        validateGraduationYear(graduationYear);
        validateUniversity(university);

        this.studentId = studentId;
        this.fieldOfStudy = fieldOfStudy.trim();
        this.educationLevel = educationLevel.trim();
        this.graduationYear = graduationYear;
        this.university = university.trim();
        this.skills = new ArrayList<>();
        setRole(Role.STUDENT);
    }

    private void validateStudentId(long studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student id must be greater than 0.");
        }
    }

    private void validateFieldOfStudy(String fieldOfStudy) {
        if (fieldOfStudy == null || fieldOfStudy.trim().isEmpty()) {
            throw new IllegalArgumentException("Field of study is required.");
        }
    }

    private void validateEducationLevel(String educationLevel) {
        if (educationLevel == null || educationLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("Education level is required.");
        }
    }

    private void validateGraduationYear(int graduationYear) {
        if (graduationYear < 2020 || graduationYear > 2100) {
            throw new IllegalArgumentException("Graduation year is not valid.");
        }
    }

    private void validateUniversity(String university) {
        if (university == null || university.trim().isEmpty()) {
            throw new IllegalArgumentException("University is required.");
        }
    }

    public long getStudentId() {
        return studentId;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String getUniversity() {
        return university;
    }

    public String getBio() {
        return bio;
    }

    public List<String> getSkills() {
        return skills;
    }

    public WorkMode getWorkMode() {
        return workMode;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public String getPortfolioLink() {
        return portfolioLink;
    }

    public String getCvFilePath() {
        return cvFilePath;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills != null ? new ArrayList<>(skills) : new ArrayList<>();
    }

    public void addSkill(String skill) {
        if (skill != null && !skill.trim().isEmpty()) {
            this.skills.add(skill.trim());
        }
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public void setPortfolioLink(String portfolioLink) {
        this.portfolioLink = portfolioLink;
    }

    public void setCvFilePath(String cvFilePath) {
        this.cvFilePath = cvFilePath;
    }

    @Override
    public String toString() {
        return "\n========= STUDENT PROFILE =========" +
                "\nStudent ID        : " + studentId +
                "\nUser ID           : " + getUserId() +
                "\nFull Name         : " + getFullName() +
                "\nEmail             : " + getEmail() +
                "\nLocation          : " + (getLocation() != null ? getLocation() : "not specified") +
                "\nRole              : " + getRole() +
                "\nStatus            : " + getStatus() +
                "\nUniversity        : " + (university != null ? university : "not specified") +
                "\nField of Study    : " + (fieldOfStudy != null ? fieldOfStudy : "not specified") +
                "\nEducation Level   : " + (educationLevel != null ? educationLevel : "not specified") +
                "\nGraduation Year   : " + (graduationYear != 0 ? graduationYear : "not specified") +
                "\nBio               : " + (bio != null ? bio : "not specified") +
                "\nSkills            : " + (skills != null && !skills.isEmpty() ? skills : "[]") +
                "\nWork Mode         : " + (workMode != null ? workMode : "not specified") +
                "\nGitHub            : " + (githubLink != null ? githubLink : "not specified") +
                "\nPortfolio         : " + (portfolioLink != null ? portfolioLink : "not specified") +
                "\nCV Path           : " + (cvFilePath != null ? cvFilePath : "not specified") +
                "\nCreated At        : " + getCreatedAt() +
                "\n===================================";
    }
}
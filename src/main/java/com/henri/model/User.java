package com.henri.model;

import com.henri.enums.Role;
import com.henri.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private long userId;
    private String fullName;
    private String email;
    private String password;
    private String location;
    private String profilePicture;
    private String linkedinLinkPage;
    private Role role;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDate birthDate;

    public User() {
        this.createdAt = LocalDateTime.now();
        this.status = Status.ACTIVE;
        this.role = Role.USER;
    }

    public User(int userId, String fullName, String email, Role role) {
        validateUserId(userId);
        validateFullName(fullName);
        validateEmail(email);
        validateRole(role);

        this.userId = userId;
        this.fullName = fullName;
        this.email = email.toLowerCase();
        this.role = role;
        this.status = Status.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public User(int userId, String fullName, String email,String password, String location, Role role) {
        validateUserId(userId);
        validateFullName(fullName);
        validateEmail(email);
        validatePassword(password);
        validateLocation(location);
        validateRole(role);

        this.userId = userId;
        this.fullName = fullName.trim();
        this.email = email.trim().toLowerCase();
        this.password = password;
        this.location = location.trim();
        this.role = role;
        this.status = Status.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    protected void validateUserId(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User id must be greater than 0.");
        }
    }

    protected void validateFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Full Name is required.");
        }
    }

    protected void validateEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
    }

    protected void validatePassword(String password) {
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("Password must contain at least 4 characters.");
        }
    }

    protected void validateLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location is required.");
        }
    }

    protected void validateRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role is required.");
        }
    }

    public long getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getLinkedinLinkPage() {
        return linkedinLinkPage;
    }

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setFullName(String fullName) {
        validateFullName(fullName);
        this.fullName = fullName.trim();
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email.trim().toLowerCase();
    }


    public void setLocation(String location) {
        validateLocation(location);
        this.location = location.trim();
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setLinkedinLinkPage(String linkedinLinkPage) {
        this.linkedinLinkPage = linkedinLinkPage;
    }

    public void setRole(Role role) {
        validateRole(role);
        this.role = role;
    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status is required.");
        }
        this.status = status;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isStudent() {
        return role == Role.STUDENT;
    }

    public boolean isCompany() {
        return role == Role.COMPANY;
    }

    public boolean isSimpleUser() {
        return role == Role.USER;
    }

    @Override
    public String toString() {
        return "\n========== USER PROFILE ==========" +
                "\nUser ID           : " + userId +
                "\nFull Name         : " + fullName +
                "\nEmail             : " + email +
                "\nLocation          : " + (location != null ? location : "not specified") +
                "\nRole              : " + role +
                "\nStatus            : " + status +
                "\nBirth Date        : " + (birthDate != null ? birthDate : "not specified") +
                "\nLinkedIn          : " + (linkedinLinkPage != null ? linkedinLinkPage : "not specified") +
                "\nProfile Picture   : " + (profilePicture != null ? profilePicture : "not specified") +
                "\nCreated At        : " + createdAt +
                "\n==================================";
    }
}
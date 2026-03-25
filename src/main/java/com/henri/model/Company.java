package com.henri.model;

import com.henri.enums.Role;

public class Company extends User {
    private long companyId;
    private String description;
    private String domainOfActivity;
    private String websiteLink;
    private int companySize;
    private String contactPersonName;
    private boolean verified;

    public Company() {
        super();
        setRole(Role.COMPANY);
        this.verified = false;
    }

    public Company(int userId, String fullName, String email, String password, String location,
                   int companyId, String description, String domainOfActivity) {
        super(userId, fullName, email, password, location, Role.COMPANY);

        validateCompanyId(companyId);
        validateDescription(description);
        validateDomainOfActivity(domainOfActivity);

        this.companyId = companyId;
        this.description = description.trim();
        this.domainOfActivity = domainOfActivity.trim();
        this.verified = false;
        setRole(Role.COMPANY);
    }

    private void validateCompanyId(int companyId) {
        if (companyId <= 0) {
            throw new IllegalArgumentException("Company id must be greater than 0.");
        }
    }


    private void validateDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Company description is required.");
        }
    }

    private void validateDomainOfActivity(String domainOfActivity) {
        if (domainOfActivity == null || domainOfActivity.trim().isEmpty()) {
            throw new IllegalArgumentException("Domain of activity is required.");
        }
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return getFullName();
    }

    public String getDescription() {
        return description;
    }

    public String getDomainOfActivity() {
        return domainOfActivity;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public int getCompanySize() {
        return companySize;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public boolean isVerified() {
        return verified;
    }


    public void setDescription(String description) {
        validateDescription(description);
        this.description = description.trim();
    }

    public void setDomainOfActivity(String domainOfActivity) {
        validateDomainOfActivity(domainOfActivity);
        this.domainOfActivity = domainOfActivity.trim();
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public void setCompanySize(int companySize) {
        if (companySize < 0) {
            throw new IllegalArgumentException("Company size cannot be negative.");
        }
        this.companySize = companySize;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "\n========= COMPANY PROFILE =========" +
                "\nCompany ID        : " + companyId +
                "\nUser ID           : " + getUserId() +
                "\nAccount Name      : " + getFullName() +
                "\nEmail             : " + getEmail() +
                "\nLocation          : " + (getLocation() != null ? getLocation() : "not specified") +
                "\nRole              : " + getRole() +
                "\nStatus            : " + getStatus() +
                "\nDomain            : " + (domainOfActivity != null ? domainOfActivity : "not specified") +
                "\nDescription       : " + (description != null ? description : "not specified") +
                "\nWebsite           : " + (websiteLink != null ? websiteLink : "not specified") +
                "\nCompany Size      : " + companySize +
                "\nContact Person    : " + (contactPersonName != null ? contactPersonName : "not specified") +
                "\nVerified          : " + verified +
                "\nCreated At        : " + getCreatedAt() +
                "\n===================================";
    }
}
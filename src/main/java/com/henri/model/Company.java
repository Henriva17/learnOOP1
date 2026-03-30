package com.henri.model;

import com.henri.enums.Role;

public class Company extends User{
    private  int companyId;
    private String description;
    private String domainOfActivity;
    private String websiteLink;
    private int companySize;
    private String contactPersonName;    // vraagje @sidof
    private boolean verified;
    public Company(){}
    public Company(int userId, String fullName, String email, String password, String location, Role role, int companyId, String description, String domainOfActivity,String websiteLink, int companySize) {
        super(userId, fullName, email, password, location, Role.COMPANY);
        this.companyId        = companyId;
        this.description      = description;
        this.domainOfActivity = domainOfActivity;
        this.websiteLink = websiteLink;
        this.companySize = companySize;
        this.verified         = false;
    }
    public int getCompanyId(){
        return companyId;
    }
    public String getDescription(){
        return description;
    }
    public String getDomainOfActivity(){
        return domainOfActivity;
    }
    public String getWebsiteLink(){
        return  websiteLink;
    }
    public int getCompanySize(){
        return companySize;
    }
    public String getContactPersonName(){
        return contactPersonName;
    }
    public boolean isVerified(){
        return verified;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public  void setDomainOfActivity(String domainOfActivity){
        this.domainOfActivity = domainOfActivity;
    }
    public void setWebsiteLink(String websiteLink){
        this.websiteLink = websiteLink;
    }
    public  void setCompanySize(int companySize){
        this.companySize = companySize;
    }
    public  void setContactPersonName(String contactPersonName){
        this.contactPersonName = contactPersonName;
    }
    public void setVerified(boolean verified){
        this.verified = verified;
    }
    @Override
    public String toString() {
        return "\n========== Company PROFILE ==========" +
                "\nCompany Id        : " + companyId +
                "\nFull Name         : " + getFullName() +
                "\nEmail             : " + getEmail() +
                "\nDomainOfActivity  : " + (domainOfActivity != null ? domainOfActivity : "not specified") +
                "\nVerified          : " + verified +
                "\nWebsiteLink       : " + websiteLink +
                "\nContactPersonName : " + (contactPersonName != null ? contactPersonName : "not specified") +
                "\nCompanySize       : " + companySize +
                "\n==================================";
    }
}

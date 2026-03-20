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
    public Company(int userId, String fullName, String email, String password, String location, Role role, int companyId, String companyName, String description, String domainOfActivity) {
        super(userId, fullName, email, password, location, Role.COMPANY);
        this.companyId        = companyId;
        this.description      = description;
        this.domainOfActivity = domainOfActivity;
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
        return "Company{id=" + companyId + ", name='" + getFullName() +
                "', domainOfActivity='" + domainOfActivity + "', verified=" + verified + "}";
    }
}

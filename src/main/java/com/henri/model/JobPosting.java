package com.henri.model;

import com.henri.enums.JobPostingStatus;
import com.henri.enums.JobType;
import com.henri.enums.WorkMode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class JobPosting {
    private int jobPostingId;
    private Company company;
    private String jobTitle;
    private String description;
    private JobType jobType;
    private WorkMode workMode;
    private String location; // location =>
    private List<String>requiredSkills;
    private String requiredEducationLevel;
    private LocalDate applicationDeadline;
    private JobPostingStatus jobPostingStatus;
    private LocalDateTime createdAt;

    public JobPosting(){

    }
    public JobPosting(int jobPostingId, Company company, String jobTitle,
                      String description, JobType jobType, WorkMode workMode,
                      String location, LocalDate applicationDeadline ){

        if (jobTitle == null) throw new RuntimeException("Job Title required");
        if (company == null)  throw new RuntimeException("Company required");
        if (applicationDeadline == null)  throw new RuntimeException("Deadline required");
        this.jobPostingId = jobPostingId;
        this.company = company;
        this.jobTitle = jobTitle;
        this.description = description;
        this.jobType = jobType;
        this.workMode = workMode;
        this.location = location;
        this.applicationDeadline = applicationDeadline;
        this.jobPostingStatus = JobPostingStatus.OPEN;
        this.createdAt = LocalDateTime.now();
    }
    public int getPostingId()               { return jobPostingId; }
    public Company getCompany()             { return company; }
    public String getJobTitle()             { return jobTitle; }
    public String getDescription()         { return description; }
    public JobType getJobType()            { return jobType; }
    public WorkMode getWorkMode()          { return workMode; }
    public String getLocation()            { return location; }
    public List<String> getRequiredSkills(){ return requiredSkills; }
    public LocalDate getDeadline()         { return applicationDeadline; }
    public JobPostingStatus getPostingStatus(){ return jobPostingStatus; }
    public LocalDateTime getCreatedAt()    { return createdAt; }

    public void setDescription(String description)          { this.description = description; }
    public void setRequiredSkills(List<String> skills)      { this.requiredSkills = skills; }
    public void setRequiredEducationLevel(String level)     { this.requiredEducationLevel = level; }
    public void setPostingStatus(JobPostingStatus postingStatus)      { this.jobPostingStatus = postingStatus; }
    public void setDeadline(LocalDate applicationDeadline)             { this.applicationDeadline = applicationDeadline; }

    public boolean isJobOpen(){
        return this.jobPostingStatus == JobPostingStatus.OPEN
                && LocalDate.now().isBefore(applicationDeadline);
    }

    @Override
    public String toString() {
        return "JobPosting{id=" + jobPostingId + ", title='" + jobTitle +
                "', company='" + company.getFullName() +
                "', status=" + jobPostingStatus + "}";
    }
}

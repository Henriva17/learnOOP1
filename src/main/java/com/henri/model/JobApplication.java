package com.henri.model;

import com.henri.enums.JobApplicationStatus;

import java.time.LocalDateTime;

public class JobApplication {
    private long jobApplicationId;
    private Student student;
    private JobPosting jobPosting;
    private String motivationalLetter;
    private JobApplicationStatus applicationStatus;
    private LocalDateTime appliedAt;
    private LocalDateTime updatedAt;
    public JobApplication(){

    }
    public JobApplication(int jobApplicationId,
                          Student student,
                          JobPosting jobPosting,
                          String motivationalLetter ){

        if (student == null)    throw new IllegalArgumentException("Student required");
        if (jobPosting == null) throw new IllegalArgumentException("JobPosting required");
        if (!jobPosting.isJobOpen()) throw new IllegalStateException("Cannot apply to a closed posting");
        this.jobApplicationId     = jobApplicationId;
        this.student           = student;
        this.jobPosting        = jobPosting;
        this.motivationalLetter = motivationalLetter;
        this.applicationStatus   = JobApplicationStatus.PENDING;
        this.appliedAt         = LocalDateTime.now();
        this.updatedAt         = LocalDateTime.now();
    }
    // getters
    public long getApplicationId()       { return jobApplicationId; }
    public Student getStudent()         { return student; }
    public JobPosting getJobPosting()   { return jobPosting; }
    public String getMotivationalLetter() { return motivationalLetter; }
    public JobApplicationStatus getApplicationStatus(){ return applicationStatus; }
    public LocalDateTime getAppliedAt() { return appliedAt; }

    //setters letters and App_status
    public void setStatus(JobApplicationStatus applicationStatus) {
        this.applicationStatus    = applicationStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public void setMotivationLetter(String motivationalLetter) {
        this.motivationalLetter = motivationalLetter;
    }

    // toString of id, student, title, status
    @Override
    public String toString() {
        return "Application{id=" + jobApplicationId +
                ", student='" + student.getFullName() +
                "', posting='" + jobPosting.getJobTitle() +
                "', status=" + applicationStatus + "}";
    }


}

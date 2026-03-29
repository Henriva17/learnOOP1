package com.henri.dao;

import com.henri.enums.JobApplicationStatus;
import com.henri.model.JobApplication;
import com.henri.model.JobPosting;
import com.henri.model.Student;

import java.util.List;

public interface JobApplicationDAO {
    JobApplication createJobApplication(JobApplication jobApplication);
    void updateJobApplication(JobApplication jobApplication);
    void deleteJobApplication(JobApplication jobApplication);
    List<JobApplication> getAllJobApplication();
    JobApplication findJobApplicationById(int jobApplicationId);
    List<JobApplication> findApplicationsByStudent(Student student);
    List<JobApplication> findJobApplicationByJobPosting(JobPosting Jobposting);
    List<JobApplication> findJobApplicationByApplicationStatus(JobApplicationStatus jobApplicationStatus);
}

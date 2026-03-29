package com.henri.dao;

import com.henri.enums.JobType;
import com.henri.enums.WorkMode;
import com.henri.model.Company;
import com.henri.model.JobPosting;

import java.util.List;

public interface JobPostingDAO {
    JobPosting createJobPosting(JobPosting jobPosting);
    void updateJobPosting(JobPosting jobPosting);
    void deleteJobPosting(JobPosting jobPosting);
    List<JobPosting> getAllJobPostings();
    JobPosting findJobPostingById(int jobPostingId);
    List<JobPosting> findOpenJobPostings();
    List<JobPosting> findJobPostingsByCompany(Company company);
    List<JobPosting> findJobPostingsByType(JobType jobType);
    List<JobPosting> findJobPostingsByWorkMode(WorkMode workMode);
}

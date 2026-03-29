package com.henri.service;

import com.henri.dao.JobPostingDAO;
import com.henri.enums.JobType;
import com.henri.enums.WorkMode;
import com.henri.model.Company;
import com.henri.model.JobApplication;
import com.henri.model.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class JobPostingService implements JobPostingDAO {
    private final List<JobPosting> JOBPOSTING_LIST = new ArrayList<>();
    @Override
    public JobPosting createJobPosting(JobPosting jobPosting){
        JOBPOSTING_LIST.add(jobPosting);
        System.out.println("Job post with title " + jobPosting.getJobTitle() + " has being created ");
        return  jobPosting;
    }
    @Override
    public  void updateJobPosting(JobPosting jobPosting){
        for(int i = 0; i < JOBPOSTING_LIST.size(); i++){
            if (JOBPOSTING_LIST.get(i).getJobPostingId() == jobPosting.getJobPostingId()){
                JOBPOSTING_LIST.set(i, jobPosting);
                System.out.println("Jobpost  with Title "+ jobPosting.getJobTitle() + " has being Updated");
                return;
            }
        }
        throw new RuntimeException("JobPost has not being founded");
    }
    @Override
    public void deleteJobPosting(JobPosting jobPosting){
        JOBPOSTING_LIST.remove(jobPosting);
        System.out.println("Jobpost with Title "+ jobPosting.getJobTitle() + " has being deleted");
    }
    @Override
    public List<JobPosting> getAllJobPostings(){
        return  new ArrayList<>(JOBPOSTING_LIST);
    }
    @Override
    public JobPosting findJobPostingById(int jobPostingId){
        return JOBPOSTING_LIST.stream()
                .filter(j -> j.getJobPostingId() == jobPostingId)
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<JobPosting> findOpenJobPostings(){
        List<JobPosting> output = new ArrayList<>();
        for (JobPosting j : JOBPOSTING_LIST){
            if (j.isJobOpen()) output.add(j);
        }
        return output;
    }
    @Override
    public List<JobPosting> findJobPostingsByCompany(Company company){
        List<JobPosting> output = new ArrayList<>();
        for (JobPosting j : JOBPOSTING_LIST){
            if (j.getCompany().getCompanyId() == company.getCompanyId()){
                output.add(j);
            }
        }
        return  output;

    }
    @Override
    public List<JobPosting> findJobPostingsByType(JobType jobType) {
        List<JobPosting> result = new ArrayList<>();
        for (JobPosting j : JOBPOSTING_LIST) {
            if (jobType.equals(j.getJobType())) result.add(j);
        }
        return result;
    }

    @Override
    public List<JobPosting> findJobPostingsByWorkMode(WorkMode workMode) {
        List<JobPosting> result = new ArrayList<>();
        for (JobPosting j : JOBPOSTING_LIST) {
            if (workMode.equals(j.getWorkMode())) result.add(j);
        }
        return result;
    }



}

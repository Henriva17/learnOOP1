package com.henri.service;

import com.henri.dao.JobApplicationDAO;
import com.henri.enums.JobApplicationStatus;
import com.henri.enums.JobPostingStatus;
import com.henri.model.JobApplication;
import com.henri.model.JobPosting;
import com.henri.model.Student;

import java.util.ArrayList;
import java.util.List;

public class JobApplicationService implements JobApplicationDAO {

    private final List<JobApplication> JOBAPPLICATION_LIST = new ArrayList<>();
    @Override
    public JobApplication createJobApplication (JobApplication jobApplication){
        for (JobApplication a : JOBAPPLICATION_LIST){
            if (a.getStudent().getStudentId() == jobApplication.getStudent().getStudentId() && a.getJobPosting().getJobPostingId() == jobApplication.getJobPosting().getJobPostingId()){
                System.out.println("Student with name " + a.getStudent().getFullName() + " already applied to this jobpost");
                return  a;

            }
        }
        JOBAPPLICATION_LIST.add(jobApplication);
        System.out.println("Your application was made " + jobApplication);
        return jobApplication;
    }
    @Override
    public void updateJobApplication(JobApplication jobApplication) {
        for (int i = 0; i < JOBAPPLICATION_LIST.size(); i++){
            if (JOBAPPLICATION_LIST.get(i).getApplicationId() == jobApplication.getApplicationId()){
                JOBAPPLICATION_LIST.set(i, jobApplication);
                System.out.println("Application updated: " + jobApplication);
                return;
            }
        }
        throw new RuntimeException("JobApplication does not exist");

    }

    @Override
    public void deleteJobApplication(JobApplication application) {
        JOBAPPLICATION_LIST.remove(application);
        System.out.println("Application has being deleted.");
    }

    @Override
    public List<JobApplication> getAllJobApplication() {
        return new ArrayList<>(JOBAPPLICATION_LIST);
    }

    @Override
    public JobApplication findJobApplicationById(int jobApplicationId) {
        return JOBAPPLICATION_LIST.stream()
                .filter(a -> a.getApplicationId() == jobApplicationId)
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<JobApplication> findApplicationsByStudent(Student student) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication a : JOBAPPLICATION_LIST) {
            if (a.getStudent().getStudentId() == student.getStudentId()) result.add(a);
        }
        return result;
    }

    @Override
    public List<JobApplication> findJobApplicationByJobPosting(JobPosting jobPosting) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication a : JOBAPPLICATION_LIST) {
            if (a.getJobPosting().getJobPostingId() == jobPosting.getJobPostingId()) result.add(a);
        }
        return result;
    }

    @Override
    public List<JobApplication> findJobApplicationByApplicationStatus(JobApplicationStatus status) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication a : JOBAPPLICATION_LIST) {
            if (status.equals(a.getApplicationStatus())) result.add(a);
        }
        return result;
    }
}

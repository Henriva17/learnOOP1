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

    private final List<JobApplication> JOBAPPLICATIO_LIST = new ArrayList<>();
    @Override
    public JobApplication createJobApplication (JobApplication jobApplication){
        for (JobApplication a : JOBAPPLICATIO_LIST){
            if (a.getStudent().getStudentId() == jobApplication.getStudent().getStudentId() && a.getJobPosting().getJobPostingId() == jobApplication.getJobPosting().getJobPostingId()){
                System.out.println("Student with name " + a.getStudent().getFullName() + " already applied to this jobpost");
                return  a;

            }
        }
    JOBAPPLICATIO_LIST.add(jobApplication);
        System.out.println("Your application was made " + jobApplication);
        return jobApplication;
    }
    @Override
    public void updateJobApplication(JobApplication jobApplication) {
        for (int i = 0; i < JOBAPPLICATIO_LIST.size(); i++){
            if (JOBAPPLICATIO_LIST.get(i).getApplicationId() == jobApplication.getApplicationId()){
                JOBAPPLICATIO_LIST.set(i, jobApplication);
                System.out.println("Application updated: " + jobApplication);
                return;
            }
        }
        throw new RuntimeException("JobApplication does not exist");

    }

    @Override
    public void deleteJobApplication(JobApplication application) {
        JOBAPPLICATIO_LIST.remove(application);
        System.out.println("Application has being deleted.");
    }

    @Override
    public List<JobApplication> getAllJobApplication() {
        return new ArrayList<>(JOBAPPLICATIO_LIST);
    }

    @Override
    public JobApplication findJobApplicationById(int jobApplicationId) {
        return JOBAPPLICATIO_LIST.stream()
                .filter(a -> a.getApplicationId() == jobApplicationId)
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<JobApplication> findApplicationsByStudent(Student student) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication a : JOBAPPLICATIO_LIST) {
            if (a.getStudent().getStudentId() == student.getStudentId()) result.add(a);
        }
        return result;
    }

    @Override
    public List<JobApplication> findJobApplicationByJobPosting(JobPosting jobPosting) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication a : JOBAPPLICATIO_LIST) {
            if (a.getJobPosting().getJobPostingId() == jobPosting.getJobPostingId()) result.add(a);
        }
        return result;
    }

    @Override
    public List<JobApplication> findJobApplicationByApplicationStatus(JobApplicationStatus status) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication a : JOBAPPLICATIO_LIST) {
            if (status.equals(a.getApplicationStatus())) result.add(a);
        }
        return result;
    }
}

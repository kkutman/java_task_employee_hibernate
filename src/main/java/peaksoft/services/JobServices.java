package peaksoft.services;

import peaksoft.models.Job;

import java.util.List;

/**
 * name : kutman
 **/
public interface JobServices {
    void createJobTable();
    void addJob(Job job);
    void dropJobTable();
    Job getJobById(Long jobId);
    List<Job> sortByExperience(String ascOrDesc);
    Job getJobByEmployeeId(Long employeeId);
    void deleteDescriptionColumn();
}

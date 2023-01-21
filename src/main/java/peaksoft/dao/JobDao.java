package peaksoft.dao;

import peaksoft.models.Job;

import java.util.List;

/**
 * name : kutman
 **/
public interface JobDao {
    void createJobTable();
    void dropJobTable();
    void addJob(Job job);
    Job getJobById(Long jobId);
    List<Job> sortByExperience(String ascOrDesc);
    Job getJobByEmployeeId(Long employeeId);
    void deleteDescriptionColumn();
}

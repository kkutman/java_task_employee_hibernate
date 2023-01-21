package peaksoft.services;

import peaksoft.dao.JobDaoImpl;
import peaksoft.models.Job;

import java.util.List;

/**
 * name : kutman
 **/
public class JobServicesImpl implements JobServices{
    JobDaoImpl jobDao = new JobDaoImpl();
    @Override
    public void createJobTable() {
        jobDao.createJobTable();
        System.out.println("createJobTable()");
    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);
        System.out.println("addJob(Job job)");
    }

    @Override
    public void dropJobTable() {
        jobDao.dropJobTable();
        System.out.println("dropJobTable()");
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobDao.getJobById(jobId);
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        return jobDao.sortByExperience(ascOrDesc);
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        return jobDao.getJobByEmployeeId(employeeId);
    }

    @Override
    public void deleteDescriptionColumn() {
        jobDao.deleteDescriptionColumn();
    }
}

package peaksoft.dao;

import peaksoft.config.Util;
import peaksoft.models.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * name : kutman
 **/
public class JobDaoImpl implements JobDao {
    private Connection connection = Util.getConnection();
    @Override
    public void createJobTable() {
        String sql = """
                create table job(
                id serial primary key,
                position varchar,
                profession varchar,
                description varchar,
                experience int);
                """;
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("true");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addJob(Job job) {
        String sql = """
                insert into job(position,profession,description,experience)
                values(?,?,?,?);
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,job.getPosition());
            preparedStatement.setString(2,job.getProfession());
            preparedStatement.setString(3,job.getDescription());
            preparedStatement.setInt(4,job.getExperience());
            preparedStatement.execute();
            System.out.println("true");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Job getJobById(Long jobId) {
        Job job;
        String sql = "select * from job where id ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,jobId);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                job = new Job(
                        resultSet.getLong("id"),
                        resultSet.getString("position"),
                        resultSet.getString("profession"),
                        resultSet.getString("description"),
                        resultSet.getInt("experience")
                );
                return job;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        List<Job>jobs = new ArrayList<>();
        String sql ;
        if(ascOrDesc.equalsIgnoreCase("asc")){
            sql = "select * from job order by experience asc ;";
        }else {
            sql = "select * from job order by experience desc ;";}
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                jobs.add(new Job(
                        resultSet.getLong("id"),
                        resultSet.getString("position"),
                        resultSet.getString("profession"),
                        resultSet.getString("description"),
                        resultSet.getInt("experience")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jobs;
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        Job job;
        String sql = "select * from job join employee e on job.id = e.jod_id where e.id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,employeeId);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                job = new Job(
                        resultSet.getLong("id"),
                        resultSet.getString("position"),
                        resultSet.getString("profession"),
                        resultSet.getString("description"),
                        resultSet.getInt("experience")
                );
                return job;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void dropJobTable() {
        String query = """
                drop table job cascade """;
        try {
            Statement statement  = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteDescriptionColumn() {
        String sql = "ALTER TABLE job DROP COLUMN description CASCADE;";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("yes");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

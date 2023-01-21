package peaksoft.dao;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Strings;
import peaksoft.models.Employee;
import peaksoft.models.Job;

import java.util.List;
import java.util.Map;

/**
 * name : kutman
 **/
public interface EmployeeDao {
    void createEmployee();
    void addEmployee(Employee employee);
    void dropTable();
    void cleanTable();
    void updateEmployee(Long id,Employee employee);
    List<Employee> getAllEmployees();
    Employee findByEmail(String email);
    Map<Employee, Job> getEmployeeById(Long employeeId);
    List<Employee> getEmployeeByPosition(String position);
}

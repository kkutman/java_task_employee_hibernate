package peaksoft.services;

import peaksoft.dao.EmployeeDaoImpl;
import peaksoft.models.Employee;
import peaksoft.models.Job;

import java.util.List;
import java.util.Map;

/**
 * name : kutman
 **/
public class EmployeeServicesImpl implements EmployeeServices{
    EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    @Override
    public void createEmployee() {
        employeeDao.createEmployee();
        System.out.println("createEmployee()");
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
        System.out.println("addEmployee(Employee employee)");
    }

    @Override
    public void dropTable() {
        employeeDao.dropTable();
        System.out.println("dropTable()");
    }

    @Override
    public void cleanTable() {
        employeeDao.cleanTable();
        System.out.println("cleanTable()");
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employeeDao.updateEmployee(id,employee);
        System.out.println("updateEmployee(Long id, Employee employee)");
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeDao.findByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return employeeDao.getEmployeeByPosition(position);
    }
}

package peaksoft;

import peaksoft.config.Util;
import peaksoft.dao.EmployeeDaoImpl;
import peaksoft.dao.JobDaoImpl;
import peaksoft.models.Employee;
import peaksoft.models.Job;
import peaksoft.services.EmployeeServicesImpl;
import peaksoft.services.JobServicesImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        EmployeeServicesImpl employeeServices = new EmployeeServicesImpl();
        JobServicesImpl jobServices = new JobServicesImpl();

        while (true){
            System.out.println("PRESS 1 EMPLOYEE");
            System.out.println("PRESS 2 JOB");
            switch (scanner.nextInt()) {
                case 1:
                System.out.println("""
                        PRESS 1 CREATE TABLE EMPLOYEE!
                        PRESS 2 DROP TABLE EMPLOYEE!
                        PRESS 3 ADD EMPLOYEE!
                        PRESS 4 CLEAN TABLE EMPLOYEE!
                        PRESS 5 UPDATE EMPLOYEE BY ID!
                        PRESS 6 GET ALL EMPLOYEE!
                        PRESS 7 FIND BY EMPLOYEE EMAIL!
                        PRESS 8 GET EMPLOYEE BY ID!
                        PRESS 9 GET EMPLOYEE BY POSITION!
                                            
                        """);
                switch (scanner.nextInt()) {
                    case 1:
                        employeeServices.createEmployee();
                        break;
                    case 2:
                        employeeServices.dropTable();
                        break;
                    case 3:
                        String l = scanner.nextLine();
                        // public Employee(String firstName, String lastName, int age, String email, int jobId) {
                        System.out.print("FIRST NAME : ");
                        String firstName = scanner.nextLine();
                        System.out.print("LAST NAME : ");
                        String lastName = scanner.nextLine();
                        System.out.print("AGE : ");
                        int age = scanner.nextInt();
                        System.out.print("EMAIL : ");
                        String email2ds = scanner.nextLine();
                        String email = scanner.nextLine();
                        System.out.print("JOB ID : ");
                        int jobId = scanner.nextInt();
                        employeeServices.addEmployee(new Employee(firstName, lastName, age, email, jobId));
                        break;
                    case 4:
                        employeeServices.cleanTable();
                        break;
                    case 5:
                        System.out.print("ID : ");
                        Long id = scanner.nextLong();
                        String d = scanner.nextLine();
                        System.out.print("FIRST NAME : ");
                        String firstName2 = scanner.nextLine();
                        System.out.print("LAST NAME : ");
                        String lastName2 = scanner.nextLine();
                        System.out.print("AGE : ");
                        int age3 = scanner.nextInt();
                        String dy = scanner.nextLine();
                        System.out.print("EMAIL : ");
                        String email2 = scanner.nextLine();
                        System.out.print("JOB ID : ");
                        int jobId2 = scanner.nextInt();
                        employeeServices.updateEmployee(id, new Employee(firstName2, lastName2, age3, email2, jobId2));
                        break;
                    case 6:
                        employeeServices.getAllEmployees().forEach(System.out::println);
                        break;
                    case 7:
                        System.out.print("EMAIL : ");
                        employeeServices.findByEmail(scanner.nextLine());
                        break;
                    case 8:
                        System.out.print("ID : ");
                        System.out.println(employeeServices.getEmployeeById(scanner.nextLong()));
                        break;
                    case 9:
                        System.out.print("POSITION : ");
                        employeeServices.getEmployeeByPosition(scanner.nextLine()).forEach(System.out::println);
                        break;
                    default:
                        System.err.println("1-9");
                }
                break;
                case 2:
                    System.out.println("""
                        PRESS 1 CREATE TABLE JOB!
                        PRESS 2 DROP TABLE JOB!
                        PRESS 3 ADD JOB!
                        PRESS 4 GET JOB BY ID!                     
                        PRESS 5 SORT JOB BY EXPERIENCE!
                        PRESS 6 GET JOB BY ID!
                        PRESS 7 DELETE DESCRIPTION COLUM JOB!
                               """);
                    switch (scanner.nextByte()){
                        case 1:
                            jobServices.createJobTable();
                            break;
                        case 2:
                            jobServices.dropJobTable();
                            break;
                        case 3:
                            String dd = scanner.nextLine();
                            System.out.print("POSITION : ");
                            String position = scanner.nextLine();
                            System.out.print("PROFESSION : ");
                            String profession = scanner.nextLine();
                            System.out.print("DESCRIPTION : ");
                            String description = scanner.nextLine();
                            System.out.print("EXPERIENCE : ");
                            int experience = scanner.nextInt();
                            jobServices.addJob(new Job(position,profession,description,experience));
                            break;
                        case 4:
                            System.out.print("ID : ");
                            System.out.println(jobServices.getJobById(scanner.nextLong()));
                            break;
                        case 5:
                            System.out.print("ASC OR DESC : ");
                            jobServices.sortByExperience(scanner.nextLine()).forEach(System.out::println);
                            break;
                        case 6:
                            System.out.print("ID : ");
                            System.out.println(jobServices.getJobByEmployeeId(scanner.nextLong()));
                            break;

                    }

            }

        }


    }
}

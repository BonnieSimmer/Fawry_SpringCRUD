package com.example.Springlab;

import com.example.Springlab.Entity.Employee;
import com.example.Springlab.Service.EmployeeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringLabApplication {

	public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.Springlab");
        context.refresh();

        EmployeeService employeeService = context.getBean(EmployeeService.class);


        System.out.println("Creating Employees...");
        employeeService.CreateEmployee("Nour", "ElHelw", "NourElhelw@outlook.com", 5000.0);
        employeeService.CreateEmployee("SomeOne", "Else", "SomeOneElse@gmail.com", 4200.0);
        employeeService.CreateEmployee( "Test", "User", "TestUser@yahoo.com" , 7500.0);

        System.out.println("Retrieving All Employees...");
        employeeService.getAllEmployees().forEach(Employee::printInfo);

        System.out.println("Deleting Employee by ID 1...");
        employeeService.DeleteEmployee(1L);

        System.out.println("Retrieving All Employees After Deletion...");
        employeeService.getAllEmployees().forEach(Employee::printInfo);

        System.out.println("Retrieving Only Employee by ID 2...");
        employeeService.GetEmployeeById(2L).printInfo();

        context.close();
	}

}

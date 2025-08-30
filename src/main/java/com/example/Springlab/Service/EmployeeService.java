package com.example.Springlab.Service;

import com.example.Springlab.Entity.Employee;
import com.example.Springlab.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    Long id_counter = 1L;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee CreateEmployee(String firstName, String lastName, String email, Double salary) {
        Employee employee = new Employee(id_counter++, firstName, lastName, email, salary);
        employeeRepo.save(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee GetEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public Employee UpdateEmployee(Long id, String firstName, String lastName, String email, Double salary) {
        Employee existingEmployee = employeeRepo.findById(id);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(firstName);
            existingEmployee.setLastName(lastName);
            existingEmployee.setEmail(email);
            existingEmployee.setSalary(salary);
            employeeRepo.save(existingEmployee);
            return existingEmployee;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public void DeleteEmployee(Long id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }


}

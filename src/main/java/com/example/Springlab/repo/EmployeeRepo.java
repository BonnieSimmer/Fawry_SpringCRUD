package com.example.Springlab.repo;

import com.example.Springlab.Entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepo {
    private List<Employee> employees;

    public EmployeeRepo() {
        this.employees = new ArrayList<>();
    }

    public void save(Employee employee) {
        if (employees.contains(employee)) {
            employees.set(employees.indexOf(employee), employee);
        } else {
            employees.add(employee);
        }
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Optional<Employee> findById(Long id) {
        return employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
    }

    public boolean existsById(Long id) {
        return employees.stream().anyMatch(emp -> emp.getId().equals(id));
    }

    public void deleteById(Long id) {
        employees.removeIf(emp -> emp.getId().equals(id));
    }
}

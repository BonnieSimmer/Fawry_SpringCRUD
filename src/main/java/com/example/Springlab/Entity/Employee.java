package com.example.Springlab.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;

    public void printInfo() {
        System.out.println("Employee ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email + ", Salary: " + salary);
    }
}

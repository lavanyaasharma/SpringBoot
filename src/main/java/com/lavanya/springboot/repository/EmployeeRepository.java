package com.lavanya.springboot.repository;

import com.lavanya.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
    //all Crud Database methods
}

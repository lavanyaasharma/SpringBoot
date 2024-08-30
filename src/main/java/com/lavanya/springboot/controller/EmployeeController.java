package com.lavanya.springboot.controller;

import com.lavanya.springboot.exception.ResourceNotFound;
import com.lavanya.springboot.model.Employee;
import com.lavanya.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //build read employee REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public Optional<Employee> getEmployeeById(@PathVariable long id){
        Optional<Employee> employee=employeeRepository.findById(id);
        return employeeRepository.findById(id);

    }

    //BUILD UPDATE employee REST API
    @PutMapping("{id}")
    public ResponseEntity<?> updateById(@PathVariable long id ,@RequestBody Employee employeeDetail) {
        Employee updateEmployee = employeeRepository.findById(id).orElse(null);
        if ( updateEmployee != null) {
            updateEmployee.setFirstName(employeeDetail.getFirstName() != null && !employeeDetail.getFirstName().equals("") ? employeeDetail.getFirstName() : updateEmployee.getFirstName());
            updateEmployee.setLastName(employeeDetail.getLastName() != null && !employeeDetail.getLastName().equals("") ? employeeDetail.getLastName() : updateEmployee.getLastName());
            updateEmployee.setEmailId(employeeDetail.getEmailId() != null && !employeeDetail.getEmailId().equals("") ? employeeDetail.getEmailId() : updateEmployee.getEmailId());
            employeeRepository.save( updateEmployee);
            return new ResponseEntity<>( updateEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee don't exist with id:"+ id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

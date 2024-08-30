package com.lavanya.springboot;

import com.lavanya.springboot.model.Employee;
import com.lavanya.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
    @Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		Employee employee1=new Employee();
		employee1.setFirstName("Ram");
		employee1.setLastName("Singh");
		employee1.setEmailId("Ram123@gmail.com");
		employeeRepository.save(employee1);

		Employee employee2=new Employee();
		employee2.setFirstName("Ritu");
		employee2.setLastName("Sharma");
		employee2.setEmailId("Ritu@gmail.com");
		employeeRepository.save(employee2);

	}
}

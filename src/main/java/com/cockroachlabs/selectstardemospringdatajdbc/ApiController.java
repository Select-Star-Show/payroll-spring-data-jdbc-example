package com.cockroachlabs.selectstardemospringdatajdbc;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	private final EmployeeRepository repository;

	public ApiController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/api/employees")
	List<Employee> findAll() {
		return repository.findAll();
	}

	@GetMapping("/api/employees/{id}")
	Employee findOne(@PathVariable UUID id) {
		return repository.findById(id) //
				.orElseThrow(() -> new EmployeeNotFound("Unable to find employee with UUID " + id));
	}

	@GetMapping("/api/employees/{role}")
	List<Employee> findByRole(@PathVariable String role) {
		return repository.findByRole(role);
	}

	@GetMapping("/api/employees/recent")
	List<Employee> findOldEmployees() {
		return repository.findRecentEmployees();
	}

	static class EmployeeNotFound extends RuntimeException {
		public EmployeeNotFound() {}

		public EmployeeNotFound(String message) {
			super(message);
		}

		public EmployeeNotFound(String message, Throwable cause) {
			super(message, cause);
		}

		public EmployeeNotFound(Throwable cause) {
			super(cause);
		}

		public EmployeeNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}
	}
}

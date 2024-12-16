package com.cockroachlabs.selectstardemospringdatajdbc;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepository extends ListCrudRepository<Employee, UUID> {

	List<Employee> findByRole(String role);

	@Query("SELECT * FROM employee AS OF SYSTEM TIME '-1m'")
	List<Employee> findRecentEmployees();
}

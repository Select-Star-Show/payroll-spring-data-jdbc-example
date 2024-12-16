package com.cockroachlabs.selectstardemospringdatajdbc;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Employee implements Persistable<UUID> {

	@Id private UUID id;
	private String name;
	private String role;

	@Transient private boolean isNew;

	private Employee() {
		this(null, null, null, true);
	}

	Employee(UUID id, String name, String role, boolean isNew) {

		this.id = id;
		this.name = name;
		this.role = role;
		this.isNew = true;
	}

	Employee(String name, String role) {
		this(UUID.randomUUID(), name, role, true);
	}

	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) && Objects.equals(name, employee.name)
				&& Objects.equals(role, employee.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, role);
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", role='" + role + '\'' + '}';
	}
}

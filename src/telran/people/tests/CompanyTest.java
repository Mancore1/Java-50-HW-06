package telran.people.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.people.Company;
import telran.people.Employee;

class CompanyTest {
	Company company;
	Employee[] employees = {new Employee(1, "John", 1980, "IT", 20000), new Employee(2, "Max", 1973, "IT", 35000), 
			new Employee(3, "Alex", 1985, "Manage", 5000), new Employee(4, "Cindi", 1990, "Sales", 17000)};

	@BeforeEach
	void setUp() throws Exception {
		company = new Company(employees);
	}

	@Test
	void getAllEmployees() {
		Employee[] expected = {new Employee(1, "John", 1980, "IT", 20000), new Employee(2, "Max", 1973, "IT", 35000), 
				new Employee(3, "Alex", 1985, "Manage", 5000), new Employee(4, "Cindi", 1990, "Sales", 17000)};
		assertArrayEquals(expected, company.getAllEmployees(Comparator.naturalOrder()));
	}
	
	@Test
	void getEmployeesByAge() {
		Employee[] expected = {new Employee(4, "Cindi", 1990, "Sales", 17000), new Employee(3, "Alex", 1985, "Manage", 5000),
				new Employee(1, "John", 1980, "IT", 20000), new Employee(2, "Max", 1973, "IT", 35000)};
		assertArrayEquals(expected, company.getEmployeesByAge(1980, 2000));
	}
	
	@Test
	void getEmployeesBySalary() {
		Employee[] expected = {new Employee(3, "Alex", 1985, "Manage", 5000), new Employee(4, "Cindi", 1990, "Sales", 17000),
				new Employee(1, "John", 1980, "IT", 20000), new Employee(2, "Max", 1973, "IT", 35000)};
		assertArrayEquals(expected, company.getEmployeesBySalary(0, Integer.MAX_VALUE));
	}
	
	@Test
	void getEmployeesByDepartment() {
		Employee[] expected = {new Employee(1, "John", 1980, "IT", 20000), new Employee(2, "Max", 1973, "IT", 35000),
				new Employee(3, "Alex", 1985, "Manage", 5000), new Employee(4, "Cindi", 1990, "Sales", 17000),};
		assertArrayEquals(expected, company.getEmployeesByDepartment("IT"));
	}
	
	@Test
	void addEmployee() {
		Employee[] expected1 = {new Employee(1, "John", 1980, "IT", 20000), new Employee(2, "Max", 1973, "IT", 35000), 
				new Employee(3, "Alex", 1985, "Manage", 5000), new Employee(4, "Cindi", 1990, "Sales", 17000),
				new Employee(5, "Margaret", 1974, "Logistic", 23000)};
		company.addEmployee(new Employee(5, "Margaret", 1974, "Logistic", 23000));
		assertArrayEquals(expected1, company.getAllEmployees(Comparator.naturalOrder()));
		Employee[] expected2 = {new Employee(1, "John", 1980, "IT", 20000), new Employee(2, "Max", 1973, "IT", 35000), 
				new Employee(3, "Alex", 1985, "Manage", 5000), new Employee(4, "Cindi", 1990, "Sales", 17000), 
				new Employee(5, "Margaret", 1974, "Logistic", 23000)};
		assertFalse(company.addEmployee(new Employee(3, "Viko", 1999, "Logistic", 31000)));
		assertArrayEquals(expected2, company.getAllEmployees(Comparator.naturalOrder()));
	}
	
	@Test
	void removeEmployeeIf() {
		Employee[] expected = {new Employee(3, "Alex", 1985, "Manage", 5000), new Employee(4, "Cindi", 1990, "Sales", 17000)};
		assertTrue(company.removeEmployeeIf(new QPredicate()));
		assertArrayEquals(expected, company.getAllEmployees(Comparator.naturalOrder()));
		
	}
	
	@Test
	void getEmployee() {
		Employee expected1 = company.getEmployee(2);
		int id = 2;
		assertEquals(id, expected1.getId());
		Employee expected2 = company.getEmployee(5);
		assertNull(expected2);
	}
}

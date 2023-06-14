package telran.people;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Company {
	private Employee[] employees;

	public Company(Employee[] employees) {
		this.employees = employees;
	}
	
	public Employee[] getAllEmployees(Comparator<Employee> comp) {
		Employee[] res = Arrays.copyOf(employees, employees.length);
		Arrays.sort(res, comp);
		return res;
	}
	
	public Employee[] getEmployeesByAge(int yearFrom, int yearTo) {
		Employee[] res = new Employee[employees.length];
		int index = 0;
		int currentYear = 2023;
		for (int i = 0; i < employees.length; i++) {
			if (yearFrom <= yearTo) {
				res[index++] = employees[i];
			}
		}
		res = Arrays.copyOf(res, index);
		Arrays.sort(res, (e1, e2) -> currentYear - e1.getBirthYear() - (currentYear - e2.getBirthYear()));
		return res;
	}
	
	public Employee[] getEmployeesBySalary(int salaryFrom, int salaryTo) {
		Employee[] res = new Employee[employees.length];
		int index = 0;
		for (int i = 0; i < employees.length; i++) {
			if (salaryFrom <= salaryTo) {
				res[index++] = employees[i];
			}
		}
		res = Arrays.copyOf(res, index);
		Arrays.sort(res, (e1, e2) -> e1.getSalary() - e2.getSalary());
		return res;
	}
	
	public Employee[] getEmployeesByDepartment(String department) {
		Employee[] res = new Employee[employees.length];
		int index = 0;
		for (int i = 0; i < employees.length; i++) {
			if (department != "null") {
				res[index++] = employees[i];
			}
		}
		res = Arrays.copyOf(res, index);
		Arrays.sort(res, (e1, e2) -> e1.getId() - e2.getId());
		return res;
	}
	
	public boolean addEmployee(Employee empl) {
		boolean notSameId = true;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == empl.getId()) {
				notSameId = false;
				break;
			}
		}			
		if (notSameId) {
			employees = Arrays.copyOf(employees, employees.length + 1);
			employees[employees.length - 1] = empl;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeEmployeeIf(Predicate<Employee> predicate) {
		int oldSize = employees.length;
		Employee[] temp = new Employee[oldSize];
		int index = 0;
		for (int i = 0; i < oldSize; i++) {
			if (!predicate.test(employees[i])) {
				temp[index++] = employees[i];
			}
		}
		employees = Arrays.copyOf(temp, index);
 		return oldSize > employees.length;
	}
	
	public Employee getEmployee(int id) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}
}

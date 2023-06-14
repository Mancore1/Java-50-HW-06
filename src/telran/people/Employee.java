package telran.people;

public class Employee implements Comparable<Employee> {
	private final int id;
	private final String name;
	private final int birthYear;
	private final String department;
	private final int salary;

	public Employee(int id, String name, int birthYear, String department, int salary) {
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.department = department;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}
	
	public boolean equals(Object emplObj) {
		Employee employee = (Employee) emplObj;
		return this.id == employee.id && this.name == employee.name && this.birthYear == employee.birthYear 
				&& this.department == employee.department && this.salary == employee.salary;
	}
	
	@Override
	public int compareTo(Employee empl) {
		if (this.id < empl.id) {
			return -1;
		} else if(this.id > empl.id) {
			return 1;
		} else {
		return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Employee id = " + id + ", name = " + name + ", birthYear = " + birthYear + ", department = " + department + ", salary = " + salary;
	}
}

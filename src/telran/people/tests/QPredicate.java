package telran.people.tests;

import java.util.function.Predicate;

import telran.people.Employee;

public class QPredicate implements Predicate<Employee> {

	@Override
	public boolean test(Employee empl) {
		return empl.getSalary() > 17000;
	}

}

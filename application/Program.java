package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Employee> employers = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		Integer quantityEmployees = sc.nextInt();

		for (int i = 1; i <= quantityEmployees; i++) {
			System.out.println();
			System.out.println("Employee #" + i);

			System.out.print("Id: ");
			Integer id = sc.nextInt();

			System.out.print("Name: ");
			sc.nextLine();
			String nameEmployee = sc.nextLine();

			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employee emp = new Employee(id, nameEmployee, salary);

			employers.add(emp);
		}

		System.out.println();
		System.out.println("------- Employees registered -------");
		for (Employee obj : employers) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.print("Enter the employee Id that will have salary increase: ");
		Integer idEmployee = sc.nextInt();

		Employee emp = employers.stream().filter(obj -> obj.getId() == idEmployee).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("This id does not exist");
			System.exit(0);
		} else {
			System.out.print("Enter the percentage: ");
			Double percentageIncrease = sc.nextDouble();
			emp.increaseSalary(percentageIncrease);
		}

		System.out.println();
		System.out.println("List of Employees:");
		for (Employee obj : employers) {
			System.out.println(obj);
		}

		sc.close();

	}

}

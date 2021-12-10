package application;

import java.util.Random;
import java.util.Scanner;

public class App {

	// available Departments
	static Department[] departments = {
			new Department("Development", 1, "Indien", "Bangalore"),
			new Department("Managment", 2, "England", "London"),
			new Department()
	};

	static int size = 2;
	static int index = 0;
	static Employee[] employees = new Employee[size];

	public static void main(String[] args) {
		application();
	}

	private static int generateID() {
		return new Random().nextInt(1000);
	}

	private static void application() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Bitte legen Sie einen Mitarbeiter an: ");
			System.out.println("Vorname: ");
			String firstname = scanner.nextLine();

			System.out.println("Nachname: ");
			String lastname = scanner.nextLine();

			System.out.println("In welcher Abteilung soll " + firstname + " " + lastname + " arbeiten?");
			System.out.println(
					"Drücken Sie d für Development, m für Management, oder eine beliebige andere Taste für eine Test-Abteilung.");

			Department department = getDepartment(scanner.nextLine());

			Employee employee = new Employee(firstname, lastname, generateID(), department);
			insertEmployee(employee);
			System.out.println("Sie haben folgenden Mitarbeiter angelegt: ");
			employee.print();

			System.out.println("Möchten Sie einen weiteren Mitarbeiter anlegen?");
			System.out.println("x für beenden. Beliebige Taste für weiter");

			if (scanner.nextLine().equalsIgnoreCase("x")) {
				System.out.println("Sie haben folgende Mitarbeiter angelegt: ");

				for (int i = 0; employees[i] != null; i++) {
					employees[i].print();
				}
				return;
			}

		} while (true);
	}

	private static Department getDepartment(String input) {
		switch (input) {
			case "d":
				return departments[0];

			case "m":
				return departments[1];

			default:
				return departments[2];
		}
	}

	private static void insertEmployee(Employee employee) {
		if (index > size - 1) {
			doubleArray();
		}
		employees[index++] = employee;
	}

	private static void doubleArray() {
		Employee[] copy = employees;
		// double the size
		size *= 2; // size = size * 2;
		employees = new Employee[size]; // new empty Employee array with double size

		// copy the employees in the new array
		int index = 0;
		for (Employee e : copy) {
			employees[index++] = e;
		}
	}
}

package model;

import java.util.Random;
import java.util.Scanner;

public class App {
	private static int size = 5;
	private static Employee[] employees = new Employee[size];
	private static int index = 0;

	private static int createID() {
		// 123 is the default id
		int id = new Random().nextInt(1000);
		if (id == 123) {
			id++;
		}
		return id;
	}

	private static void application() {
		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Bitte legen Sie einen Mitarbeiter an: ");
			System.out.println("Vorname: ");
			String firstname = s.nextLine();

			System.out.println("Nachname: ");
			String lastname = s.nextLine();

			System.out.println("In welcher Abteilung soll \t" + firstname + "\t" + lastname + "\t arbeiten?");
			System.out.println(
					"Drücken Sie d für Development, m für Management, oder eine beliebige Taste für eine Test-Abteilung");
			String dept = s.nextLine();
			Department department;

			if (dept.equalsIgnoreCase("d")) {
				department = new Department("Development", 1, "Indien", "Bangalore");
			} else if (dept.equalsIgnoreCase("m")) {
				department = new Department("Management", 2, "England", "London");
			} else {
				System.out.println("Eine Test-Abteilung wurde angelegt");
				department = new Department();
			}

			Employee employee = new Employee(firstname, lastname, createID(), department);
			toArray(employee);

			System.out.println("Sie haben folgenden Mitarbeiter angelegt: ");
			employee.print();

			System.out.println("Möchten Sie einen weiteren Mitarbeiter anlegen?");
			System.out.println("x für beenden. Beliebige Taste für weiter");

			if (s.nextLine().equalsIgnoreCase("x")) {
				System.out.println("Folgende Mitarbeiter wurden angelegt");
				for (int i = 0; employees[i] != null; i++) {
					System.out.println(employees[i].id + "\t" + employees[i].firstname + "\t" + employees[i].lastname);
				}
				System.out.println("Auf Wiedersehen");
				return;
			}

		} while (true);
	}

	private static void toArray(Employee e) {
		if (employees.length -1 >= index) {
			doubleArraySize();
		}
		employees[index++] = e;
	}

	private static void doubleArraySize() {
		Employee[] copy = employees;
		// double the size
		size *= 2; // size = size * 2
		employees = new Employee[size];

		// copy the employees
		int i = 0;
		for (Employee e : copy) {
			employees[i++] = e;
		}
	}

	public static void main(String[] args) {
		application();
	}
}

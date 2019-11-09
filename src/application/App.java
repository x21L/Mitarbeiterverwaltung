package application;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Department dept = new Department("Development", 2, "Germany", "Berlin");
		Department dept2 = new Department();

		Employee e = new Employee();
		Employee e2 = new Employee("Lukas", "Wais", createID(), dept);
//		Employee e3 = new Employee("Hans", "Bürger", createID(), dept);
		
//		System.out.println(Department.linz);
//		System.out.println("dept: " + dept.city);
//		System.out.println("dept2: " + dept2.city);
		
		System.out.println(e.dept.name);

//		e.print();
//		e2.print();
//		e3.print();

//		System.out.println(e.isEquals(e2));
//		System.out.println(e2.isEquals(e3));

//		application();

	}

	private static int createID() {

		return new Random().nextInt(1000);

	}

	private static void application() {

		boolean close = false;
		Scanner s = new Scanner(System.in);

		Department dept;
		String deptName;
		int deptId = createID();
		String deptCountry;
		String deptCity;

		Employee emp;
		String empFirstName;
		String empLasttName;
		int empId = createID();

		String again;

		do {
			System.out.println("Bitte legen Sie eine Abteilung an: ");
			System.out.print("Name ");
			deptName = s.nextLine();

			System.out.print("Land ");
			deptCountry = s.nextLine();

			System.out.print("Stadt ");
			deptCity = s.nextLine();

			dept = new Department(deptName, deptId, deptCountry, deptCity);

			System.out.println("Bitte legen Sie einen Mitarbeiter an:");
			System.out.print("Vorname ");
			empFirstName = s.nextLine();

			System.out.print("Nachname ");
			empLasttName = s.nextLine();

			System.out.print("Stadt ");
			deptCity = s.nextLine();

			emp = new Employee(empFirstName, empLasttName, empId, dept);

			System.out.println("Sie haben folgenden Mitarbeiter angelegt:");
			System.out.println();
			emp.print();

			System.out.println("Möchten Sie noch einen Mitarbeiter anlegen?");
			System.out.println("j für ja und n für beenden");
			again = s.nextLine();

			if (again.equals("j")) {
				
				close = true;
				
			} else if (again.equals("n")) {
				
				close = false;
				System.out.println("Auf Wiedersehen!");
				return;
				
			} else {
				System.out.println("Falsche Taste!! Probieren Sie es noch einmal");
				again = s.nextLine();
			}

		} while (close == false);
		
	}

}

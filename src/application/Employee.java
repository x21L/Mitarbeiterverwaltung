package application;

public class Employee {

	String firstname;
	String lastname;
	int id;
	Department dept;

	public Employee(String firstname, String lastname, int id, Department dept) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.dept = dept;
	}

	public Employee() {
		this("Max", "Mustermann", 123, new Department());
	}

	public void print() {
		System.out.println("Der Mitarbeiter " + id + " " + firstname + " " + lastname + " arbeitet in der Abteilung "
				+ dept.name + " in " + dept.city);
	}

	public boolean isEquals(Employee other) {
		return this.id == other.id;
	}

}

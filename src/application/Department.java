package application;

public class Department {

	String name;
	int deptno;
	String country;
	String city;

	public Department(String name, int deptno, String country, String city) {
		this.name = name;
		this.deptno = deptno;
		this.country = country;
		this.city = city;
	}

	public Department() {
		this("Test", 123, "Neverland", "Gotham");
	}

	public boolean isEquals(Department other) {
		return this.deptno == other.deptno;
	}
}

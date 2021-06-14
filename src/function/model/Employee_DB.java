package function.model;

public class Employee_DB {
	private int employee_id;
	private String employee_name;
	private String job_id;
	private String phone_number;
	private String positions;
	private int duty_hours;
	private String email;
	private int salary;
	
	
	public Employee_DB(int employee_id, String employee_name, String job_id,
			String phone_number, String positions, int duty_hours, String email,   int salary) {
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.job_id = job_id;
		this.phone_number = phone_number;
		this.positions = positions;
		this.duty_hours = duty_hours;
		this.email = email;
		this.salary = salary;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}




	public String getEmployee_name() {
		return employee_name;
	}




	public String getJob_id() {
		return job_id;
	}



	public String getPhone_number() {
		return phone_number;
	}


	public String getPositions() {
		return positions;
	}



	public int getDuty_hours() {
		return duty_hours;
	}



	public String getEmail() {
		return email;
	}



	public int getSalary() {
		return salary;
	}



}

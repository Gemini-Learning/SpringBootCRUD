package demo.service;

import java.util.List;

import demo.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAll();
	
	public Employee getById(long empId);
	
	
	public void getDeleteById(long empId);
	
}

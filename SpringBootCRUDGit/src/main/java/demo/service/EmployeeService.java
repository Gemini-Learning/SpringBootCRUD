package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Employee;
import demo.exception.EmptyInputException;
import demo.repository.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	
	@Autowired
	private EmployeeCrudRepo empCrudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		
		if(employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new EmptyInputException("600","Input Fields are Epmpty") ;
		}
		Employee savedEmp = empCrudRepo.save(employee);
		return savedEmp;
	}

	@Override
	public List<Employee> getAll() {
		ArrayList<Employee> listEmp = (ArrayList<Employee>) empCrudRepo.findAll();
		return listEmp;
	}

	@Override
	public Employee getById(long empId) {
		Employee emp =  empCrudRepo.findById(empId).get();
		return emp;
	}

	@Override
	public void getDeleteById(long empId) {
		empCrudRepo.deleteById(empId);
		return;
		
	}
	
	
}

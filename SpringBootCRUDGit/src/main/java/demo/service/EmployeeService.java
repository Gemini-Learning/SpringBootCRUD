package demo.service;

import java.util.ArrayList;  
import java.util.List;
import java.util.NoSuchElementException;

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
		
		if(employee.getName().isEmpty() || employee.getName().length() == 0 ||
				employee.getDept().isEmpty() || employee.getDept().length() == 0)
		{
			throw new EmptyInputException("600","Input Fields are Epmpty") ;
		}
		Employee savedEmp = empCrudRepo.save(employee);
		return savedEmp;
	}

	@Override
	public List<Employee> getAll() {
	return empCrudRepo.findAll();
		
	}

	@Override
	public Employee getById(long empId) {
		Employee emp =  empCrudRepo.findById(empId).orElseThrow( NoSuchElementException::new);
		return emp;
	}

	@Override
	public void getDeleteById(long empId) {
		empCrudRepo.deleteById(empId);
		return;
		
	}
	
	
}

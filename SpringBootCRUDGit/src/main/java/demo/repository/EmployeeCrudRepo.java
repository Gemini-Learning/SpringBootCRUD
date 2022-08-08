package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entity.Employee;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Long>{
	
	

}

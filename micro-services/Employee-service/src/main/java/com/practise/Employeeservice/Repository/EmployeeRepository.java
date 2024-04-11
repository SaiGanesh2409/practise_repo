package com.practise.Employeeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practise.Employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}

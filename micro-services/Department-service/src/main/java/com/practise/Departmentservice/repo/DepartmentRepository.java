package com.practise.Departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.Departmentservice.dto.DepartmentDto;
import com.practise.Departmentservice.entity.Department;
import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByDepartmentCode(String departmentCode);

}

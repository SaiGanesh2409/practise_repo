package com.practise.Employeeservice.serviceimpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practise.Employeeservice.dto.DepartmentDto;

@FeignClient (name="DEPARTMENT-SERVICE")
public interface APIClient {
	
	@GetMapping("api/departments/{departmentCode}")
	public DepartmentDto getDepartment(@PathVariable("departmentCode") String departmentCode);

}

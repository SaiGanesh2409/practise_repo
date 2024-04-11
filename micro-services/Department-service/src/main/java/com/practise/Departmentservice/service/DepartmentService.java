package com.practise.Departmentservice.service;

import com.practise.Departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentCode(String departmentCode);

}

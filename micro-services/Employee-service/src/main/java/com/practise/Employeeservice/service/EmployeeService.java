package com.practise.Employeeservice.service;

import com.practise.Employeeservice.dto.ApiResponseDto;
import com.practise.Employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	ApiResponseDto getEmployeeById(long id);

}

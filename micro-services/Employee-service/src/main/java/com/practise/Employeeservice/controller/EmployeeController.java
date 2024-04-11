package com.practise.Employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.Employeeservice.dto.ApiResponseDto;
import com.practise.Employeeservice.dto.EmployeeDto;
import com.practise.Employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		
		return new ResponseEntity<EmployeeDto>(savedEmployee,HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getAllEmployee(@PathVariable("id") long id){
		ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
		return new ResponseEntity<ApiResponseDto>(apiResponseDto,HttpStatus.OK);
	}
}

package com.practise.Employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;

}

package com.practise.Employeeservice.serviceimpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.practise.Employeeservice.Repository.EmployeeRepository;
import com.practise.Employeeservice.dto.ApiResponseDto;
import com.practise.Employeeservice.dto.DepartmentDto;
import com.practise.Employeeservice.dto.EmployeeDto;
import com.practise.Employeeservice.entity.Employee;
import com.practise.Employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

//	private RestTemplate restTemplate;
	
	//private WebClient webClient;

	private  APIClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		// converting dto to entity

		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail(), employeeDto.getDepartmentCode());
		Employee savedEmployee = employeeRepository.save(employee);

		// converting entity to Dto

		EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode());

		return savedEmployeeDto;

	}

	@Override
	public ApiResponseDto getEmployeeById(long id) {

		Employee employee = employeeRepository.findById(id).get();

		/*
		 * ResponseEntity<DepartmentDto> responseEntity =
		 * restTemplate.getForEntity("http://localhost:8080/api/departments/" +
		 * employee.getDepartmentCode(), DepartmentDto.class);
		 * 
		 * DepartmentDto departmentDto = responseEntity.getBody();
		 */
		
		/*
		 * DepartmentDto departmentDto =
		 * webClient.get().uri("http://localhost:8080/api/departments/"+employee.
		 * getDepartmentCode())
		 * .retrieve().bodyToFlux(DepartmentDto.class).blockFirst();
		 */
		
		DepartmentDto departmentDto= apiClient.getDepartment(employee.getDepartmentCode());
		
		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartmentCode());

		ApiResponseDto apiResponseDto = new ApiResponseDto();
				apiResponseDto.setEmployeeDto(employeeDto);
				apiResponseDto.setDepartmentDto(departmentDto);
				
		
		return apiResponseDto;

	}

}

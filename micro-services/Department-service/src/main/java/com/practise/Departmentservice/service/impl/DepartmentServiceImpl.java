package com.practise.Departmentservice.service.impl;

import org.springframework.stereotype.Service;

import com.practise.Departmentservice.dto.DepartmentDto;
import com.practise.Departmentservice.entity.Department;
import com.practise.Departmentservice.repo.DepartmentRepository;
import com.practise.Departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		// converting the dto to entity

		Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

		Department savedDepartment = departmentRepository.save(department);

		// converting the entity to dto

		DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(),
				savedDepartment.getDepartmentName(), savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode());

		return savedDepartmentDto;

	}

	@Override
	public DepartmentDto getDepartmentCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode);

		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());
		
		return departmentDto;

	}

}

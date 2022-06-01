package com.adj.amgmt.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.dto.EmployeeDTO;
import com.adj.amgmt.entity.Employee;
import com.adj.amgmt.repository.EmployeeRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class EmployeeServiceImpl implements EmployeeService {
//	@Autowired
//	EmployeeRepositoryImpl employeeRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper modelMapper;

	public void addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employeeRepository.saveAndFlush(employee);
	}

	public List<EmployeeDTO> getEmployeeList() {
		List<Employee> employeeList = employeeRepository.findAll();
//		List<EmployeeDTO> employeeListDTO = Arrays.asList(modelMapper.map(employeeList, EmployeeDTO.class));
		
		List<EmployeeDTO> employeeListDTO = modelMapper.map(employeeList,
				((TypeToken<List<EmployeeDTO>>) new TypeToken<List<EmployeeDTO>>() {
				}).getType());
		
		return employeeListDTO;
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);
	}

	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

	public EmployeeDTO getEmployeeById(int empId) {
		Employee employee = employeeRepository.getById(empId);
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}

}

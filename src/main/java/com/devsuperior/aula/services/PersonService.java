package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
		Person entity = new Person();
		
		entity.setSalary(dto.getSalary());
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		Department dep = departmentRepository
				.getReferenceById(dto.getDepartment().getId()); // To return Department name in JSON
		
//		Department dep = new Department(); // Return just Department ID
//		dep.setId(dto.getDepartment().getId());
		
		entity.setDepartment(dep);
		
		entity = repository.save(entity);
		return new PersonDepartmentDTO(entity);
	}
	
	public PersonDTO insert(PersonDTO dto) {
		Person entity = new Person();
		
		entity.setSalary(dto.getSalary());
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
//		Department dep = departmentRepository
//				.getReferenceById(dto.getDepartmentId()); // To return Department name in JSON
		
		Department dep = new Department(); // Return just Department ID
		dep.setId(dto.getDepartmentId());
		
		entity.setDepartment(dep);
		
		entity = repository.save(entity);
		return new PersonDTO(entity);
	}
	
}

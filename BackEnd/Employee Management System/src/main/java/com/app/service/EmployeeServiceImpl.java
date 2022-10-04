package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.EmployeeRepository;
import com.app.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmpDetails() {
		System.out.println("emp repo "+empRepo.getClass());
		return empRepo.findAll();
	}

	@Override
	public Employee addEmp(Employee transientEmp) {
		System.out.println("emp repo "+empRepo.getClass());
		return empRepo.save(transientEmp);
	}//returns DETACHED emp instance to the caller

	@Override
	public String deleteEmp(long empId) {
		System.out.println("emp repo "+empRepo.getClass());
		empRepo.deleteById(empId);
		return "Emp details deleted for emp id "+empId;
	}

	@Override
	public Employee getEmpDetailById(long empId) {
		// TODO Auto-generated method stub
		return empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp Id "+empId));
	}

	@Override
	public Employee updateEmpDetails(Employee detachedEmp) {
		// TODO Auto-generated method stub
		if(empRepo.existsById(detachedEmp.getId()))
			return empRepo.save(detachedEmp);
		throw new ResourceNotFoundException("Invalid Emp Id : Updation failed : Id "+detachedEmp.getId());
	}

}

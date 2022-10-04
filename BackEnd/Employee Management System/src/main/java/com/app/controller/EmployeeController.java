package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Employee;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(originPatterns = "http://localhost:3000/")
public class EmployeeController {
	@Autowired
	private IEmployeeService empService;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctor of " + getClass());
	}

	// add REST API endpoint to return list of all emps
	@GetMapping
	public List<Employee> listEmployees() {
		System.out.println("in list emp");
		return empService.getAllEmpDetails();
	}

	// add REST API endpoint to add emp details (create new resource)
	@PostMapping
	public ResponseEntity<?> addEmpDetails(@RequestBody Employee transientEmp) {
		System.out.println("in add details " + transientEmp);
		try {
			// invoke service layer method
			return new ResponseEntity<>(empService.addEmp(transientEmp), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("err in add emp " + e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	// add REST API endpoint to delete emp details
	@DeleteMapping("/{empId}")
	public ResponseEntity<?> deleteEmpDetails(@PathVariable long empId) {
		System.out.println("in delete emp " + empId);
		try {
			// invoke service layer method
			return ResponseEntity.ok(new ApiResponse(empService.deleteEmp(empId)));
		} catch (RuntimeException e) {
			System.out.println("err in del emp " + e);
			return new ResponseEntity<>(new ApiResponse("Invalid Emp Id...."), HttpStatus.NOT_FOUND);
		}
	}

	// add REST api endpoint to get existing emp details
	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmpDetails(@PathVariable long empId) {
		System.out.println("in get emp details using Id " + empId);
		try {
			// invoke service layer method
			return ResponseEntity.ok(empService.getEmpDetailById(empId));
		} catch (RuntimeException e) {
			System.out.println("err in get existing emp details " + e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	// add REST api endpoint to update existing emp details
	@PutMapping
	public ResponseEntity<?> updateEmpDetails(@RequestBody Employee detachedEmp) {
		System.out.println("in update emp details " + detachedEmp);
		try {
			// invoke service layer method
			return ResponseEntity.ok(empService.updateEmpDetails(detachedEmp));
		} catch (RuntimeException e) {
			System.out.println("err in del emp " + e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
}

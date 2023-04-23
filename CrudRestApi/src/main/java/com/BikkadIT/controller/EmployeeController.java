package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeServiceI;
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value="/addEmployee",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Integer> addEmployee(@RequestBody Employee employee) {
		Integer id = employeeServiceI.saveEmployee(employee);
		
		return new ResponseEntity<Integer>(id,HttpStatus.OK);

}  
	

	@GetMapping(value="/getAllEmployee",produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployee(){
	
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		
	}
	@PostMapping(value="/addAllEmployee",consumes = "application/json",produces = "application/json")
	public ResponseEntity<List<String>> addAllEmployee(@RequestBody List <Employee>employee) {
		List<Employee> id = employeeServiceI.saveAllEmployee(employee);
	
		return new ResponseEntity<List<String>>(HttpStatus.OK);

}  
	
	@GetMapping(value="/getEmployeeById/{id}", produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		 Employee employee = employeeServiceI.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		

	
}
	  @GetMapping(value="/findAllEmployee/{age}",produces="apllication/json")
      public ResponseEntity<List<Employee>>findByAgeLessThanEqual(@PathVariable int empAge ) {
		  List<Employee> allEmployee=employeeServiceI.findByAgeLessThanEqual(empAge);
		if(allEmployee!=null) {
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		}
		  return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.NO_CONTENT);
		
	
	} 
	  @PutMapping(value="/updateEmployee",consumes = "application/json",produces = "application/json")
		public ResponseEntity<Employee> Update(@RequestBody Employee employee) {
			Employee id = employeeServiceI.update(employee);
			
			return new ResponseEntity<Employee>(id,HttpStatus.OK);

	}  
	  @PutMapping(value="/updateAllEmployee",consumes = "application/json",produces = "application/json")
		public ResponseEntity<List<Employee>> updateAllEmployee(@RequestBody List <Employee>employee) {
			List<Employee> id = employeeServiceI.updateAll(employee);
		
			return new ResponseEntity<List<Employee>>(id,HttpStatus.OK);

}    
	  @DeleteMapping(value="/deleteEmployee",consumes = "application/json",produces = "application/json")
public ResponseEntity<Employee> deleteEmployee(@RequestBody int employee) {
	Employee id = employeeServiceI.delete(employee);
	
	return new ResponseEntity<Employee>(id,HttpStatus.OK);

	  }  
	  @DeleteMapping(value="/deleteAllEmployee",consumes = "application/json",produces = "application/json")
	  public ResponseEntity<Employee> deleteAllEmployee(@RequestBody int employee) {
	  	 employeeServiceI.deleteAll();
	  	
	  	return new ResponseEntity<Employee>(HttpStatus.OK);

	  }}
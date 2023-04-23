package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Employee;

public interface EmployeeServiceI {
	public Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public List<Employee> saveAllEmployee(List<Employee> employee);
	public Employee getEmployeeById(int empid);
    public List<Employee> findByAgeLessThanEqual(int empage);
    public Employee update(Employee employee);
	public List<Employee> updateAll(List<Employee> employee);
	public Employee loginCheck(String name, int age);
    public Employee delete(int empId);
   	public void deleteAll();
	
}

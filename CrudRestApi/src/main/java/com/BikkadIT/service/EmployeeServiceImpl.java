package com.BikkadIT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.model.Employee;

import com.BikkadIT.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
   
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Integer saveEmployee(Employee employee) {
   Employee  save= employeeRepository.save(employee);
		
		return save.getEmpId();

	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	
	}

	
	@Override
	public List<Employee> saveAllEmployee(List<Employee> employee) {
	   List<Employee> saveAll = employeeRepository.saveAll(employee);
		
		return saveAll;
		
	}

	@Override
	public Employee getEmployeeById(int empid) {
		Employee employee=employeeRepository.findById(empid).get();
		return employee;
	
	}

	@Override
	public List<Employee> findByAgeLessThanEqual(int empage) {
		  List<Employee> findByAgeLessThan = employeeRepository.findByAgeLessThanEqual(18);
	      return findByAgeLessThan;
	}

	@Override
	public Employee update(Employee employee) {
		List<Employee> employee1=employeeRepository.findAll();
		Predicate<Employee> p=emp->emp.getEmpId()==employee.getEmpId();
		for(Employee emp:employee1) {
			if(p.test(emp)) {
				Employee employee2=employeeRepository.save(employee);
				return employee2;
				
			}
		}
		
		return null;
	}

	@Override
	public List<Employee> updateAll(List<Employee> employee) {
		List<Employee> all=employeeRepository.findAll();
		List<Employee> list=new ArrayList<>();
		for(Employee e:all) {
			for(Employee e1:employee) {
				if(e.getEmpId()==e1.getEmpId()) {
					Employee employee1=employeeRepository.save(e1);
					list.add(employee1);
					
				}
			}
		}
		return list;
	}

	@Override
	public Employee loginCheck(String name, int empId) {
		Employee employee =employeeRepository.findEmpNameAndEmpId(name,empId);
		return employee;
	}

	@Override
	public Employee delete(int empid) {
		Employee employee=employeeRepository.findById(empid).get();
		if(employee !=null) {
			employeeRepository.deleteById(empid);
			return employee;
		}
		return employee;
	}

	@Override
	public void deleteAll() {
		employeeRepository.deleteAll();

	
	}

}

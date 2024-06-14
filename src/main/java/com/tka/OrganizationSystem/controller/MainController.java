package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {
	
	
	@Autowired
	MainService service;

	@PostMapping("addcountry")
	public String addcountry(@RequestBody Country c) {
		//System.out.println(c);
		
		
	     String msg= service.addcountry(c);
	     return msg;
	     
	}
	@PutMapping("updatecountry/{id}")
	public String updatecountry(@PathVariable int id,@RequestBody Country c) {
		String msg=service.updatecountry(id,c);
		return msg;
	}
	
	@DeleteMapping("deletecountry/{id}")
	public String deletecountry(@PathVariable int id) {
		 String msg=service.deletecountry(id);
		 return msg;
	}
	
	@GetMapping("getallrecord")
	public List<Country> getAllRecord() {
	List<Country>list=service.getAllRecord();
	return list;
	}
	
	@PostMapping("addemp")
	public String addEmployee(@RequestBody Employee emp) {
		String msg=service.addEmployee(emp);
		return msg;
	}
	
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp) {
		
		String msg=service.updateEmployee(emp);
		return msg;
	}
	
	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg=service.deleteEmployee(id);
		return msg;
	}
	@GetMapping("getallemp")
	public List<Employee>getAllEmployee(){
		
		List<Employee> list=service.gettAllEmployee();
		return list;
	}
	
	@GetMapping("getempbyid/{id}")
	public Employee getPartById(@PathVariable int id) {
		Employee emp= service.getpartById(id);
		return emp;
		
	}
	
	
	@GetMapping("getemplbystatus/{status}")
	public List<Employee>getEmployeeByStatus(@PathVariable String status){
		  List<Employee>list =service.getEmployeeByStatus(status);
		  return list;
		
	}
	
	@PostMapping("login")
	public HashMap loginCheck(@RequestBody Employee emp) {
	System.out.println(emp);
		HashMap map = service.loginCheck(emp);
		return map;
	}
	@GetMapping("empsalary/{salary}")
	public List<Employee> getEmpSalary(@PathVariable String  salary) {
		System.out.println(salary);
		List<Employee>list=service.getEmpSalary(salary);
	   return list;
}
	
	
	
	
	
}

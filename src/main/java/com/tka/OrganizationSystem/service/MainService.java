package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;
	
	
public String addcountry(Country c) {
	String msg=dao.addcountry(c);
	
	if(Objects.isNull(msg)) {
		msg="Country is not addedd...";
	}
	return msg;
}


public String updatecountry(int id, Country c) {
	// TODO Auto-generated method stub
	String msg=dao.updatecountry(id,c);
	if(Objects.isNull(msg)) {
		msg="Country is not Updated..";
	}
	return msg;
}


public String deletecountry(int id) {
	// TODO Auto-generated method stub
	String msg=dao.deletecountry(id);
	if(Objects.isNull(msg)) {
		msg="Country is not deleted";
	}
	return msg;
}

public List<Country> getAllRecord() {
	// TODO Auto-generated method stub
	List<Country>list=dao.getAllRecord();
	return list;
}


//public String addEmployee(Employee emp) {
//	// TODO Auto-generated method stub
//	String msg=dao.addEmployee(emp);
//	if(Objects.isNull(msg)) {
//		msg="Record is not added";
//	}
//	retrun msg;
	
//}


public String addEmployee(Employee emp) {
	
	// TODO Auto-generated method stub
	
	String msg=dao.addEmployee(emp);
     if(Objects.isNull(msg)) {
    	 msg="Record is not added";
     }
	return msg;
}




public String updateEmployee(Employee emp) {
	// TODO Auto-generated method stub
	String msg=dao.updatEmployee(emp);
	if(Objects.isNull(msg))msg="Record is not be Upadted";
	return msg;
	
}

public String deleteEmployee(int id) {
	// TODO Auto-generated method stub
	String msg=dao.deleteEmployee(id);
	if(Objects.isNull(msg)) {
		msg="Record is not Deleted";
	}
	
	return msg;
}


public List<Employee> gettAllEmployee() {

	// TODO Auto-generated method stub
	List<Employee> list=dao.getAllEmployee();
	if(Objects.isNull(list)) {
		list=null;
	}
	return null;
}




public Employee getpartById(int id) {
	// TODO Auto-generated method stub
	Employee emp=dao.getpartById(id);
	if(Objects.isNull(emp)) {
		emp=null;
}
	return emp;
	
}


public List<Employee> getEmployeeByStatus(String status) {
	// TODO Auto-generated method stub
	
	List<Employee>list=dao.getEmployeeByStatus(status);
	
	
	return list;
}


public HashMap loginCheck(Employee emp) {
	
	Employee e=dao.loginCheck(emp);
	
	HashMap map=new HashMap();
	
	if(Objects.isNull(e)) {
		map.put("msg","Invalid user");
		map.put("user", e);
	}else {
		map.put("msg","valid user");
		map.put("user", e);

	}
	return map;
}


public List<Employee> getEmpSalary(String salary) {
	// TODO Auto-generated method stub
	List<Employee> list =dao.getEmpSalary(salary);	
	   if(Objects.isNull(list)) {
			list=null;
		}
	return list;
}




}

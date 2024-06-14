package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addcountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		
		session.persist(c);
		tx.commit();
		msg="Country is Added...";
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session!=null) {
				session.close();
			}
			
		}
		return msg;
	}

	public String updatecountry(int id, Country c) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx = null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class,id);
			//country.setCname(c.g());
			session.merge(country);
			tx.commit();
			
			msg="Country is Updated..";
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
		
	}

	public String deletecountry(int id) {
		// TODO Auto-generated method stub
		Session session= null;
		Transaction tx = null;
		String msg=null;
		
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Country c =session.get(Country.class,id);
		
		session.remove(c);
		tx.commit();
		
		msg="Record Deleted Successfullyy...";
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Country> getAllRecord() {
		// TODO Auto-generated method stub
		String  hqlQuery ="from Person";
		
		Session session = null;
		Transaction tx=null;
		
		
		try {
			session=factory.openSession();
	         tx=session.beginTransaction();
	         
	         Query<Country> query=session.createQuery(hqlQuery,Country.class);
	         List<Country>list=query.list();
	         
	        tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		List<Country> list = null;
		return list;
	}



	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
            session=factory.openSession();
            tx=session.beginTransaction();
            
            session.persist(emp);
            tx.commit();
            
            msg="Employee Addedd Sucessfully";
            
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	

	public String updatEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx=null;
		String msg = null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
	        Employee employee=session.get(Employee.class,emp.getId());
			
	        
	        employee.setName(emp.getName());
	        employee.setPhoneno(emp.getPhoneno());
	        employee.setCountry(emp.getCountry());
	        employee.setCreatedby(emp.getCreatedby());
	        employee.setCreateddtm(emp.getCreateddtm());
	        employee.setUpdatedby(emp.getUpdatedby());
	        employee.setUpdateddtm(emp.getUpdateddtm());
	        employee.setDepartment(emp.getDepartment());
	        employee.setSalary(emp.getSalary());
	        employee.setStatus(emp.getStatus());
	       employee.setEmailid(emp.getEmailid());
	       
	       session.merge(employee);
	       tx.commit();
	       msg="Employee Updated Sucessfully...";
	        
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	
	}

	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		
		try {
			session=factory.openSession();
			tx=session.getTransaction();
			
			Employee emp=session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg="Employee is Deleted...";
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee";
		
		
		try {
			session=factory.openSession();
			tx=session.getTransaction();
			
			Query<Employee>query=session.createQuery(hqlQuery,Employee.class);
			
			list=query.list();
			tx.commit();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;

	}

	public Employee getpartById(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx=null;
		Employee emp=null;
		
		try {
			session=factory.openSession();
			tx=session.getTransaction();
			
			emp=session.get(Employee.class,id);
			tx.commit();
		}
			catch (Exception e) {
				// TODO: handle exception
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return emp;
	}

	public List<Employee> getEmployeeByStatus(String status) {
		Session session = null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where status=:mystatus";
		
	
		try {
			session=factory.openSession();
			tx=session.getTransaction();
			
			Query<Employee>query=session.createQuery(hqlQuery,Employee.class);
			
			query.setParameter("mystatus", status);
			
			
			
			list=query.list();
			tx.commit();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Employee loginCheck(Employee emp) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx=null;
		Employee employee=null;
		
	    String hqlQuery="from Employee where emailid=:myemailid and phoneno=:myphoneno";
	    try {
	    	session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee>query=session.createQuery(hqlQuery,Employee.class);
		   
			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphoneno", emp.getPhoneno());
            
			employee=  query.uniqueResult();
	    	
			
	        tx.commit();
	    
	    } catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
			finally {
				if(session!=null) {
					session.close();
				}
			}
			return employee;
		}

	

	

	public List<Employee> getEmpSalary(String salary) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx=null;
		String hqlQuery="from Employee salary > :mysalary";
		List<Employee>list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
		    query.setParameter("mysalary",salary);
		    list=query.list();
		    tx.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}

	
	}


	
	
	


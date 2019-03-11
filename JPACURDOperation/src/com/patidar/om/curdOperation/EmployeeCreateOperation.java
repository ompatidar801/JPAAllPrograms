package com.patidar.om.curdOperation;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeCreateOperation 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPACURDOperation" );
	
	static Scanner sc = new Scanner(System.in);
	
	public static void saveEmployee()
	{
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		
		System.out.println("Enter Employee Details:");
		System.out.println("Enter EmployeeID");
		int eid = sc.nextInt();
		
		System.out.println("Enter EmployeeName");
		String ename = sc.next();
		
		System.out.println("Enter EmployeeSalary");
		double esalary = sc.nextDouble();
		
		System.out.println("Enter EmployeeDeg");
		String eDeg = sc.next();
		
		Employee employee = new Employee();
		employee.setEid(eid);
		employee.setEname(ename);
		employee.setSalary(esalary);
		employee.setDeg(eDeg);

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();

	}
	
	public static void updateEmployee()
	{
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		System.out.println("Enter EmployeeID");
		int eid = sc.nextInt();
		Employee employee = entitymanager.find(Employee.class, eid);

		// before update
		System.out.println(employee);
		employee.setEname("Ram");
		employee.setSalary(46000);
		entitymanager.getTransaction().commit();

		// after update
		System.out.println(employee);
		entitymanager.close();
	}
	
	public static void getEmployee()
	{
		EntityManager entitymanager = emfactory.createEntityManager();
		System.out.println("Enter EmployeeID");
		int eid = sc.nextInt();
		
		Employee employee = entitymanager.find(Employee.class, eid);
		System.out.println("employee ID = " + employee.getEid());
		System.out.println("employee NAME = " + employee.getEname());
		System.out.println("employee SALARY = " + employee.getSalary());
		System.out.println("employee DESIGNATION = " + employee.getDeg());
	}
	
	public static void deleteEmployee()
	{
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		System.out.println("Enter EmployeeID");
		int eid = sc.nextInt();
		
		Employee employee = entitymanager.find(Employee.class, eid);
		entitymanager.remove(employee);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
	}
	
	public static void main(String[] args) 
	{
		
		saveEmployee();
		//updateEmployee();
		//getEmployee();
		//deleteEmployee();
		emfactory.close( );
	}

}

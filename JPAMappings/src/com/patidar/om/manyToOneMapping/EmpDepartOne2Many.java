package com.patidar.om.manyToOneMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmpDepartOne2Many {

	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMappings");

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		Employee employee1 = new Employee();
		employee1.setFirstname("golu");
		employee1.setLastname("patidar");
		employee1.setEmail("gl23");

		Employee employee2 = new Employee();
		employee2.setFirstname("Ravi");
		employee2.setLastname("Patidar");
		employee2.setEmail("kliutor");

		em.persist(employee2);
		em.persist(employee1);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);

		Department department1 = new Department();
		department1.setName("IIT");
		department1.setEmployees(employees);

		employee1.setDepartment(department1);

		em.persist(department1);

		int employeeID = employee1.getIdemployee();
		int departmentid = department1.getIddepartment();
		transaction.commit();
		transaction.begin();

		Employee employee = em.find(Employee.class, employeeID);
		System.out.println(employee.getDepartment());

		Department department = em.find(Department.class, departmentid);
		System.out.println(department.getEmployees());

		transaction.commit();
	}

}

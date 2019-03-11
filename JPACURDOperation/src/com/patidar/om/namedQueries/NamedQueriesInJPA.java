package com.patidar.om.namedQueries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.patidar.om.curdOperation.Employee;

public class NamedQueriesInJPA {

	public static void main(String[] args) 
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPACURDOperation");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("find employee by id");

		query.setParameter("id", 1204);
		@SuppressWarnings("unchecked")
		List<Employee> list = query.getResultList();

		for (Employee e : list) 
		{
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee Name :" + e.getEname());
			System.out.println("\t employee SALARY : " + e.getSalary());
			System.out.println("\temployee DESIGNATION : " + e.getDeg());
		}

	}

}

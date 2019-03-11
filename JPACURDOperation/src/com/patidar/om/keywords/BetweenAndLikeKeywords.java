package com.patidar.om.keywords;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.patidar.om.curdOperation.Employee;

public class BetweenAndLikeKeywords 
{
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPACURDOperation" );
	
	@SuppressWarnings("unchecked")
	public static void keywords()
	{
		EntityManager entitymanager = emfactory.createEntityManager();
	      
	      //Between
	      Query query = entitymanager.createQuery( "Select e " + "from Employee e " + "where e.salary " + "Between 30000 and 60000" );
	      
	      List<Employee> list=(List<Employee>)query.getResultList( );

	      for( Employee e:list ){
	         System.out.print("Employee ID :" + e.getEid( ));
	         System.out.println("\t Employee salary :" + e.getSalary( ));
	      }

	      //Like
	      Query query1 = entitymanager.createQuery("Select e " + "from Employee e " + "where e.ename LIKE 'R%'");
	      
	      List<Employee> list1=(List<Employee>)query1.getResultList( );
	      
	      for( Employee e:list1 ) {
	         System.out.print("Employee ID :"+e.getEid( ));
	         System.out.println("\t Employee name :"+e.getEname( ));
	      }
	      entitymanager.close();
	}
	
	public static void ordering()
	{
		EntityManager entitymanager = emfactory.createEntityManager();
	      
	      //Between
	      Query query = entitymanager.createQuery( "Select e " + "from Employee e " + "ORDER BY e.ename DESC" );

	      @SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>)query.getResultList( );

	      for( Employee e:list ) {
	         System.out.print("Employee ID :" + e.getEid( ));
	         System.out.println("\t Employee Name :" + e.getEname( ));
	      }
	      entitymanager.close();
	      
	}
	
	public static void main(String[] args) {
		
		keywords(); 
		ordering();
		
		emfactory.close();
	}

}

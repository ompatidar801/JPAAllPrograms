package com.patidar.om.oneToOneMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StdAdd {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMappings");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Student s = new Student();
		s.setStudentId(10);
		s.setStudentName("Remo");
		s.setGrp("Dance");

		Address ad = new Address();
		ad.setAddressId(3);
		ad.setPlace("Mumai");
		em.persist(ad);
		
		txn.begin();
		Address ad2 = em.find(Address.class, 1); // retrieves Address from database
		s.setAddressId(ad2);
		em.persist(s);
		txn.commit();
		
		txn.begin();
		ad2 = em.find(Address.class, 1);
		ad2.setStudent(s);
		em.persist(ad2);
		txn.commit();
		
	}

}

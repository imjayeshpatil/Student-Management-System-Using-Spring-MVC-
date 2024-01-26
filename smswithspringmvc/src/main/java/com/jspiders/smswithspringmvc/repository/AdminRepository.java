package com.jspiders.smswithspringmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.smswithspringmvc.pojo.AdminPojo;
import com.jspiders.smswithspringmvc.pojo.StudentPOJO;
@Component
public class AdminRepository {
	@Autowired
	private EntityManager entityManager;

//	public static void getAllAdmin() {
//	
//		
//	}

	public void addAdmin(AdminPojo adminPojo) {
		
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(adminPojo);
		entityTransaction.commit();
		
		
	}

	public List<AdminPojo> getAllAdmin() {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("SELECT admin from AdminPojo admin ");

		@SuppressWarnings("unchecked")
		List<AdminPojo> admin = query.getResultList();

		entityTransaction.commit();

		return admin;
	
	}

	public void deleteAdmin(AdminPojo adminToBeDeleted) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(adminToBeDeleted);
		entityTransaction.commit();
		
	}
	

	
}

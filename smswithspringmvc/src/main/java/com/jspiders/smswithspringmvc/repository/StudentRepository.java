 package com.jspiders.smswithspringmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.smswithspringmvc.pojo.StudentPOJO;

@Component
public class StudentRepository {
	@Autowired
	private EntityManager entityManager;

	public void addStudent(StudentPOJO studentPOJO) {
		// TODO Auto-generated method stub

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(studentPOJO);
		entityTransaction.commit();

	}

	public List<StudentPOJO> getAllStudent() {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("SELECT student from StudentPOJO student ");

		@SuppressWarnings("unchecked")
		List<StudentPOJO> students = query.getResultList();

		entityTransaction.commit();

		return students;

	}

	public void deleteStudent(StudentPOJO deleteIdStudent) {
		// TODO Auto-generated method stub

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.remove(deleteIdStudent);
		entityTransaction.commit();

	}

	public StudentPOJO getStudentById(long id) {
	
		return entityManager.find(StudentPOJO.class, id);
	}

}
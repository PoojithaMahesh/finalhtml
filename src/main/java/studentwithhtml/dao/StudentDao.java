package studentwithhtml.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentwithhtml.dto.Student;

public class StudentDao {

	public Student signupStudent(Student student) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student getStudentByEmail(String email) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select s from Student s where s.email=?1");
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		return student;
	}
	
	public List<Student> getAllStudents(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select s from Student s");
		return query.getResultList();
	}

	public Student findStudentById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student=entityManager.find(Student.class, id);
		return student;
	}

	public Student deleteStudentById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return student;
		}else {
//			id is not present
			return null;
		}
	}
	
	public Student updateStudent(int id,Student student) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			student.setId(id);
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		}else {
			return null;
		}
		
		
	}

}

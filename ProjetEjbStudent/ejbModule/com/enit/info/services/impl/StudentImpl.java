package com.enit.info.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

import com.enit.info.model.Exam;
import com.enit.info.model.Session;
import com.enit.info.model.SessionPK;
import com.enit.info.model.Speciality;
import com.enit.info.model.Student;
import com.enit.info.services.StudyManagementLocal;
import com.enit.info.services.StudyManagementRemote;

@Stateless(name="studentProjet")
public class StudentImpl implements StudyManagementLocal, StudyManagementRemote {
	@PersistenceContext(unitName="student")
	private EntityManager em;
	
	@Override
	public boolean addStudent(Student student) {
		try {
			em.persist(student);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean addSpeciality(Speciality speciality) {
		try {
			em.persist(speciality);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean addExam(Exam exam) {
		try {
			em.persist(exam);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Student findStudentById(String idStudent) {
		Student st = em.find(Student.class, idStudent);
		return st;
	}
	
	@Override
	public Exam findExamById(int idExam) {
		Exam ex= em.find(Exam.class, idExam);
		return ex;
	}

	@Override
	public Speciality findSpecialityById(int id) {
		Speciality sp = em.find(Speciality.class, id);
        return sp;
	}

	@Override
	public boolean addSession(Date dateOfTheExam, Student studentFound, Exam examFound) {
		try {
			SessionPK pk = new SessionPK(studentFound.getIdStudent(),examFound.getIdExam());
			Session se= new Session(pk,dateOfTheExam,studentFound,examFound);
			em.merge(se);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Session findSession(Date dateOfTheExam, String idStudent, int idExam) {
		/*Student st= em.find(Student.class, idStudent);
		Exam ex=em.find(Exam.class, idExam);
		SessionPK pk = new SessionPK(idStudent,idExam);
		Session se= new Session(pk,dateOfTheExam,st,ex);
		Session sess = em.find(Session.class, se.getIdSession());*/
		SessionPK pk = new SessionPK(idStudent,idExam);
		Session sess = em.find(Session.class, pk);
		return sess;
	}
	
	/*@Override
	public boolean update(Session sessionfound) {
		Query query = em.createQuery("UPDATE Session SET session = sessionfound where idSession = sessionfound.getIdSession())");
		try {
			int updateCount =query.executeUpdate();
		}catch(Exception e) {
			return false;
		}
		return true;
	}*/
	
	@Override
	public boolean update(Session sessionfound) {
		try {
			em.merge(sessionfound);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}

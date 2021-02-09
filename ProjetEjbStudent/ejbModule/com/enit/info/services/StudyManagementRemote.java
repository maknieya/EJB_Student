package com.enit.info.services;
import java.util.Date;

import javax.ejb.Remote;
import com.enit.info.model.Student;
import com.enit.info.model.Exam;
import com.enit.info.model.Session;
import com.enit.info.model.Speciality;

@Remote
public interface StudyManagementRemote {
	boolean addStudent(Student student);
	boolean addSpeciality(Speciality speciality);
	boolean addExam(Exam exam);
	Student findStudentById(String idStudent);
	Exam findExamById(int idExam);
	boolean addSession(Date dateOfTheExam, Student studentFound, Exam examFound);
	Session findSession(Date dateOfTheExam, String idStudent, int idExam);
	boolean update(Session sessionfound);
	Speciality findSpecialityById(int idSpeciality);
}

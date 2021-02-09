package com.enit.info.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

import javax.persistence.Column;


@Embeddable
public class SessionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SessionPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public SessionPK(String idStudent, int idExam) {
		super();
		this.idExam = idExam;
		this.idStudent = idStudent;
	}



	@Column(name="id_exam")
	private int idExam;
	@Column(name="id_student")
	private String idStudent;
	public int getExamId() {
		return idExam;
	}
	public void setExamId(int examId) {
		this.idExam = examId;
	}
	public String getStudentId() {
		return idStudent;
	}
	public void setStudentId(String studentId) {
		this.idStudent = studentId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idExam;
		result = prime * result + ((idStudent == null) ? 0 : idStudent.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionPK other = (SessionPK) obj;
		if (idExam != other.idExam)
			return false;
		if (idStudent == null) {
			if (other.idStudent != null)
				return false;
		} else if (!idStudent.equals(other.idStudent))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "SessionPK [idExam=" + idExam + ", idStudent=" + idStudent + "]";
	}
	
	
	
}

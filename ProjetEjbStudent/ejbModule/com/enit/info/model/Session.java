package com.enit.info.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_session")
public class Session implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Session(Date dateOfTheExam, float mark) {
		super();
		this.dateOfTheExam = dateOfTheExam;
		this.mark = mark;
	}

	

	public Session(Date dateOfTheExam, Student student, Exam exam, float mark) {
		super();
		this.dateOfTheExam = dateOfTheExam;
		this.mark = mark;
		this.student = student;
		this.exam = exam;
	}
	
	public Session(Date dateOfTheExam, Student student, Exam exam) {
		super();
		this.dateOfTheExam = dateOfTheExam;
		this.student = student;
		this.exam = exam;
	}
	

	public Session(SessionPK idSession, Date dateOfTheExam, Student student, Exam exam) {
		super();
		this.idSession = idSession;
		this.dateOfTheExam = dateOfTheExam;
		this.student = student;
		this.exam = exam;
	}


	@EmbeddedId
	private SessionPK idSession;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateOfTheExam;
	@Column(nullable= true)
	private float mark;
	
	@JoinColumn(name = "id_Student", referencedColumnName = "idStudent",  updatable = false)
	@MapsId("idStudent")
	@ManyToOne(optional = false)
	private Student student;

	@JoinColumn(name = "id_Exam", referencedColumnName = "idExam", updatable = false)
	@MapsId("idExam")
	@ManyToOne(optional = false)
	private Exam exam;

	public SessionPK getIdSession() {
		return idSession;
	}

	public void setIdSession(SessionPK idSession) {
		this.idSession = idSession;
	}

	public Date getDateOfTheExam() {
		return dateOfTheExam;
	}

	public void setDateOfTheExam(Date dateOfTheExam) {
		this.dateOfTheExam = dateOfTheExam;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfTheExam == null) ? 0 : dateOfTheExam.hashCode());
		result = prime * result + ((exam == null) ? 0 : exam.hashCode());
		result = prime * result + ((idSession == null) ? 0 : idSession.hashCode());
		result = prime * result + Float.floatToIntBits(mark);
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Session other = (Session) obj;
		if (dateOfTheExam == null) {
			if (other.dateOfTheExam != null)
				return false;
		} else if (!dateOfTheExam.equals(other.dateOfTheExam))
			return false;
		if (exam == null) {
			if (other.exam != null)
				return false;
		} else if (!exam.equals(other.exam))
			return false;
		if (idSession == null) {
			if (other.idSession != null)
				return false;
		} else if (!idSession.equals(other.idSession))
			return false;
		if (Float.floatToIntBits(mark) != Float.floatToIntBits(other.mark))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", dateOfTheExam=" + dateOfTheExam + ", mark=" + mark+ "]";
	}
	
	
}

package com.enit.info.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_exam")
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Exam(String titleExam, Collection<Session> sessions, Speciality speciality) {
		super();
		this.titleExam = titleExam;
		this.sessions = sessions;
		this.speciality = speciality;
	}



	public Exam(String titleExam, Speciality speciality) {
		super();
		this.titleExam = titleExam;
		this.speciality = speciality;
	}



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idExam;
	@Column 
	private String titleExam;
	
	@OneToMany(mappedBy="exam", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
	private Collection<Session> sessions;
	
	@ManyToOne
	private Speciality speciality;

	
	
	public int getIdExam() {
		return idExam;
	}

	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}

	public String getTitleExam() {
		return titleExam;
	}

	public void setTitleExam(String titleExam) {
		this.titleExam = titleExam;
	}

	public Collection<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Collection<Session> sessions) {
		this.sessions = sessions;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idExam;
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		result = prime * result + ((titleExam == null) ? 0 : titleExam.hashCode());
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
		Exam other = (Exam) obj;
		if (idExam != other.idExam)
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		if (titleExam == null) {
			if (other.titleExam != null)
				return false;
		} else if (!titleExam.equals(other.titleExam))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Exam [idExam=" + idExam + ", titleExam=" + titleExam + "]";
	}
	
	
	
}

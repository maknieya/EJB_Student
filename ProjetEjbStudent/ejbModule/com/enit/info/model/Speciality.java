package com.enit.info.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_speciality")
public class Speciality implements Serializable {

	public Speciality() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 public Speciality(String nameSpeciality, Collection<Exam> exam) {
		super();
		this.nameSpeciality = nameSpeciality;
		this.exam = exam;
	}

	 
	public Speciality(String nameSpeciality) {
		super();
		this.nameSpeciality = nameSpeciality;
	}


	@Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private int idSpeciality;
	 @Column
	 private String nameSpeciality;
	 
	 @OneToMany(mappedBy="speciality", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 private Collection<Exam> exam;

	public int getIdSpeciality() {
		return idSpeciality;
	}

	public void setIdSpeciality(int idSpeciality) {
		this.idSpeciality = idSpeciality;
	}

	public String getNameSpeciality() {
		return nameSpeciality;
	}

	public void setNameSpeciality(String nameSpeciality) {
		this.nameSpeciality = nameSpeciality;
	}

	public Collection<Exam> getExam() {
		return exam;
	}

	public void setExam(Collection<Exam> exam) {
		this.exam = exam;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exam == null) ? 0 : exam.hashCode());
		result = prime * result + idSpeciality;
		result = prime * result + ((nameSpeciality == null) ? 0 : nameSpeciality.hashCode());
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
		Speciality other = (Speciality) obj;
		if (exam == null) {
			if (other.exam != null)
				return false;
		} else if (!exam.equals(other.exam))
			return false;
		if (idSpeciality != other.idSpeciality)
			return false;
		if (nameSpeciality == null) {
			if (other.nameSpeciality != null)
				return false;
		} else if (!nameSpeciality.equals(other.nameSpeciality))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Speciality [idSpeciality=" + idSpeciality + ", nameSpeciality=" + nameSpeciality + "]";
	}
	 
	 
}

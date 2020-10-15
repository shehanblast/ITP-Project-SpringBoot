package com.in28minutes.rest.webservices.restfulwebservices.patient;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.in28minutes.rest.webservices.restfulwebservices.patient.Patient;


@Entity
public class Patient {


    @Id
    @GeneratedValue
    private Long patientID;
	private String patientName;
	private int age;
	private Date dob;  
	private String address;
	private int telephoneNo;
	private String email;
	private String gender;
	private String ageGroup;
	


    public Patient(){

    }



    public Patient(Long patientID, String patientName, int age, Date dob, String address, int telephoneNo, String email,
			String gender, String ageGroup) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.age = age;
		this.dob = dob;
		this.address = address;
		this.telephoneNo = telephoneNo;
		this.email = email;
		this.gender = gender;
		this.ageGroup = ageGroup;
	}
    
    public Long getPatientID() {
		return patientID;
	}



	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getTelephoneNo() {
		return telephoneNo;
	}



	public void setTelephoneNo(int telephoneNo) {
		this.telephoneNo = telephoneNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAgeGroup() {
		return ageGroup;
	}



	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((ageGroup == null) ? 0 : ageGroup.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((patientID == null) ? 0 : patientID.hashCode());
		result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
		result = prime * result + telephoneNo;
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
		Patient other = (Patient) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (ageGroup == null) {
			if (other.ageGroup != null)
				return false;
		} else if (!ageGroup.equals(other.ageGroup))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (patientID == null) {
			if (other.patientID != null)
				return false;
		} else if (!patientID.equals(other.patientID))
			return false;
		if (patientName == null) {
			if (other.patientName != null)
				return false;
		} else if (!patientName.equals(other.patientName))
			return false;
		if (telephoneNo != other.telephoneNo)
			return false;
		return true;
	}













}

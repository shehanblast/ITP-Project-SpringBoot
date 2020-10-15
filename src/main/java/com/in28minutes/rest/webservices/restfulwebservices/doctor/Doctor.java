package com.in28minutes.rest.webservices.restfulwebservices.doctor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String name;
    private String specialization;
    private String email;
    private String a_time;
    private String patientsNumber;

    public Doctor(){

    }

    public Doctor(Long id, String username,String name, String specialization, String email, String a_time,String patientsNumber) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.a_time = a_time;
        this.patientsNumber = patientsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getA_time() {
		return a_time;
	}

	public void setA_time(String a_time) {
		this.a_time = a_time;
	}

	public String getPatientsNumber() {
		return patientsNumber;
	}

	public void setPatientsNumber(String patientsNumber) {
		this.patientsNumber = patientsNumber;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
		Doctor other = (Doctor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}

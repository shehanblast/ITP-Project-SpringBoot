package com.in28minutes.rest.webservices.restfulwebservices.shortTermIlnesses;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class STillness 
{
	@Id
	@GeneratedValue
	private Long stID;
	private Long patientID;
	private String stName;
	private Date stChanneldate;
	
	public STillness() {
		
	}

	public STillness(Long stID, Long patientID, String stName, Date stChanneldate) {
		super();
		this.stID = stID;
		this.patientID = patientID;
		this.stName = stName;
		this.stChanneldate = stChanneldate;
	}

	public Long getStID() {
		return stID;
	}

	public void setStID(Long stID) {
		this.stID = stID;
	}

	public Long getPatientID() {
		return patientID;
	}

	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public Date getStChanneldate() {
		return stChanneldate;
	}

	public void setStChanneldate(Date stChanneldate) {
		this.stChanneldate = stChanneldate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patientID == null) ? 0 : patientID.hashCode());
		result = prime * result + ((stChanneldate == null) ? 0 : stChanneldate.hashCode());
		result = prime * result + ((stID == null) ? 0 : stID.hashCode());
		result = prime * result + ((stName == null) ? 0 : stName.hashCode());
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
		STillness other = (STillness) obj;
		if (patientID == null) {
			if (other.patientID != null)
				return false;
		} else if (!patientID.equals(other.patientID))
			return false;
		if (stChanneldate == null) {
			if (other.stChanneldate != null)
				return false;
		} else if (!stChanneldate.equals(other.stChanneldate))
			return false;
		if (stID == null) {
			if (other.stID != null)
				return false;
		} else if (!stID.equals(other.stID))
			return false;
		if (stName == null) {
			if (other.stName != null)
				return false;
		} else if (!stName.equals(other.stName))
			return false;
		return true;
	}
	
	
	
	
	
}
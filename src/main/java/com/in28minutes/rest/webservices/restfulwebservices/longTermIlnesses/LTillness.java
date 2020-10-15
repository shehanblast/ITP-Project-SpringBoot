package com.in28minutes.rest.webservices.restfulwebservices.longTermIlnesses;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LTillness 
{
	@Id
	@GeneratedValue
	private Long ltID;
	private Long patientID;
	private String ltName;
	private Date ltChanneldate;
	
	public LTillness() {
		
	}

	public LTillness(Long ltID, Long patientID, String ltName, Date ltChanneldate) {
		super();
		this.ltID = ltID;
		this.patientID = patientID;
		this.ltName = ltName;
		this.ltChanneldate = ltChanneldate;
	}

	public Long getLtID() {
		return ltID;
	}

	public void setLtID(Long ltID) {
		this.ltID = ltID;
	}

	public Long getPatientID() {
		return patientID;
	}

	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}

	public String getLtName() {
		return ltName;
	}

	public void setLtName(String ltName) {
		this.ltName = ltName;
	}

	public Date getLtChanneldate() {
		return ltChanneldate;
	}

	public void setLtChanneldate(Date ltChanneldate) {
		this.ltChanneldate = ltChanneldate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ltChanneldate == null) ? 0 : ltChanneldate.hashCode());
		result = prime * result + ((ltID == null) ? 0 : ltID.hashCode());
		result = prime * result + ((ltName == null) ? 0 : ltName.hashCode());
		result = prime * result + ((patientID == null) ? 0 : patientID.hashCode());
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
		LTillness other = (LTillness) obj;
		if (ltChanneldate == null) {
			if (other.ltChanneldate != null)
				return false;
		} else if (!ltChanneldate.equals(other.ltChanneldate))
			return false;
		if (ltID == null) {
			if (other.ltID != null)
				return false;
		} else if (!ltID.equals(other.ltID))
			return false;
		if (ltName == null) {
			if (other.ltName != null)
				return false;
		} else if (!ltName.equals(other.ltName))
			return false;
		if (patientID == null) {
			if (other.patientID != null)
				return false;
		} else if (!patientID.equals(other.patientID))
			return false;
		return true;
	}
	
	
	
}

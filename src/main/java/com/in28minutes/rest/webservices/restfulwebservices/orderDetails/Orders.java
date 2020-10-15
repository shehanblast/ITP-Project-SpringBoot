package com.in28minutes.rest.webservices.restfulwebservices.orderDetails;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String medicine;
	private String sname;
	private String smobile;
//	@Column(name="date")
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date odate = new Date();
	private String type;
	private int quantity;
	
	
	public Orders() {
		
		
	}


	 
	
	public Orders(Long id, String medicine, String sname, String smobile, Date odate, String type,
			int quantity, String status) {
		super();
		this.id = id;
		this.medicine = medicine;
		this.sname = sname;
		this.smobile = smobile;
		this.odate = odate;
		this.type = type;
		this.quantity = quantity;
		this.status = status;
	}



	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSmobile() {
		return smobile;
	}

	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	
	public Date getOdate() {
		return odate;
	}


	public void setOdate(Date odate) {
		this.odate = odate;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", medicine=" + medicine + ", sname=" + sname + ", smobile=" + smobile
				+ ", odate=" + odate + ", type=" + type +  ", quantity=" + quantity + ", status=" + status + "]";
	}

}

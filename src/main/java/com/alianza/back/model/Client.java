package com.alianza.back.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@Column(name = "sharedkey",unique = true, nullable = false)
	private String sharedKey;
	@Column(name = "businessid")
	private String businessId;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "dataadded")
	private Date dataAdded;
	
	public Client() {		
	}
	public Client(String sharedKey, String businessId, String email, String phone, Date dataAdded) {
		super();
		this.sharedKey = sharedKey;
		this.businessId = businessId;
		this.email = email;
		this.phone = phone;
		this.dataAdded = dataAdded;
	}
	
	public String getSharedKey() {
		return sharedKey;
	}
	public void setSharedKey(String sharedKey) {
		this.sharedKey = sharedKey;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDataAdded() {
		return dataAdded;
	}
	public void setDataAdded(Date dataAdded) {
		this.dataAdded = dataAdded;
	}
}

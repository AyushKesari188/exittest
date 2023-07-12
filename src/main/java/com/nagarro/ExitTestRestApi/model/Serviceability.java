package com.nagarro.ExitTestRestApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviceability")
public class Serviceability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "pincode", nullable = false)
	private String pincode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Serviceability(int id, String code, String pincode) {
		super();
		this.id = id;
		this.code = code;
		this.pincode = pincode;
	}

	public Serviceability() {
		super();
	}

	@Override
	public String toString() {
		return "Serviceability [id=" + id + ", code=" + code + ", pincode=" + pincode + "]";
	}
}

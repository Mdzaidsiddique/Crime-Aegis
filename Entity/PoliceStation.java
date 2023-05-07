package com.masaischool.Entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PoliceStation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ps_id;
	private String ps_name;
	private String ps_area;
	
	private int crime_Id;
	
	@Embedded
	private Address ps_address;

	public PoliceStation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PoliceStation(String ps_name, String ps_area, int crime_Id, Address ps_address) {
		super();
		this.ps_name = ps_name;
		this.ps_area = ps_area;
		this.crime_Id = crime_Id;
		this.ps_address = ps_address;
	}

	public int getPs_id() {
		return ps_id;
	}

	public void setPs_id(int ps_id) {
		this.ps_id = ps_id;
	}

	public String getPs_name() {
		return ps_name;
	}

	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}

	public String getPs_area() {
		return ps_area;
	}

	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}

	public int getCrime_Id() {
		return crime_Id;
	}

	public void setCrime_Id(int crime_Id) {
		this.crime_Id = crime_Id;
	}

	public Address getPs_address() {
		return ps_address;
	}

	public void setPs_address(Address ps_address) {
		this.ps_address = ps_address;
	}

	@Override
	public String toString() {
		return "PoliceStation [ps_id=" + ps_id + ", ps_name=" + ps_name + ", ps_area=" + ps_area + ", crime_Id="
				+ crime_Id + ", ps_address=" + ps_address + "]";
	}

}

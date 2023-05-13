package com.masaischool.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
public class Victim {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int v_id;
	private String v_name;
	
	@Embedded
	private Address v_address;
	
	private int v_age;
	private String v_gender;
	private int ps_id;
	private int crimeId;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="victim_police")
    private Set<PoliceStation> PoliceStations = new HashSet<>();


	@OneToOne( mappedBy = "victim", cascade = CascadeType.ALL)
    @JoinColumn(name="crim_id")
    private  Criminal criminal;
	
	 @OneToOne
     @PrimaryKeyJoinColumn
     private Crime crime;

	public Victim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Victim(String v_name, Address v_address, int v_age, String v_gender, int ps_id, int crimeId,
			Set<PoliceStation> policeStations, Criminal criminal, Crime crime) {
		super();
		this.v_name = v_name;
		this.v_address = v_address;
		this.v_age = v_age;
		this.v_gender = v_gender;
		this.ps_id = ps_id;
		this.crimeId = crimeId;
		PoliceStations = policeStations;
		this.criminal = criminal;
		this.crime = crime;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public Address getV_address() {
		return v_address;
	}

	public void setV_address(Address v_address) {
		this.v_address = v_address;
	}

	public int getV_age() {
		return v_age;
	}

	public void setV_age(int v_age) {
		this.v_age = v_age;
	}

	public String getV_gender() {
		return v_gender;
	}

	public void setV_gender(String v_gender) {
		this.v_gender = v_gender;
	}

	public int getPs_id() {
		return ps_id;
	}

	public void setPs_id(int ps_id) {
		this.ps_id = ps_id;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public Set<PoliceStation> getPoliceStations() {
		return PoliceStations;
	}

	public void setPoliceStations(Set<PoliceStation> policeStations) {
		PoliceStations = policeStations;
	}

	public Criminal getCriminal() {
		return criminal;
	}

	public void setCriminal(Criminal criminal) {
		this.criminal = criminal;
	}

	public Crime getCrime() {
		return crime;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}

	@Override
	public String toString() {
		return "Victim [v_id=" + v_id + ", v_name=" + v_name + ", v_address=" + v_address + ", v_age=" + v_age
				+ ", v_gender=" + v_gender + ", ps_id=" + ps_id + ", crimeId=" + crimeId + ", PoliceStations="
				+ PoliceStations + ", criminal=" + criminal + ", crime=" + crime + "]";
	}
	


	
	
	
}

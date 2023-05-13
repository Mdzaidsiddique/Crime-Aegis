package com.masaischool.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Criminal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int criminal_Id;
    
    @Column(nullable = false)
    private String criminal_name;
    
    private LocalDate criminal_dob;
    
    @Column(nullable = false)
    private String criminal_gender;
    
    private String criminal_identifyingMark;
    
    @Column(nullable = false)
    private LocalDate criminal_firstArrestDate;
    
    @Column(nullable = false)
    private String criminal_arrestedFromPsArea;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Victim victim;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="criminal_police")
    private Set<PoliceStation> PoliceStations = new HashSet<>();
    
    
    @ManyToMany(cascade = CascadeType.ALL) 
    @JoinTable(name = "criminal_crime", joinColumns = { @JoinColumn(name = "criminal_Id") }, inverseJoinColumns = { @JoinColumn(name = "crime_Id") })
    private Set<Crime> crimeSet = new HashSet<>();

    @Embedded
    private Address criminal_address = new Address();

	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criminal(String criminal_name, LocalDate criminal_dob, String criminal_gender,
			String criminal_identifyingMark, LocalDate criminal_firstArrestDate, String criminal_arrestedFromPsArea,
			Victim victim, Set<PoliceStation> policeStations, Set<Crime> crimeSet, Address criminal_address) {
		super();
		this.criminal_name = criminal_name;
		this.criminal_dob = criminal_dob;
		this.criminal_gender = criminal_gender;
		this.criminal_identifyingMark = criminal_identifyingMark;
		this.criminal_firstArrestDate = criminal_firstArrestDate;
		this.criminal_arrestedFromPsArea = criminal_arrestedFromPsArea;
		this.victim = victim;
		PoliceStations = policeStations;
		this.crimeSet = crimeSet;
		this.criminal_address = criminal_address;
	}

	public int getCriminal_Id() {
		return criminal_Id;
	}

	public void setCriminal_Id(int criminal_Id) {
		this.criminal_Id = criminal_Id;
	}

	public String getCriminal_name() {
		return criminal_name;
	}

	public void setCriminal_name(String criminal_name) {
		this.criminal_name = criminal_name;
	}

	public LocalDate getCriminal_dob() {
		return criminal_dob;
	}

	public void setCriminal_dob(LocalDate criminal_dob) {
		this.criminal_dob = criminal_dob;
	}

	public String getCriminal_gender() {
		return criminal_gender;
	}

	public void setCriminal_gender(String criminal_gender) {
		this.criminal_gender = criminal_gender;
	}

	public String getCriminal_identifyingMark() {
		return criminal_identifyingMark;
	}

	public void setCriminal_identifyingMark(String criminal_identifyingMark) {
		this.criminal_identifyingMark = criminal_identifyingMark;
	}

	public LocalDate getCriminal_firstArrestDate() {
		return criminal_firstArrestDate;
	}

	public void setCriminal_firstArrestDate(LocalDate criminal_firstArrestDate) {
		this.criminal_firstArrestDate = criminal_firstArrestDate;
	}

	public String getCriminal_arrestedFromPsArea() {
		return criminal_arrestedFromPsArea;
	}

	public void setCriminal_arrestedFromPsArea(String criminal_arrestedFromPsArea) {
		this.criminal_arrestedFromPsArea = criminal_arrestedFromPsArea;
	}

	public Victim getVictim() {
		return victim;
	}

	public void setVictim(Victim victim) {
		this.victim = victim;
	}

	public Set<PoliceStation> getPoliceStations() {
		return PoliceStations;
	}

	public void setPoliceStations(Set<PoliceStation> policeStations) {
		PoliceStations = policeStations;
	}

	public Set<Crime> getCrimeSet() {
		return crimeSet;
	}

	public void setCrimeSet(Set<Crime> crimeSet) {
		this.crimeSet = crimeSet;
	}

	public Address getCriminal_address() {
		return criminal_address;
	}

	public void setCriminal_address(Address criminal_address) {
		this.criminal_address = criminal_address;
	}

	@Override
	public String toString() {
		return "Criminal [criminal_Id=" + criminal_Id + ", criminal_name=" + criminal_name + ", criminal_dob="
				+ criminal_dob + ", criminal_gender=" + criminal_gender + ", criminal_identifyingMark="
				+ criminal_identifyingMark + ", criminal_firstArrestDate=" + criminal_firstArrestDate
				+ ", criminal_arrestedFromPsArea=" + criminal_arrestedFromPsArea + ", victim=" + victim
				+ ", PoliceStations=" + PoliceStations + ", crimeSet=" + crimeSet + ", criminal_address="
				+ criminal_address + "]";
	}
    
    
    
}

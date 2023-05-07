package com.masaischool.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "crime")
public class Crime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int crime_Id;
    
    @Column(nullable = false)
    private String crime_type;
    
    private String crime_description;
    
    @Column(nullable = false)
    private String crime_psArea;
    
    @Column(nullable = false)
    private LocalDate crime_date;
    
    @Column(nullable = false)
    private String crime_victimName;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="crime_police")
    private Set<PoliceStation> PoliceStations = new HashSet<>();

    @OneToOne( mappedBy = "crime", cascade = CascadeType.ALL)
    @JoinColumn(name="cID")
    private Victim victim;
  
    @ManyToMany(mappedBy = "crimeSet", cascade=CascadeType.ALL)
    private Set<Criminal> criminalSet = new HashSet<>();

	public Crime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Crime(String crime_type, String crime_description, String crime_psArea, LocalDate crime_date,
			String crime_victimName, Set<PoliceStation> policeStations, Victim victim, Set<Criminal> criminalSet) {
		super();
		this.crime_type = crime_type;
		this.crime_description = crime_description;
		this.crime_psArea = crime_psArea;
		this.crime_date = crime_date;
		this.crime_victimName = crime_victimName;
		PoliceStations = policeStations;
		this.victim = victim;
		this.criminalSet = criminalSet;
	}

	public  int getCrime_Id() {
		return crime_Id;
	}

	public void setCrime_Id(int crime_Id) {
		this.crime_Id = crime_Id;
	}

	public String getCrime_type() {
		return crime_type;
	}

	public void setCrime_type(String crime_type) {
		this.crime_type = crime_type;
	}

	public String getCrime_description() {
		return crime_description;
	}

	public void setCrime_description(String crime_description) {
		this.crime_description = crime_description;
	}

	public String getCrime_psArea() {
		return crime_psArea;
	}

	public void setCrime_psArea(String crime_psArea) {
		this.crime_psArea = crime_psArea;
	}

	public LocalDate getCrime_date() {
		return crime_date;
	}

	public void setCrime_date(LocalDate crime_date) {
		this.crime_date = crime_date;
	}

	public String getCrime_victimName() {
		return crime_victimName;
	}

	public void setCrime_victimName(String crime_victimName) {
		this.crime_victimName = crime_victimName;
	}

	public Set<PoliceStation> getPoliceStations() {
		return PoliceStations;
	}

	public void setPoliceStations(Set<PoliceStation> policeStations) {
		PoliceStations = policeStations;
	}

	public Victim getVictim() {
		return victim;
	}

	public void setVictim(Victim victim) {
		this.victim = victim;
	}

	public Set<Criminal> getCriminalSet() {
		return criminalSet;
	}

	public void setCriminalSet(Set<Criminal> criminalSet) {
		this.criminalSet = criminalSet;
	}

	@Override
	public String toString() {
		return "Crime [crime_Id=" + crime_Id + ", crime_type=" + crime_type + ", crime_description=" + crime_description
				+ ", crime_psArea=" + crime_psArea + ", crime_date=" + crime_date + ", crime_victimName="
				+ crime_victimName + ", PoliceStations=" + PoliceStations + ", victim=" + victim + ", criminalSet="
				+ criminalSet + "]";
	}
    
    
    
}

package com.masaischool.Dao;

import java.time.LocalDate;

import com.masaischool.Exceptions.CrimeException;
import com.masaischool.Exceptions.NoRecordFoundException;

public interface PublicDao {
	
	public void viewTotalCrimeByEachPoliceStationUI() throws NoRecordFoundException;
	
	public void viewTotalCrimeByCrimeTypeUI() throws NoRecordFoundException, CrimeException;
	
	public void searchCriminalByName(String name) throws NoRecordFoundException, CrimeException;
	
	public void searchCrimeByDescription(String desc) throws NoRecordFoundException, CrimeException;


}

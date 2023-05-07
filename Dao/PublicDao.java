package com.masaischool.Dao;

import java.time.LocalDate;

import com.masaischool.Exceptions.NoRecordFoundException;

public interface PublicDao {
	
	public void viewTotalCrimeByPsAreaDateRangeWise(LocalDate d1, LocalDate d2) throws NoRecordFoundException;
	public void viewTC4EachCrimeTypeDateRangeWise(LocalDate d1, LocalDate d2) throws NoRecordFoundException;
	public void searchCriminalByName(String criminal_name) throws NoRecordFoundException;
	public void searchCriminalByDescription(String Description) throws NoRecordFoundException;


}

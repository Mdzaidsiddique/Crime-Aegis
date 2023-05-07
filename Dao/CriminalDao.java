package com.masaischool.Dao;

import java.time.LocalDate;

import com.masaischool.Exceptions.CrimeException;
import com.masaischool.Exceptions.CriminalException;
import com.masaischool.Exceptions.NoRecordFoundException;
import com.masaischool.Exceptions.SomeThingWentWrongException;

public interface CriminalDao {
	public void addCriminalDetails() throws CriminalException;
	public void updateCrime(int id, LocalDate dob, LocalDate fad, String area, String gender, String name, String idnt) throws CrimeException,SomeThingWentWrongException, NoRecordFoundException;
	public void deleteCriminalById(int id) throws NoRecordFoundException, SomeThingWentWrongException;
	public void removeCriminalFromCrimeByid(int id) throws NoRecordFoundException;

}

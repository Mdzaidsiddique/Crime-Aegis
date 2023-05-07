package com.masaischool.Dao;

import com.masaischool.Entity.Crime;
import com.masaischool.Exceptions.CrimeException;

import com.masaischool.Exceptions.NoRecordFoundException;
import com.masaischool.Exceptions.SomeThingWentWrongException;

public interface CrimeDao {
	
	public void addCrime(Crime crime) throws CrimeException;
	public void updateCrime(int id, String des, String type, String vn, String area ) throws CrimeException,SomeThingWentWrongException, NoRecordFoundException;
	public void deleteCrime(int id) throws NoRecordFoundException, SomeThingWentWrongException;
	

}

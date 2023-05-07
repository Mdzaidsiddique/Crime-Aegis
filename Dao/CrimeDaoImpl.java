package com.masaischool.Dao;

import com.masaischool.Entity.Crime;
import com.masaischool.Entity.Criminal;
import com.masaischool.Exceptions.CrimeException;
import com.masaischool.Exceptions.NoRecordFoundException;
import com.masaischool.Exceptions.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;


public class CrimeDaoImpl implements CrimeDao{

	@Override
	public void addCrime(Crime crime) throws CrimeException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Query query = em.createQuery("SELECT count(c) FROM Crime c WHERE crime_id = :CID");
			query.setParameter("CID", crime.getCrime_Id());
			if((Long)query.getSingleResult() > 0) {
				//I am are means crime with given crimeId exists so throw exceptions
				throw new SomeThingWentWrongException("Crime is already exists with id " + crime.getCrime_Id());
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(crime);
			et.commit();
			
		}catch(PersistenceException | SomeThingWentWrongException ex) {
			ex.printStackTrace();
			throw new CrimeException("Something Went Wrong with Crime Records add functionality");
		}finally{
			em.close();
		}
		
	}

	@Override
	public void updateCrime(int id, String des, String type, String vn, String area ) throws CrimeException, NoRecordFoundException, SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();

			Crime crm1 = em.find(Crime.class, id);
			if(crm1 == null)
				throw new NoRecordFoundException("No Crime found with the given id " + id);
			
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			
			crm1.setCrime_description(des);
			crm1.setCrime_psArea(area);
			crm1.setCrime_victimName(vn);
			crm1.setCrime_type(type);
			
			et.commit();
			
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

	@Override
	public void deleteCrime(int id) throws NoRecordFoundException, SomeThingWentWrongException {
		EntityManager em = null;
			try {
				em = EMUtils.getEntityManager();
				
				Crime crm1 = em.find(Crime.class, id);
				if(crm1 == null)
					throw new NoRecordFoundException("No Crime found with the given id " + id);
				
				Query query = em.createQuery("DELETE c CRIME c WHERE c.crime_id = :id");
				query.setParameter("id", id);
				
				if((Long)query.getSingleResult() > 0) {
					throw new SomeThingWentWrongException("Record Deleted Successfully");
				}

				
			} catch(PersistenceException ex) {
				throw new SomeThingWentWrongException("Unable to process request, try again later");
			}finally{
				em.close();
			}

		
	}

}

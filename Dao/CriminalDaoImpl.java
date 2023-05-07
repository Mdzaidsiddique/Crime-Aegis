package com.masaischool.Dao;

import java.time.LocalDate;

import com.masaischool.Entity.Crime;
import com.masaischool.Entity.Criminal;
import com.masaischool.Exceptions.CrimeException;
import com.masaischool.Exceptions.CriminalException;
import com.masaischool.Exceptions.NoRecordFoundException;
import com.masaischool.Exceptions.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CriminalDaoImpl implements CriminalDao {
	
	@Override
	public void deleteCriminalById(int id) throws NoRecordFoundException, SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Criminal crm1 = em.find(Criminal.class, id);
			if(crm1 == null)
				throw new NoRecordFoundException("No Criminal found with the given id " + id);
			
			Query query = em.createQuery("DELETE c CRIME c WHERE c.criminal_id = :id");
			query.setParameter("id", id);
			
			if((Long)query.getSingleResult() > 0) {
				throw new SomeThingWentWrongException("Criminal Record Deleted Successfully");
			}
			
		} catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}



	@Override
	public void updateCrime(int id, LocalDate dob, LocalDate fad, String area, String gender, String name, String idnt)
			throws CrimeException, SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();

			Criminal crm1 = em.find(Criminal.class, id);
			if(crm1 == null)
				throw new NoRecordFoundException("No Criminal found with the given id " + id);
			
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			
			crm1.setCriminal_dob(dob);
			crm1.setCriminal_gender(gender);
			
			crm1.setCriminal_name(name);
			crm1.setCriminal_identifyingMark(idnt);
			crm1.setCriminal_firstArrestDate(fad);
			crm1.setCriminal_arrestedFromPsArea(area);
			
			et.commit();
			
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

	
	@Override
	public void addCriminalDetails() throws CriminalException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void removeCriminalFromCrimeByid(int id) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

}

package com.masaischool.Dao;

import jakarta.persistence.Query;

import com.masaischool.Exceptions.CrimeException;
import com.masaischool.Exceptions.NoRecordFoundException;
import com.masaischool.Exceptions.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class PublicDaoImpl implements PublicDao{

	@Override
	public void viewTotalCrimeByEachPoliceStationUI() throws NoRecordFoundException {
		
		EntityManager em =null;
		try {
			em = EMUtils.getEntityManager();
			
//			String qr = "SELECT c.name FROM Criminal c WHERE c.criminal_name like '%"+name+"%' ";
//			Query query = em.createQuery(qr);
			
			
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			throw new NoRecordFoundException("Unable to find criminal name");
		}finally{
			em.close();
		}
	}

	@Override
	public void viewTotalCrimeByCrimeTypeUI() throws NoRecordFoundException, CrimeException {
		EntityManager em =null;
		try {
			em = EMUtils.getEntityManager();
			
//			String qr = "SELECT c.name FROM Criminal c WHERE c.criminal_name like '%"+name+"%' ";
			Query query = em.createQuery("");
			
			
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			throw new CrimeException("Unable to find criminal name");
		}finally{
			em.close();
		}
		
	}

	@Override
	public void searchCriminalByName(String name) throws NoRecordFoundException, CrimeException {
		EntityManager em =null;
		try {
			em = EMUtils.getEntityManager();
			
			String qr = "SELECT c.name FROM Criminal c WHERE c.criminal_name like '%"+name+"%' ";
			Query query = em.createQuery(qr);
			query.setParameter(name, query);
			
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			throw new CrimeException("Unable to find criminal name");
		}finally{
			em.close();
		}
				
		
	}

	@Override
	public void searchCrimeByDescription(String desc) throws NoRecordFoundException, CrimeException {
		EntityManager em =null;
		try {
			em = EMUtils.getEntityManager();
			
			String qr = "SELECT c.name FROM Criminal c WHERE c.criminal_description like '%"+desc+"%' ";
			Query query = em.createQuery(qr);
			query.setParameter(desc, query);
			
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			throw new CrimeException("Unable to find criminal name");
		}finally{
			em.close();
		}
	}


}

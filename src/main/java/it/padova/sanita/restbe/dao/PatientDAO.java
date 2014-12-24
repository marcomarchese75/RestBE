package it.padova.sanita.restbe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import it.padova.sanita.restbe.dto.Patient;

@Transactional()
public class PatientDAO extends GenericHibernateDao<Patient, Long> {

	public PatientDAO(){
		super(Patient.class);
	}

	@SuppressWarnings("unchecked")
	public List<Patient> findByName(String name) throws Exception
	{
		try
		{
			StringBuilder strQuery = new StringBuilder("from Assistito p where p.ass_name = :name");
			Query hqlQuery = getSession().createQuery(strQuery.toString());
			hqlQuery.setString("name", name);

			return (ArrayList<Patient>) hqlQuery.list(); 
		}
		catch (HibernateException ex)
		{
			throw new Exception(ex); 
		}
	}
}

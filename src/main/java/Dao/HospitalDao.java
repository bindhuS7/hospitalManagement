package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.DoctorDto;
import Dto.StaffDto;

public class HospitalDao {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	
	public void saveStaff(StaffDto  staff ){
		
		et.begin();
		em.persist(staff);
		et.commit();
	}
  public void saveDoctor(DoctorDto  doctor ){
		
		et.begin();
		em.persist(doctor);
		et.commit();
	}
	
}

package com.in28minutes.rest.webservices.restfulwebservices.patient;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientJpaRepo extends JpaRepository<Patient,Long> {

	List<Patient> findBypatientName(String patientName);

	List<Patient> findBypatientNameContainingIgnoreCase(String patientName);
	
	

}

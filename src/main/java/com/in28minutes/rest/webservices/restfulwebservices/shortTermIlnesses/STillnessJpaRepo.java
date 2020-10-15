package com.in28minutes.rest.webservices.restfulwebservices.shortTermIlnesses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STillnessJpaRepo extends JpaRepository<STillness,Long>{

	List<STillness> findSTByPatientID(Long patientID);


}

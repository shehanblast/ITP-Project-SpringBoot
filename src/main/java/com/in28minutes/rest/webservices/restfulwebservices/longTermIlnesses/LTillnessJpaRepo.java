package com.in28minutes.rest.webservices.restfulwebservices.longTermIlnesses;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LTillnessJpaRepo extends JpaRepository<LTillness,Long>
{
	List<LTillness> findLTByPatientID(Long patientID);

}

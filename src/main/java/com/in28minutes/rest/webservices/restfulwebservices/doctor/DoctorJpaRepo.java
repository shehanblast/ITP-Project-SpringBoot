package com.in28minutes.rest.webservices.restfulwebservices.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorJpaRepo extends JpaRepository<Doctor,Long> {

    List<Doctor> findByUsername(String username);
}

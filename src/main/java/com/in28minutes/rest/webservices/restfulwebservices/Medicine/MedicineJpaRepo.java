package com.in28minutes.rest.webservices.restfulwebservices.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineJpaRepo extends JpaRepository<Medicine,Long> {

    List<Medicine> findByUsername(String username);
}

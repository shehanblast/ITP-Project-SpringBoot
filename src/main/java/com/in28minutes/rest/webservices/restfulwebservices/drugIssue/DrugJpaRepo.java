package com.in28minutes.rest.webservices.restfulwebservices.drugIssue;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugJpaRepo extends JpaRepository<Drug,Long> {

    List<Drug> findByUsername(String username);

}

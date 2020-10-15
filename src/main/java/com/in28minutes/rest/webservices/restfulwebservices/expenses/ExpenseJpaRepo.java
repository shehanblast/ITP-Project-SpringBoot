package com.in28minutes.rest.webservices.restfulwebservices.expenses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseJpaRepo  extends JpaRepository<Expense,Long> {
	
	List<Expense> findByUsername(String username);
	List<Expense> findBycategoryContainingIgnoreCase(String category);
	
}

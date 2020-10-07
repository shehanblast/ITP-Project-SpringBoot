package com.in28minutes.rest.webservices.restfulwebservices.supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierJpaRepo extends JpaRepository<Supplier,Long> {

    List<Supplier> findByUsername(String username);
}

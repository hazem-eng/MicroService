package com.stage.microservices.matrice.repository;

import com.stage.microservices.matrice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

}

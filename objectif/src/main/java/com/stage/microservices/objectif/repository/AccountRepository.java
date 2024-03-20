package com.stage.microservices.objectif.repository;

import com.stage.microservices.objectif.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}

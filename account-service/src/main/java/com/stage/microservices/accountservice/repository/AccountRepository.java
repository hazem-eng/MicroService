package com.stage.microservices.accountservice.repository;

import com.stage.microservices.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}

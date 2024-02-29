package com.stage.microservices.accountservice.entities;

import com.stage.microservices.accountservice.enums.AccountType;

import com.stage.microservices.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Builder
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    //ignore : c'est un attribut qui exist dans la classe mais qui n'est pas réprésenté dans la DB
    @Transient
    private Customer customer ;
    private Long customerId;

}

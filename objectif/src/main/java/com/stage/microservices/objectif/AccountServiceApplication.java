package com.stage.microservices.objectif;

import com.stage.microservices.objectif.clients.CustomerRestClient;
import com.stage.microservices.objectif.entities.Account;
import com.stage.microservices.objectif.enums.AccountType;
import com.stage.microservices.objectif.model.Customer;
import com.stage.microservices.objectif.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient){
        return args -> {
            List<Customer> allCustomers = customerRestClient.allCustomers();
            allCustomers.forEach(customer -> {
                for (AccountType accountType:AccountType.values()){
                    Account account = Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("MAD")
                            .balance(Math.random()*80000).createAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(customer.getId())
                            .build();
                            accountRepository.save(account);

                    Account account1 = Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("MAD")
                            .balance(Math.random()*65432).createAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(customer.getId())
                            .build();
                    accountRepository.save(account1);
                }

            });

        };



    }


}

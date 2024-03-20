package com.stage.microservices.objectif.web;

import com.stage.microservices.objectif.clients.CustomerRestClient;
import com.stage.microservices.objectif.entities.Account;
import com.stage.microservices.objectif.model.Customer;
import com.stage.microservices.objectif.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountRepository accountRepository;

    private CustomerRestClient customerRestClient;

    public AccountRestController(AccountRepository accountRepository , CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient=customerRestClient;
    }
    @GetMapping("/accounts")
    public List<Account> accountList(){
        List<Account> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        });
        return accountList;
    }
    @GetMapping("/accounts/{id_Account}")
    public Account ConsultAccount(@PathVariable String id_Account){
        /*Account account= accountRepository.findById(id_Account).get();
        Customer customer=customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;*/

        Account account= accountRepository.findById(id_Account).get();{
            Customer customer=customerRestClient.findCustomerById(account.getCustomerId());
            account.setCustomer(customer);
            return account;

        }
    }
}

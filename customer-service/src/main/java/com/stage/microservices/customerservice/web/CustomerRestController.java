package com.stage.microservices.customerservice.web;

import com.stage.microservices.customerservice.entities.Customer;
import com.stage.microservices.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerRepository customerRepository;

        public CustomerRestController (CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }
    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }



    }




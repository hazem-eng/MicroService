package com.stage.microservices.customerservice;

import com.stage.microservices.customerservice.config.GlobalConfig;
import com.stage.microservices.customerservice.entities.Customer;
import com.stage.microservices.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> listCustomers = List.of(
                    Customer.builder()
                            .firstName("Ali")
                            .lastName("ali").email("Ali@gmail.com").build(),
                    Customer.builder().firstName("Hazem")
                            .lastName("chtioui")
                            .email("Hazem.chtioui@esprit.tn")
                            .build()
            )

                    ;
            customerRepository.saveAll(listCustomers);



        };



        }
    }




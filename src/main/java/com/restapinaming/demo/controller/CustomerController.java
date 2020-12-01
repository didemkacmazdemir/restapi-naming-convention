package com.restapinaming.demo.controller;

import com.restapinaming.demo.error.CustomerNotFoundException;
import com.restapinaming.demo.model.Customer;
import com.restapinaming.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    // Find
    @GetMapping("/customers")
    List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Save
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    // Find
    @GetMapping("/customers/{id}")
    Customer findOne(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    // Save or update
    @PutMapping("/customers/{id}")
    Customer saveOrUpdate(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return customerRepository.findById(id)
                .map(x -> {
                    x.setName(newCustomer.getName());
                    x.setSurname(newCustomer.getSurname());
                    return customerRepository.save(x);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });
    }


    @DeleteMapping("/customers/{id}")
    void deleteBook(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}

package com.technumen.newcustapp.controller;

import com.technumen.newcustapp.model.Customer;
import com.technumen.newcustapp.repository.CustRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewcustappController {
    private final CustRepository repository;

    NewcustappController(CustRepository repository) {
        this.repository = repository;
    }

    //Create
    @PostMapping("/")
    public Customer createUser(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    //Read
    @GetMapping("/")
    List<Customer> all() {
        return repository.findAll();
    }

    //Update
    @PutMapping("/{id}")
    public Customer updateUser(@RequestBody Customer customer, @PathVariable Long id) {
        return repository.findById(id)
                .map(cust -> {
                    cust.setFirstName(customer.getFirstName());
                    cust.setLastName(customer.getLastName());
                    return repository.save(cust);
                })
                .orElseGet(() -> {return repository.save(customer);
                });
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

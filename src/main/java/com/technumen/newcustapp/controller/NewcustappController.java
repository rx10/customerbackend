package com.technumen.newcustapp.controller;

import com.technumen.newcustapp.model.Customer;
import com.technumen.newcustapp.repository.CustRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://apifrontend.up.railway.app")
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

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Update
    @PutMapping("/{id}")
    public Customer updateUser(@RequestBody Customer customer, @PathVariable Long id) {
        return repository.findById(id)
                .map(cust -> {
                    cust.setFirstName(customer.getFirstName());
                    cust.setLastName(customer.getLastName());
                    cust.setId(customer.getId());
                    return repository.save(cust);
                })
                .orElseGet(() -> repository.save(customer));
    }

    //Delete
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
package com.technumen.newcustapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "custable")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int z) {
        this.id = z;
    }

    public void setFirstName(String x) {
        this.firstName = x;
    }

    public void setLastName(String y) {
        this.lastName = y;
    }
}


package com.technumen.newcustapp.repository;

import com.technumen.newcustapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustRepository extends JpaRepository<Customer,Long>{
}

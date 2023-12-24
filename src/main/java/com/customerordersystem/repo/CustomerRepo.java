package com.customerordersystem.repo;

import com.customerordersystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Customer findByCustomerEmail(String customerEmail);

}

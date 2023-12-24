package com.customerordersystem.service.impl;

import com.customerordersystem.dto.CustomerRequest;
import com.customerordersystem.entity.Customer;
import com.customerordersystem.exc.GlobalException;
import com.customerordersystem.repo.CustomerRepo;
import com.customerordersystem.service.inter.CustomerInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerInterface {

    private final CustomerRepo customerRepo;
    @Override
    public Customer retrieveCustomer(CustomerRequest customerRequest) {
        if (customerRequest.getCustomerEmail() == null){
            throw new GlobalException("Email cannot be null");
        }
        Customer customer = customerRepo.findByCustomerEmail(customerRequest.getCustomerEmail());
        if (customer != null){
            return customer;
        }
        else {
            Customer customer1 = new Customer();
            customer1.setCustomerName(customerRequest.getCustomerName());
            customer1.setCustomerEmail(customerRequest.getCustomerEmail());
            customerRepo.save(customer1);
            return customer1;
        }
    }
}

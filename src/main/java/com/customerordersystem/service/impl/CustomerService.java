package com.customerordersystem.service.impl;

import com.customerordersystem.dto.CustomerRequest;
import com.customerordersystem.dto.constants.UserRoles;
import com.customerordersystem.entity.Contact;
import com.customerordersystem.entity.Customer;
import com.customerordersystem.exc.GlobalException;
import com.customerordersystem.repo.ContactRepo;
import com.customerordersystem.repo.CustomerRepo;
import com.customerordersystem.service.inter.CustomerInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerInterface {

    private final CustomerRepo customerRepo;
    private final ContactRepo contactRepo;
    private final PasswordEncoder passwordEncoder;
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
            customer1.setCustomerPsw(passwordEncoder.encode(customer1.getCustomerPsw()));
            if (customerRequest.getCustomerEmail().endsWith("@gmail.com")){
                customer1.setRoles(UserRoles.CUSTOMER);
            }
            customerRepo.save(customer1);

            Contact contact = new Contact();
            contact.setContacts(customerRequest.getMobile_numbers());
            contact.setCustomer(customer1);
            contactRepo.save(contact);

            return customer1;
        }
    }
}

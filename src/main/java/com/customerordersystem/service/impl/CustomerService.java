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
import org.thymeleaf.util.StringUtils;


@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerInterface {

    private final CustomerRepo customerRepo;
    private final ContactRepo contactRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Customer retrieveCustomer(CustomerRequest customerRequest) {
        if (StringUtils.isEmptyOrWhitespace(customerRequest.getCustomerEmail())||StringUtils.isEmptyOrWhitespace(customerRequest.getCustomerName())
                ||StringUtils.isEmptyOrWhitespace(customerRequest.getCustomerPsw())||StringUtils.isEmptyOrWhitespace(customerRequest.getMobile_numbers())
        ){
            throw new GlobalException("All fields are required");
        }

        Customer customer = customerRepo.findByCustomerEmail(customerRequest.getCustomerEmail());
        if (customer != null){
            return customer;
        }
        else {
            Customer newCustomer = new Customer();
            newCustomer.setCustomerName(customerRequest.getCustomerName());
            newCustomer.setCustomerEmail(customerRequest.getCustomerEmail());
            newCustomer.setCustomerPsw(passwordEncoder.encode(newCustomer.getCustomerPsw()));
            if (customerRequest.getCustomerEmail().endsWith("@gmail.com")){
                newCustomer.setRoles(UserRoles.CUSTOMER);
            }
            customerRepo.save(newCustomer);

            Contact contact = new Contact();
            contact.setContacts(customerRequest.getMobile_numbers());
            contact.setCustomer(newCustomer);
            contactRepo.save(contact);

            return newCustomer;
        }
    }

}

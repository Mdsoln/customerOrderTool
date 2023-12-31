package com.customerordersystem.service.inter;

import com.customerordersystem.dto.CustomerRequest;
import com.customerordersystem.entity.Customer;

public interface CustomerInterface {
    Customer retrieveCustomer(CustomerRequest customerRequest);

}

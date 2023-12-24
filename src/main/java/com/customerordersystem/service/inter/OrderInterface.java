package com.customerordersystem.service.inter;


import com.customerordersystem.dto.CustomerRequest;

public interface OrderInterface {
    void saveOrders(CustomerRequest customerRequest);

}

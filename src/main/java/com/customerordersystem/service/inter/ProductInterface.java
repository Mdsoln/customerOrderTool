package com.customerordersystem.service.inter;

import com.customerordersystem.dto.CustomerRequest;
import com.customerordersystem.entity.Product;

public interface ProductInterface {
    Product retrieveProducts(CustomerRequest customerRequest);

}

package com.customerordersystem.service.impl;

import com.customerordersystem.dto.CustomerRequest;
import com.customerordersystem.entity.Product;
import com.customerordersystem.repo.ProductRepo;
import com.customerordersystem.service.inter.ProductInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductInterface {
    private final ProductRepo productRepo;
    @Override
    public Product retrieveProducts(CustomerRequest customerRequest) {
//        for existing products
        Product product = productRepo.findByProductName(customerRequest.getProductName());
        if (product != null){
            return product;
        }
        else{
//            for new product ordered by the customer
            Product product1 = new Product();
            product1.setProductName(customerRequest.getProductName());
            product1.setProductPrice(customerRequest.getProductPrice());
            productRepo.save(product1);
            return product1;
        }
    }
}

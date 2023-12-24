package com.customerordersystem.service;

import com.customerordersystem.exc.GlobalException;
import com.customerordersystem.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final CustomerRepo customerRepo;

    public List<Object[]> findCustomerWithOrderedProducts() {
        List<Object[]> orders = customerRepo.findCustomerWithOrderedProducts();
        if (orders == null){
            throw new GlobalException("Oops! no orders by now");
        }
        return orders;
    }
}

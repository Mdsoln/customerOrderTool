package com.customerordersystem.service.impl;

import com.customerordersystem.dto.CustomerRequest;
import com.customerordersystem.entity.Customer;
import com.customerordersystem.entity.Order;
import com.customerordersystem.entity.Product;
import com.customerordersystem.repo.OrderRepo;
import com.customerordersystem.service.inter.OrderInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderService implements OrderInterface {

    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderRepo orderRepo;
    @Override
    public void saveOrders(CustomerRequest customerRequest) {
        Customer customer = customerService.retrieveCustomer(customerRequest);

        Product product = productService.retrieveProducts(customerRequest);

        /*LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String orderDate = customerRequest.getOrderDate().format(dateTimeFormatter);*/
        Order order = new Order();
        order.setOrderDate(customerRequest.getOrderDate());
        order.setCustomer(customer);
        order.setProduct(product);
        orderRepo.save(order);
    }
}

package com.customerordersystem.repo;

import com.customerordersystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Customer findByCustomerEmail(String customerEmail);

    /**
     * Querying customer with their ordered products
     */
    @Query("SELECT c.customerName,c.customerEmail,p.productName,o.orderDate" +
            " FROM Customer c "+
            " JOIN c.orders o "+
            " JOIN o.product p"
    )
    List<Object[]> findCustomerWithOrderedProducts();
}

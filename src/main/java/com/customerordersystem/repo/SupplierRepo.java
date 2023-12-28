package com.customerordersystem.repo;

import com.customerordersystem.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Long> {

    Supplier findBySupplierEmail(String username);

}

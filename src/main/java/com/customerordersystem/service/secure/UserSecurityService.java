package com.customerordersystem.service.secure;

import com.customerordersystem.dto.constants.UserRoles;
import com.customerordersystem.entity.Customer;
import com.customerordersystem.entity.Supplier;
import com.customerordersystem.repo.CustomerRepo;
import com.customerordersystem.repo.SupplierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final CustomerRepo customerRepo;
    private final SupplierRepo supplierRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepo.findByCustomerEmail(username);
        if (customer != null){
            return userDetails(customer.getCustomerEmail(),customer.getCustomerPsw(),customer.getRoles());
        }

        Supplier supplier = supplierRepo.findBySupplierEmail(username);
        if (supplier != null){
            return userDetails(supplier.getSupplierEmail(),supplier.getSupplierPsw(),supplier.getRoles());
        }
        throw new UsernameNotFoundException("Oops! user not found");
    }

    private UserDetails userDetails (String username, String password, UserRoles userRoles){
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userRoles.name()));

        return new org.springframework.security.core.userdetails.User(
                username,
                password,
                authorities
        );
    }
}

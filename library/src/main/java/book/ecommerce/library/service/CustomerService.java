package book.ecommerce.library.service;


import book.ecommerce.library.model.Customer;
import book.ecommerce.library.web.dto.CustomerRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService extends UserDetailsService{
    Customer save(CustomerRegistrationDto registrationDto);//For insert
    Customer save(Customer customer);//For update
    Customer findByUsername(String username);
    Customer findById(Long id);
    List<Customer> findAll();

    List<Customer> topMostOrderedCustomers(int top);
}

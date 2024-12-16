package book.ecommerce.library.service;


import book.ecommerce.library.model.User;
import book.ecommerce.library.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
    User findByUsername(String username);

    List<User> findAll();
}

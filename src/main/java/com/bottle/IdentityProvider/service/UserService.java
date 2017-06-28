package com.bottle.IdentityProvider.service;
import com.bottle.IdentityProvider.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by AKuzmanoski on 21/06/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 21/06/2017
 */
public interface UserService extends UserDetailsService, CrudService<User, Long> {
    User findByUsername(String username);
}

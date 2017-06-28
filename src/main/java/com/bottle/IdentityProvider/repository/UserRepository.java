package com.bottle.IdentityProvider.repository;

import com.bottle.IdentityProvider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by AKuzmanoski on 26/05/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 26/05/2017
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String email);
}

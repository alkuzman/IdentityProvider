package com.bottle.IdentityProvider.service.impl;

import com.bottle.IdentityProvider.model.User;
import com.bottle.IdentityProvider.repository.UserRepository;
import com.bottle.IdentityProvider.service.CrudAbstractService;
import com.bottle.IdentityProvider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKuzmanoski on 21/06/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 21/06/2017
 */
@Service
public class UserServiceImpl extends CrudAbstractService<User, Long> implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByUsername(s);
        if (user != null) {
            SimpleGrantedAuthority role = new SimpleGrantedAuthority(user.getRole().toString());
            List<SimpleGrantedAuthority> roles = new ArrayList<>();
            roles.add(role);
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
        }
        return new org.springframework.security.core.userdetails.User(s, "randompasswordas123", new ArrayList<SimpleGrantedAuthority>());
    }

    @Override
    public User add(User object) {
        return this.save(object);
    }
}

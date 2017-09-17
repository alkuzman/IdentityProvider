package com.bottle.IdentityProvider.config;

import com.bottle.IdentityProvider.model.Role;
import com.bottle.IdentityProvider.model.TelephoneNumber;
import com.bottle.IdentityProvider.model.User;
import com.bottle.IdentityProvider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by AKuzmanoski on 26/05/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 26/05/2017
 */
@Component
public class UserInit {
    private final PasswordEncoder encoder;

    private final UserService userService;

    @Autowired
    public UserInit(PasswordEncoder encoder, UserService userService) {
        this.encoder = encoder;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {

        User admin = userService.findByUsername("admin@identity.com");
        if (admin == null) {
            admin = new User();
            admin.setEmail("admin@identity.com");
            admin.setUsername("admin@identity.com");
            admin.setPassword(encoder.encode("admin"));
            admin.setRole(Role.ADMINISTRATOR);
            admin.setName("admin");
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setAddress("Macedonia");
            TelephoneNumber telephoneNumber = new TelephoneNumber();
            telephoneNumber.setCountryCode("389");
            telephoneNumber.setNumber("77752584");
            admin.setTelephoneNumber(telephoneNumber);
            admin.setProfileImage("http://www.propertygaon.com/Public/Image/avatar_2x.jpg");
            userService.save(admin);
        }

    }
}

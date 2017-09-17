package com.bottle.IdentityProvider.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Created by AKuzmanoski on 17/09/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 17/09/2017 22:45
 */
public class AuditorAwareImpl implements AuditorAware<User> {
    @Override
    public User getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return ((User)authentication.getPrincipal());
    }
}

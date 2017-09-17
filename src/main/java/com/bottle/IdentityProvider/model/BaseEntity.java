package com.bottle.IdentityProvider.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

/**
 * Created by AKuzmanoski on 17/09/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 17/09/2017 21:32
 */
@MappedSuperclass
public class BaseEntity extends Auditable<User> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

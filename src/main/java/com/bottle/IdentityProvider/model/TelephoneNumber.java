package com.bottle.IdentityProvider.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by AKuzmanoski on 17/09/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 17/09/2017 21:28
 */
@Entity
@Table(name = "TelephoneNumber")
public class TelephoneNumber extends BaseEntity {
    @NotNull
    @Column(name = "country_code")
    private String countryCode;
    @NotNull
    @Column(name = "number")
    private String number;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

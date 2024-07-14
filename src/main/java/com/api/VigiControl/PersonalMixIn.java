package com.api.VigiControl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public abstract class PersonalMixIn {
     @JsonIgnore
        abstract Collection<? extends GrantedAuthority> getAuthorities();

}

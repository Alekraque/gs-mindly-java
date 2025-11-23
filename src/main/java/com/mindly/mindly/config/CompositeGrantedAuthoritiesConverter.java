package com.mindly.mindly.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.stream.Collectors;

public class CompositeGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private static final String ROLES_CLAIM = "scp";
    private static final String ROLE_PREFIX = "ROLE_";
    private static final String SCOPE_PREFIX = "SCOPE_";

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {

        Collection<String> claims = jwt.getClaimAsStringList(ROLES_CLAIM);

        if (claims == null) {
            return java.util.Collections.emptyList();
        }

        return claims.stream()
                .map(claim -> {
                    if (claim.startsWith(ROLE_PREFIX)) {
                        return new SimpleGrantedAuthority(claim);
                    } else {
                        return new SimpleGrantedAuthority(SCOPE_PREFIX + claim);
                    }
                })
                .collect(Collectors.toList());
    }
}

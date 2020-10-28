package br.com.bootcamp01templateecommerce.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsMapper {

	UserDetails map(Object shouldBeASystemUser);
}
package br.com.bootcamp01templateecommerce.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsMapper {

	UserDetails map(Object shouldBeASystemUser);
}
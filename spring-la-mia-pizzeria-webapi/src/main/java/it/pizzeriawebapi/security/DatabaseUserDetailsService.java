package it.pizzeriawebapi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import it.pizzeriawebapi.model.User;
import it.pizzeriawebapi.repository.UserRepository;

public class DatabaseUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> utente = userRepository.findByUsername(username);
		
		if(utente.isPresent()) {
			return new DatabaseUserDetails(utente.get());
		} else {
			throw new UsernameNotFoundException("Utente non trovato");
		}
		
	}

}


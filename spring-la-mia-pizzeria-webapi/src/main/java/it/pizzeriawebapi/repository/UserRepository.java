package it.pizzeriawebapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeriawebapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}

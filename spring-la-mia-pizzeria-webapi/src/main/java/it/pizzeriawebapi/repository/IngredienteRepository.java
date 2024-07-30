package it.pizzeriawebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeriawebapi.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
	
}
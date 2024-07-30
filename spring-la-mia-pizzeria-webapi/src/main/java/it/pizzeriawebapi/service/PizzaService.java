package it.pizzeriawebapi.service;

import java.util.Optional;

import it.pizzeriawebapi.model.Pizza;

public interface PizzaService {

	public Optional<Pizza> findById(Integer id);

	public Pizza save(Pizza pizza);
	
	public Pizza update(Integer id, Pizza pizza);
	
	public void delete(Integer id);
}
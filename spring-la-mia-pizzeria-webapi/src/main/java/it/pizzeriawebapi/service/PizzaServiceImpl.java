package it.pizzeriawebapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pizzeriawebapi.model.Pizza;
import it.pizzeriawebapi.repository.PizzaRepository;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Override
	public Optional<Pizza> findById(Integer id) {
		return pizzaRepository.findById(id);
	}

	@Override
	public Pizza save(Pizza pizza) {
		
		return pizzaRepository.save(pizza);
	}

	@Override
	public Pizza update(Integer id, Pizza inputPizza) {
		
		Optional<Pizza> pizzaCercata = pizzaRepository.findById(id);
		
		if(pizzaCercata.isEmpty()) {
			throw new IllegalArgumentException("La pizza cercata con id " + id + " non esiste");
		}
		
		Pizza pizza = pizzaCercata.get();
		
		pizza.setName(inputPizza.getName());
		pizza.setDescrizione(inputPizza.getDescrizione());
		pizza.setPrezzo(inputPizza.getPrezzo());
		pizza.setOfferte(inputPizza.getOfferte());
		pizza.setIngredienti(inputPizza.getIngredienti());
		return pizzaRepository.save(pizza);
	}

	@Override
	public void delete(Integer id) {
		pizzaRepository.deleteById(id);
	}

}

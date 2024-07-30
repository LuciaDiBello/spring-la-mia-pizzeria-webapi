package it.pizzeriawebapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.pizzeriawebapi.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	
	List<Pizza> findByName(String name);
}
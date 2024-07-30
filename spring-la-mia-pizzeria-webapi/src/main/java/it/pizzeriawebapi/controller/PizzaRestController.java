package it.pizzeriawebapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pizzeriawebapi.model.Pizza;
import it.pizzeriawebapi.response.Payload;
import it.pizzeriawebapi.service.PizzaService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/index")
public class PizzaRestController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("{id}")
	public ResponseEntity<Payload<Pizza>> get(@PathVariable("id") Integer idPizza) {
		
		Optional<Pizza> pizza = pizzaService.findById(idPizza);
		
		if(pizza.isPresent()) {
			return ResponseEntity.ok(new Payload<Pizza>(pizza.get(), null, HttpStatus.OK));
		} else {
			return new ResponseEntity<Payload<Pizza>>(
					new Payload<Pizza>(null, "Pizza con id " + idPizza + " non trovato", 
					HttpStatus.NOT_FOUND), 
					HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	
	@PostMapping
	public ResponseEntity store( @Valid @RequestBody Pizza pizza) {
		try { 
			   Pizza pizzaSalvata = pizzaService.save(pizza);
			   return ResponseEntity.ok(pizzaSalvata);
		} catch(Exception e) {
			   return new ResponseEntity<>("Errore nel salvataggio della pizza", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Integer idPizza, @Valid @RequestBody Pizza pizza) {
		
		try {
				Pizza pizzaUpdated = pizzaService.update(idPizza, pizza);
				return ResponseEntity.ok(pizzaUpdated);
		} catch(IllegalArgumentException e) {
				return new ResponseEntity<>(e.getMessage(), 
					HttpStatus.NOT_FOUND);
		} catch(Exception e) {
				return new ResponseEntity<>("Errore nel salvataggio della pizza", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
				pizzaService.delete(id);
				return ResponseEntity.ok("Cancellazione effettuata");
		} catch(Exception e) {
				return new ResponseEntity<>("Errore nel salvataggio della pizza", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
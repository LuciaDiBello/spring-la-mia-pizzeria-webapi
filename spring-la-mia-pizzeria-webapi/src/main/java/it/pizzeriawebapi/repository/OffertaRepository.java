package it.pizzeriawebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeriawebapi.model.Offerta;

public interface OffertaRepository extends JpaRepository<Offerta, Integer> {

}

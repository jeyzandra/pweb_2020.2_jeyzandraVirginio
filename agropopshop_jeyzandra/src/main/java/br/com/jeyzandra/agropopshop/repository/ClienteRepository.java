package br.com.jeyzandra.agropopshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeyzandra.agropopshop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	

}

package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

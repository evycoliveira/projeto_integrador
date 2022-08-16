package br.com.dh.meli.projeto_integrador.repository;

import br.com.dh.meli.projeto_integrador.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}

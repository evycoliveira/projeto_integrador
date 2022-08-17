package br.com.dh.meli.projeto_integrador.repository;

import br.com.dh.meli.projeto_integrador.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Customer Repository
 *
 * @author Evelyn Cristini Oliveira
 */

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}

package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.model.Customer;

public interface ICustomerService {
    Customer getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    Customer createCustomer(CustomerDTO dto);
    Customer updateCustomer(Customer customer);
    Boolean deleteCustomer(Customer customer);
}

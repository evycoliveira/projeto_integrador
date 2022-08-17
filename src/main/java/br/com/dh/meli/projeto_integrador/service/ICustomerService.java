package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    Customer createCustomer(CustomerDTO dto);
    Customer updateCustomer(CustomerDTO customerDto, Long customerId);
    void deleteCustomer(Long id);
}

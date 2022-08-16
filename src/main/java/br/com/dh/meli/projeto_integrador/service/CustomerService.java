package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.exception.PreconditionFailedException;
import br.com.dh.meli.projeto_integrador.mapper.ICustomerMapper;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository repo;

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customer = repo.findById(customerId);
        if(customer.isEmpty()) {
            throw new PreconditionFailedException("Customer doesn't exists");
        }
        return customer.get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = ICustomerMapper.MAPPER.mappingCostumerDTOToCostumerModel(customerDTO);
        return repo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        getCustomerById(customer.getId());
        return repo.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        getCustomerById(id);
        repo.deleteById(id);
    }
}

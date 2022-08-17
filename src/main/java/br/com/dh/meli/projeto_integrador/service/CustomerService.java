package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.exception.PreconditionFailedException;
import br.com.dh.meli.projeto_integrador.mapper.ICustomerMapper;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for Customer Repository
 * @author Evelyn Cristini Oliveira
 */
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository repo;

    /**
     * Get customer by id
     *
     * @param customerId payload of contents for get new customer
     * @return Customer
     * @author Evelyn Cristini Oliveira
     */
    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customer = repo.findById(customerId);
        if(customer.isEmpty()) {
            throw new PreconditionFailedException("Customer doesn't exists");
        }
        return customer.get();
    }

    /**
     * Save customer
     *
     * @param customer payload of contents for save new customer
     * @return Customer
     * @author Evelyn Cristini Oliveira
     */
    @Override
    public Customer saveCustomer(Customer customer) {
        return repo.save(customer);
    }

    /**
     * Create customer
     *
     * @param  customerDTO payload of contents for create customer
     * @return Customer
     * @author Evelyn Cristini Oliveira
     */
    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = ICustomerMapper.MAPPER.mappingCostumerDTOToCostumerModel(customerDTO);
        customer.setName(customerDTO.getName());
        return repo.save(customer);
    }

    /**
     * Update customer
     *
     * @param  customerDto payload of contents for update customer
     * @param  customerId payload of contents for update customer
     * @return Customer
     * @author Evelyn Cristini Oliveira
     */
    @Override
    public Customer updateCustomer(CustomerDTO customerDto, Long customerId) {
        getCustomerById(customerId);
        Customer customer = ICustomerMapper.MAPPER.mappingCostumerDTOToCostumerModel(customerDto);
        customer.setName(customerDto.getName());
        return repo.save(customer);
    }

    /**
     * Delete customer
     *
     * @param  id payload of contents for update customer
     * @return void
     * @author Evelyn Cristini Oliveira
     */
    @Override
    public void deleteCustomer(Long id) {
        getCustomerById(id);
        repo.deleteById(id);
    }
}

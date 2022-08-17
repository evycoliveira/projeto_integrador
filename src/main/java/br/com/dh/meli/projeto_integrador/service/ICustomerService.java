package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.model.Customer;

/**
 * Country Service
 * @author Evelyn Cristini Oliveira
 */

public interface ICustomerService {

    /**
     * Get customer by id
     *
     * @param id payload of contents for get customer by id
     * @return Long
     * @author Evelyn Cristini Oliveira
     */
    Customer getCustomerById(Long id);

    /**
     * Save customer
     *
     * @param customer payload of contents for customer
     * @return Customer
     * @author Evelyn Cristini Oliveira
     */
    Customer saveCustomer(Customer customer);

    /**
     * Create customer
     *
     * @param dto payload of contents for post customer
     * @return Customer
     * @author Evelyn Cristini Oliveira
     */
    Customer createCustomer(CustomerDTO dto);

    /**
     * Update customer
     *
     * @param customerDto payload of contents for put customerId
     * @param customerId payload of contents for put customerId
     * @return CustomerDTO
     * @author Evelyn Cristini Oliveira
     */
    Customer updateCustomer(CustomerDTO customerDto, Long customerId);

    /**
     * Delete customer
     *
     * @param id payload of contents for delete customerId
     * @return void
     * @author Evelyn Cristini Oliveira
     */
    void deleteCustomer(Long id);
}

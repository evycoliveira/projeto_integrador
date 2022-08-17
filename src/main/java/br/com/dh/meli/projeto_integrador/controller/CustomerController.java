package br.com.dh.meli.projeto_integrador.controller;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService service;

    /**
     * Get customer by customer ID
     *
     * @param customerId customer ID
     * @return ResponseEntity<Customer>
     * @author Evelyn Cristini Oliveira
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }

    /**
     * Put customer by customer ID
     *
     * @param customerDTO customer DTO
     * @param customerId  customer ID
     * @return ResponseEntity<Customer>
     * @author Evelyn Cristini Oliveira
     */
    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid CustomerDTO customerDTO,
                                                   @PathVariable @Valid @NotNull Long customerId) {
        Customer result = service.updateCustomer(customerDTO, customerId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * Post a new customer
     *
     * @param customer payload for add new customer
     * @return ResponseEntity<Customer>
     * @author Evelyn Cristini Oliveira
     */
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDTO customer) {
        Customer result = service.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * Delete customer by customer ID
     *
     * @param customerId customer ID
     * @return ResponseEntity<Void>
     * @author Evelyn Cristini Oliveira
     */
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        service.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

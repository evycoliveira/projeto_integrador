package br.com.dh.meli.projeto_integrador.controller;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService service;

    // TODO: GET para consultar customers
    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    // TODO: PUT para atualizar os customers

    // TODO: POST para cadastrar customers
    @PostMapping("/registerCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDTO customer) {
        Customer result = service.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // TODO: DELETE para deletar customers
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.exception.PreconditionFailedException;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.repository.ICustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

/**
 * Class of Customer Service layer Unit Test
 *
 * @author Evelyn Cristini Oliveira
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService service;

    @Mock
    private ICustomerRepository repo;

    /**
     * Test to create customer with valid content
     *
     * @author Evelyn Cristini Oliveira
     */
    @DisplayName("Create new Customer when customerName is valid")
    @Test
    void createCustomer_returnSuccessfully_whenValidCustomerName() {
        Customer newCustomer = Customer.builder().build();
        newCustomer.setId(1L);
        newCustomer.setName("Alexandre Borges");
        when(repo.save(ArgumentMatchers.any(Customer.class))).thenReturn(newCustomer);
        CustomerDTO dto = CustomerDTO.builder().build();
        dto.setName("Alexandre Borges");
        Customer result = service.createCustomer(dto);
        assertThat(result.getName()).isNotNull();
        verify(repo,times(1)).save(ArgumentMatchers.any(Customer.class));
    }

    /**
     * Test to get customer ID with valid customer ID
     *
     * @author Evelyn Cristini Oliveira
     */
    @DisplayName("Get Customer by id when customerId is valid")
    @Test
    void getCustomerById_returnSuccessfully_whenValidCustomerId() {
        Customer newCustomer = Customer.builder().build();
        newCustomer.setId(1L);
        newCustomer.setName("Alexandre Borges");
        when(repo.findById(1L)).thenReturn(Optional.of(newCustomer));
        Customer customer = service.getCustomerById(1L);
        assertThat(customer.getName()).isNotNull();
        verify(repo, times(1)).findById(1L);
    }

    /**
     * Test to get customer by ID with invalid customer ID
     *
     * @author Evelyn Cristini Oliveira
     */
    @DisplayName("Get Customer by id when customerId is invalid")
    @Test
    void getCustomerById_returnUnsucessfully_whenInvalidCustomerId() {
        when(repo.findById(1L)).thenReturn(Optional.ofNullable(null));
        PreconditionFailedException exception = assertThrows(PreconditionFailedException.class, () ->service.getCustomerById(1L));
        assertThat(exception.getMessage()).isNotNull();
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.PRECONDITION_FAILED);
    }

    /**
     * Test to put customer by ID with valid customer ID
     *
     * @author Evelyn Cristini Oliveira
     */
    @DisplayName("Put Customer by id when customerId is valid")
    @Test
    void putCustomerById_returnSuccessfully_whenValidCustomerId() {
        Customer newCustomer = Customer.builder().build();
        newCustomer.setId(1L);
        newCustomer.setName("Alexandre Borges");
        when(repo.findById(1L)).thenReturn(Optional.of(newCustomer));
        when(repo.save(ArgumentMatchers.any(Customer.class))).thenReturn(newCustomer);
        CustomerDTO dto = new CustomerDTO("Evelyn Oliveira");
        Customer customer = service.updateCustomer(dto, 1L);
        assertThat(customer).isNotNull();
        verify(repo, times(1)).findById(1L);
    }

    /**
     * Test to save customer by ID with valid customer ID
     *
     * @author Evelyn Cristini Oliveira
     */
    @DisplayName("Save Customer when customer is customer")
    @Test
    void saveCustomerById_returnSuccessfully_whenValidCustomer() {
        Customer newCustomer = Customer.builder().build();
        newCustomer.setId(1L);
        newCustomer.setName("Alexandre Borges");
        when(repo.save(ArgumentMatchers.any(Customer.class))).thenReturn(newCustomer);
        Customer result = service.saveCustomer(newCustomer);
        assertThat(result.getName()).isNotNull();
        verify(repo,times(1)).save(ArgumentMatchers.any(Customer.class));
    }

    /**
     * Test to delete customer by ID with invalid customer ID
     *
     * @author Evelyn Cristini Oliveira
     */
    @DisplayName("Delete Customer by id when customerId is valid")
    @Test
    void deleteCustomerById_returnSuccessfully_whenValidCustomerId() {
        Customer newCustomer = Customer.builder().build();
        newCustomer.setId(1L);
        newCustomer.setName("Alexandre Borges");
        when(repo.findById(1L)).thenReturn(Optional.of(newCustomer));
        willDoNothing().given(repo).deleteById(1L);
        service.deleteCustomer(1L);
        verify(repo).deleteById(1L);
    }

    /**
     * Test to delete customer by ID with invalid customer ID
     *
     * @author Evelyn Cristini Oliveira
     */
    @DisplayName("Delete Customer by id when customerId is invalid")
    @Test
    void deleteCustomerById_returnUnsuccessfully_whenInvalidCustomerId() {
        when(repo.findById(1L)).thenReturn(Optional.ofNullable(null));
        PreconditionFailedException exception = assertThrows(PreconditionFailedException.class, () ->service.deleteCustomer(1L));
        assertThat(exception.getMessage()).isNotNull();
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.PRECONDITION_FAILED);
    }
}
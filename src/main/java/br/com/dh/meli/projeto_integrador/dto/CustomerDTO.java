package br.com.dh.meli.projeto_integrador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CustomerDTO {
    @NotNull(message = "Nome do cliente é obrigatório")
    @JsonProperty("customer_name")
    public String name;
    public Long shoppingCartId;
}

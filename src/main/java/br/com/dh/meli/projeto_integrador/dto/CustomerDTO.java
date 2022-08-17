package br.com.dh.meli.projeto_integrador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @NotNull(message = "Nome do cliente é obrigatório")
    @JsonProperty("customer_name")
    private String name;
}

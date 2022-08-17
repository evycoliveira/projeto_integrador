package br.com.dh.meli.projeto_integrador.mapper;

import br.com.dh.meli.projeto_integrador.dto.CustomerDTO;
import br.com.dh.meli.projeto_integrador.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapping Customer DTO to Model / Model to DTO
 *
 * @author Evelyn Cristini Oliveira
 */

@Mapper
public interface ICustomerMapper {
    ICustomerMapper MAPPER = Mappers.getMapper(ICustomerMapper.class);
    Customer mappingCostumerDTOToCostumerModel(CustomerDTO dto);
    CustomerDTO mappingCostumerModelToCostumerDTO(Customer costumer);
}

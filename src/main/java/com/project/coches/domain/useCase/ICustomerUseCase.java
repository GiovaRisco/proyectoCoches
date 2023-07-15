package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

/*
* Interface de CustomerService
* */
public interface ICustomerUseCase {

    List<CustomerDto> getAll();

    //Optional : Nos puede venir un objeto o nada
    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    ResponseCustomerDto save(CustomerDto newCustomer);

    Optional<CustomerDto> update(CustomerDto modifyCustomer);
    Boolean delete(String cardId);
}

package com.project.coches.domain.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {


    List<CustomerDto> getAll();

    //Optional : Nos puede venir un objeto o nada
    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto newCustomer);


    void delete(String cardId);
}

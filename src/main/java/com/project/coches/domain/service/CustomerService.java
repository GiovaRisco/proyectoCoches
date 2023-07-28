package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.useCase.ICustomerUseCase;
import com.project.coches.exception.CustomerExistException;
import com.project.coches.exception.EmailValidationException;
import com.project.coches.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/*
* Servicio del cliente
* */
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    /**
     * Guarda un nuevo cliente asignandole una nueva contraseña, colocandolo activo y rol por defecto
     * @param newCustomer
     * @return
     */
    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {
        //Validar que tenga formato de EMAIL
        if(!newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9_-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            throw  new EmailValidationException();
        }

        if(getCustomerByCardId(newCustomer.getCardId()).isPresent() || getCustomerByEmail(newCustomer.getEmail()).isPresent()){
            throw  new CustomerExistException();
        }
        String passwordGenerated = generatedRandomPassword(8);
        newCustomer.setPassword(passwordEncoder.encode(passwordGenerated));
        newCustomer.setActive(1);
        newCustomer.setRol(Roles.CUSTOMER);
        iCustomerRepository.save(newCustomer);

        return new ResponseCustomerDto(passwordGenerated);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {
        if (iCustomerRepository.getCustomerByCardId(modifyCustomer.getCardId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(modifyCustomer));

    }

    @Override
    public Boolean delete(String cardId) {
        if (iCustomerRepository.getCustomerByCardId(cardId).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(cardId);
        return true;
    }

    //Metodo para generar una contraseña alfanumerica aleatoria de una longitud especifica
    private String generatedRandomPassword(int len){
        //Rango ASCII - alfanumerico(8 - 9 , a- z , A - Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random  = new SecureRandom();
        StringBuilder sb  = new StringBuilder();

        //Cada iteracion del bucle elige aleatoriamente un caracter del dado
        //rango ASCII y lo agrega a la instancia 'StringBuilder'

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}

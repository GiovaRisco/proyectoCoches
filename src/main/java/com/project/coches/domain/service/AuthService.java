package com.project.coches.domain.service;

import com.project.coches.domain.dto.AuthCustomerDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.JwtResponseDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.useCase.IAuthUseCase;
import com.project.coches.exception.CustomerNotExistException;
import com.project.coches.exception.PasswordIncorrectException;
import com.project.coches.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthUseCase {

    private final ICustomerRepository iCustomerRepository;

    /**
     * Clase que administra los JWTs
     */
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Clase que encripta contraseñas
     */
    private final PasswordEncoder passwordEncoder;


    /**
     * Devuelve un dto con el jwt del usuario dadas unas credenciales
     * @param authCustomerDto Credenciales de acceso
     * @return Dto con el jwt del usuario si las credenciales son validas
     */
    @Override
    public JwtResponseDto signIn(AuthCustomerDto authCustomerDto) {

        Optional<CustomerDto> customer = iCustomerRepository.getCustomerByEmail(authCustomerDto.getEmail());

        if(customer.isEmpty()){
            throw  new CustomerNotExistException();
        }

        if(!passwordEncoder.matches(authCustomerDto.getPassword(), customer.get().getPassword())){
            throw  new PasswordIncorrectException();
        }

        return new JwtResponseDto(jwtAuthenticationProvider.createToken(customer.get()));
    }

    @Override
    public JwtResponseDto signOut(String token) {
        String[] authElements = token.split(" ");
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(token));
    }
}

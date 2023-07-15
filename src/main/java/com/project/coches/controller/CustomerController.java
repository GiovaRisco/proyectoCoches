package com.project.coches.controller;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerbyCardId(@PathVariable("cardId") String cardId){
        return  ResponseEntity.of(iCustomerUseCase.getCustomerByCardId(cardId));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerbyEmail(@PathVariable("email") String email){
        return  ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    @PostMapping
    public  ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto newCustomer){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerUseCase.save(newCustomer));

    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate){

        return  ResponseEntity.of( iCustomerUseCase.update(customerDtoUpdate));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable("cardId")String cardId){
        return new ResponseEntity<>(this.iCustomerUseCase.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


}

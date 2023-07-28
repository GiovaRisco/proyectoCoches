package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/*
* Dto del guardado de los carros de una compra
* */
@Getter
@Setter
public class CarPurchaseRequestDto {

    private Integer purchaseNumberBill;

    private Integer codeCar;

    private Integer cuantityCars;

    private Double totalPriceCars;
}

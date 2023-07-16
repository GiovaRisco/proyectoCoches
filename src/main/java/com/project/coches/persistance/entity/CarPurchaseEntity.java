package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

/*
 * Entity de coches_compras
 * */
@Entity
@Table(name = "coches_compras")
@Getter
@Setter
public class CarPurchaseEntity {

    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "cantidad")
    private Integer cuantityCars;

    @Column(name = "total")
    private Double totalPriceCars;

    @ManyToOne
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura",insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche",insertable = false, updatable = false)
    private CarEntity carEntity;
}

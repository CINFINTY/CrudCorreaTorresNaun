package com.everis.app.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tblProducto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProd")
    private int idProd;
    @Column(name = "nomProd",nullable = false, length = 20)
    private String nomProd;
    @Column(name = "precioProd", nullable = false)
    private double precioProd;
}

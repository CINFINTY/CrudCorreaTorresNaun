package com.everis.app.services;

import com.everis.app.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductService {

     List<Producto> listProduct();
     Producto saveProduct(Producto objProd);
     void deleteProduct(int id);
     void update(int id, Producto objProd);
     Producto listProductID(int id);

}

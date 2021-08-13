package com.everis.app.services;

import com.everis.app.modelo.Producto;

import java.util.List;

public interface IProductService {

     List<Producto> listProduct();
     Producto saveProduct(Producto objProd);
     void deleteProduct(int id);
     void update(int id, Producto objProd);
     Producto listProductID(int id);

}

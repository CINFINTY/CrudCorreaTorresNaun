package com.everis.app.controller;

import com.everis.app.modelo.Producto;
import com.everis.app.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")

public class ControllerProduct {
    private final IProductService servProd;

    @Autowired
     public ControllerProduct(IProductService servProd){this.servProd = servProd; }

    /*Metodo para listar todos los productos*/
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> listProducts(){
        List<Producto> listProds = servProd.listProduct();
        return new ResponseEntity<>(listProds,HttpStatus.OK);
    }

    /*Metodo para eliminar por ID*/
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Producto> deleteProduct(@PathVariable int id){
         servProd.deleteProduct(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Metodo para agregar un producto*/
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Producto> addProduct(@RequestBody Producto product){
        Producto prod = servProd.saveProduct(product);
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Product","/product/add/"+product.getIdProd());
        servProd.saveProduct(product);
        return new ResponseEntity<>(prod,cabecera, HttpStatus.CREATED);
    }

    /*Metodo para modificar un producto*/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Producto> editProduct(@PathVariable int id, @RequestBody Producto prod){
        servProd.update(id, prod);
        return new ResponseEntity<>(servProd.listProductID(id),HttpStatus.OK);
    }

}

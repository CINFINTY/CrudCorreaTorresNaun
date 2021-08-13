package com.everis.app.repository;

import com.everis.app.modelo.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Producto, Integer> {

}

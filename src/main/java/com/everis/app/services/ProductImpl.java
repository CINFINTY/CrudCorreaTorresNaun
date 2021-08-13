package com.everis.app.services;

import com.everis.app.modelo.Producto;
import com.everis.app.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProductImpl implements IProductService {

    private final IProductRepository prodRespos;
    @Autowired
    public ProductImpl(IProductRepository prod) {this.prodRespos = prod;}


    @Override
    public List<Producto> listProduct() {
        return (List<Producto>) prodRespos.findAll();
    }

    @Override
    public Producto saveProduct(Producto obj) {return prodRespos.save(obj);}

    @Override
    public void deleteProduct(int id) {prodRespos.deleteById(id);}

    @Override
    public void update(int id, Producto objProd) {
        Optional<Producto> op = prodRespos.findById(id);
        op.map(prod -> {
            prod.setNomProd(objProd.getNomProd());
            prod.setPrecioProd(objProd.getPrecioProd());
            return prodRespos.save(prod);
        });
                /*.orElseGet(() -> {
            objProd.setIdProd(id);
            return prodRespos.save(objProd);
        });

       /* Producto prodExt = prodRespos.findById(id).get();
        prodExt.setNomProd(objProd.getNomProd());
        prodExt.setPrecioProd(objProd.getPrecioProd());*/
        //prodRespos.save(prodExt);
    }

    @Override
    public Producto listProductID(int id) {
        return prodRespos.findById(id).get();
    }
}

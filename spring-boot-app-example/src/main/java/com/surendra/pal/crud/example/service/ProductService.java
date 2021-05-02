package com.surendra.pal.crud.example.service;

import com.surendra.pal.crud.example.entity.Product;
import com.surendra.pal.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    //to save the product
    public Product saveProduct( Product product ){
        return productRepository.save( product );
    }

    //to save the list of product
    public List<Product> saveProducts(List<Product> products ){
        return productRepository.saveAll( products );
    }

    //to get the list of product
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    //get the product by Id
    public Product getProductById(int id){
        return  productRepository.findById( id ).orElse( null );
    }

    //get the product by name
    public Product getProductByName(String name){
        return  productRepository.findByName( name );
    }

    //to delete the product by id
    public String deleteProduct(int id){
        productRepository.deleteById( id );
        return "product removed !!" + id;
    }

    //update the product
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById( product.getId() ).orElse( null );
        existingProduct.setName( product.getName() );
        existingProduct.setQuantity( product.getQuantity() );
        existingProduct.setPrice( product.getPrice() );
        return productRepository.save( existingProduct );
    }
}

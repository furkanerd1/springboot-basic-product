package com.furkan.productdemo.service;

import com.furkan.productdemo.model.Product;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product save(Product theProduct);

    void deleteProduct(int id);

}

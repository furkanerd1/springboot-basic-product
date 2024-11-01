package com.furkan.productdemo.service;

import com.furkan.productdemo.model.Product;
import com.furkan.productdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
    public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        if (!(productRepository.findAll().isEmpty())) {
            return productRepository.findAll();
        }
        throw new RuntimeException("couldn't find any products");
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RuntimeException("ID is not exist");
        }


    }

    @Override
    @Transactional
    public Product save(Product theProduct) {
        return productRepository.save(theProduct);

    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}

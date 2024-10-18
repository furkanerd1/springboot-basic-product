package com.furkan.productdemo.service;

import com.furkan.productdemo.model.Product;
import com.furkan.productdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return productRepository.findAll();
        }

        @Override
        public Product getProductById(int id) {
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                return product.get();
            }else{
                throw new RuntimeException("id bulunamadı");
            }


        }

        @Override
        public Product save(Product theProduct) {
            return productRepository.save(theProduct);

        }

        @Override
         public void deleteProduct(int id) {
             if (productRepository.existsById(id)) {
                 productRepository.deleteById(id);
             }
             throw new RuntimeException("Geçersiz ID");
         }
}

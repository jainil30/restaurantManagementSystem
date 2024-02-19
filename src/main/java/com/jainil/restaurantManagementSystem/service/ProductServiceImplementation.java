package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Product;
import com.jainil.restaurantManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product fetchProductById(Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public List<Product> fetchAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product productDb = productRepository.findById(id).get();
        /*
            private String productCategoryName;
    private String productSubCategoryName;
    private String productName;
    private String productPrice;
    private String productDescription;
    private String productImageUrl;

         */
        if(Objects.nonNull(product.getProductName()) && !"".equals(product.getProductName())){
            productDb.setProductName(product.getProductName());
        }

        if(Objects.nonNull(product.getProductSubCategoryName()) && !"".equals(product.getProductSubCategoryName())){
            productDb.setProductSubCategoryName(product.getProductSubCategoryName());
        }

        if(Objects.nonNull(product.getProductCategoryName()) && !"".equals(product.getProductCategoryName())){
            productDb.setProductCategoryName(product.getProductCategoryName());
        }

        if(Objects.nonNull(product.getProductPrice()) && !"".equals(product.getProductPrice())){
            productDb.setProductPrice(product.getProductPrice());
        }
        if(Objects.nonNull(product.getProductDescription()) && !"".equals(product.getProductDescription())){
            productDb.setProductDescription(product.getProductDescription());
        }

        if(Objects.nonNull(product.getProductImageUrl()) && !"".equals(product.getProductImageUrl())){
            productDb.setProductImageUrl(product.getProductImageUrl());
        }

        productRepository.save(productDb);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> fetchAllProductsByProductRestaurant(String email) {
        return this.productRepository.findByProductRestaurant(email);
    }
}

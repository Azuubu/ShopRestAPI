package com.azubu.restapi.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepositoryInterface<Product> productRepositoryInterface;

    public ProductService(ProductRepositoryInterface<Product> productRepositoryInterface) {
        this.productRepositoryInterface = productRepositoryInterface;
    }

    public List<Product> getAllProducts() {
        return productRepositoryInterface.selectAllProducts();
    }

    public List<Product> getAllProductsByTagGroup(String mainGroup) {
        return productRepositoryInterface.selectAllProductsByGroupName(mainGroup);
    }

    public Product getProductById(int id) {
        return productRepositoryInterface.selectProductById(id);
    }

    public String addProducts(List<Product> products) {
        return productRepositoryInterface.addProducts(products);
    }

    public String updateProduct(Product product) {
        return productRepositoryInterface.updateProduct(product);
    }

    public String deleteProduct(int id) {
        return productRepositoryInterface.deleteProducts(id);
    }
}

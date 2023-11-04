package com.azubu.restapi.product;

import java.util.List;

public interface ProductRepositoryInterface<Product> {

    List<Product> selectAllProducts();

    List<Product> selectAllProductsByGroupName(String mainGroup);

    Product selectProductById(int id);

    String addProducts(List<Product> products);

    String updateProduct(Product product);

    String deleteProducts(int id);



}

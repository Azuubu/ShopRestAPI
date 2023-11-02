package com.azubu.restapi.product;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInterface<Product> {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Product> selectAllProducts() {
        return jdbcTemplate.query("SELECT id, name, main_group, tag, expiration_date, price, weight_kg FROM products",
                BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public List<Product> selectAllProductsByGroupName(String mainGroup) {
        return jdbcTemplate.query("SELECT id, name, main_group, tag, expiration_date, price, weight_kg FROM products WHERE main_group = ?",
                BeanPropertyRowMapper.newInstance(Product.class), mainGroup);
    }

    @Override
    public Product selectProductById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, main_group, tag, expiration_date, price, weight_kg FROM products WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    @Override
    public String addProducts(List<Product> products) {
        try {
            products.forEach(product -> jdbcTemplate.update("INSERT INTO products VALUES(?, ?, ?, ?, ?, ?, ?)", product.getId(),
                    product.getName(), product.getMainGroup(), product.getTag(), product.getExpirationDate(), product.getPrice(), product.getWeightInGrams()));
        } catch (Exception e) {
            return e.toString();
        }
        return "DB - Added the product successfully!";
    }

    @Override
    public String updateProduct(Product product) {
        try {
            jdbcTemplate.update("UPDATE products SET name=?, main_group=?, tag=?, expiration_date=?, price=?, weight_kg=? WHERE id=?",
                    product.getName(), product.getMainGroup(), product.getTag(), product.getExpirationDate(), product.getPrice(), product.getWeightInGrams(), product.getId());
        } catch (Exception e) {
            return e.toString();
        }
        return "DB - Updated successfully!";
    }

    @Override
    public String deleteProducts(int id) {
        try {
            jdbcTemplate.update("DELETE FROM products WHERE id=?", id);
        } catch (Exception e) {
            return e.toString();
        }
        return "DB - Deleted successfully!";
    }
}

package com.azubu.restapi.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/group/{groupName}")
    public List<Product> getAllProductsByTagGroup(@PathVariable("groupName") String groupName) {
        return productService.getAllProductsByTagGroup(groupName);
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/id/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        return productService.deleteProduct(id);
    }

    @PatchMapping("/id/{id}")
    public String updateProduct(@PathVariable("id") int id, @RequestBody Product productToUpdate) {
        Product product = productService.getProductById(id);

        if(product != null) {
            if (productToUpdate.getName() != null) product.setName(productToUpdate.getName());
            if (productToUpdate.getMainGroup() != null) product.setMainGroup(productToUpdate.getMainGroup());
            if (productToUpdate.getTag() != null) product.setTag(productToUpdate.getTag());
            if (productToUpdate.getExpirationDate() != null) product.setExpirationDate(productToUpdate.getExpirationDate());
            if (productToUpdate.getPrice() != 0) product.setPrice(productToUpdate.getPrice());
            if (productToUpdate.getWeightInGrams() != 0) product.setWeightInGrams(productToUpdate.getWeightInGrams());

            return productService.updateProduct(product);

        } else {
            return "Couldn't update the requested product!";
        }
    }

    @PostMapping()
    public String addProducts(@RequestBody List<Product> products) {
        return productService.addProducts(products);
    }


}

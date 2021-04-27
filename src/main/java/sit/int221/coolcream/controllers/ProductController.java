package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.coolcream.models.Product;
import sit.int221.coolcream.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping ("/products")
    public List<Product> product() {
        return productRepository.findAll();
    }
}

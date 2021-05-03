package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.coolcream.models.Product;
import sit.int221.coolcream.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping ("/product")
    public List<Product> product() {
        return productRepository.findAll();
    }

//    @GetMapping ("/show/{product_id}")
//    public Product show (@PathVariable Long product_id){
//        return productRepository.findById(product_id).orElse(null);
//    }

    @PostMapping("/add")
    public Product add (@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/edit/{product_id}")
    public List<Product> add (@PathVariable Long product_id){
        return productRepository.findAll();
    }

    @DeleteMapping("/delete/{product_id}")
    public List<Product> delete(@PathVariable Long product_id){
        productRepository.deleteById(product_id);
        return productRepository.findAll();
    }
}

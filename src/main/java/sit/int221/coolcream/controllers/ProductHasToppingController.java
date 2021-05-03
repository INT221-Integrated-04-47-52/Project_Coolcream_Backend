package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.coolcream.models.ProductHasTopping;
import sit.int221.coolcream.repositories.ProductHasToppingRepository;

import java.util.List;

@RestController
public class ProductHasToppingController {
    @Autowired
    private ProductHasToppingRepository productHasToppingRepository;

    @GetMapping("/product-topping")
    public List<ProductHasTopping> productHasToppingstopping() {
        return productHasToppingRepository.findAll();
    }
}

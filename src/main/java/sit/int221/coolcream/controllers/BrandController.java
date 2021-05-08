package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.coolcream.models.Brand;
import sit.int221.coolcream.repositories.BrandRepository;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @GetMapping ("/brand")
    public List<Brand> brand() {
        return brandRepository.findAll();
    }
}

package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.coolcream.models.Topping;
import sit.int221.coolcream.repositories.ToppingRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ToppingController {
    @Autowired
    private ToppingRepository toppingRepository;

    @GetMapping ("/topping")
    public List<Topping> topping() {
        return toppingRepository.findAll();
    }
}

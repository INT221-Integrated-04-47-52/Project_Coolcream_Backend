package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.coolcream.models.IcecreamtHasTopping;
import sit.int221.coolcream.repositories.IcecreamHasToppingRepository;

import java.util.List;

@RestController
public class IcecreamHasToppingController {
    @Autowired
    private IcecreamHasToppingRepository icecreamHasToppingRepository;

    @GetMapping("/icecream-topping")
    public List<IcecreamtHasTopping> icecreamHasToppingstopping() {
        return icecreamHasToppingRepository.findAll();
    }
}

package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.coolcream.models.Size;
import sit.int221.coolcream.repositories.SizeRepository;

import java.util.List;

@RestController
public class SizeController {
    @Autowired
    private SizeRepository sizeRepository;

    @GetMapping ("/size")
    public List<Size> size() {
        return sizeRepository.findAll();
    }
}

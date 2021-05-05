package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.coolcream.models.Icecream;
import sit.int221.coolcream.repositories.IcecreamRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class IcecreamController {
    @Autowired
    private IcecreamRepository icecreamRepository;

    @GetMapping ("/icecream")
    public List<Icecream> icecream() {
        return icecreamRepository.findAll();
    }

    @PostMapping("/add")
    public Icecream add (@RequestBody Icecream icecream){
        return icecreamRepository.save(icecream);
    }

    @DeleteMapping("/delete/{icecream_id}")
    public List<Icecream> delete(@PathVariable Long icecream_id){
        icecreamRepository.deleteById(icecream_id);
        return icecreamRepository.findAll();
    }

    @PutMapping("/edit/{icecream_id}")
    public Icecream edit (@RequestBody Icecream icecream){
        icecreamRepository.findById(icecream.getIcecreamId()).orElse(null);
        return icecreamRepository.save(icecream);
    }

    @GetMapping("/max-icecreamId")
    public long maxIcecreamId (){
        return icecreamRepository.getMaxIcecreamId();
    }

}

package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.coolcream.exceptions.ExceptionResponse;
import sit.int221.coolcream.exceptions.IcecreamException;
import sit.int221.coolcream.models.Icecream;
import sit.int221.coolcream.repositories.IcecreamRepository;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class IcecreamController {
    @Autowired
    private IcecreamRepository icecreamRepository;

    @GetMapping("/icecream")
    public List<Icecream> icecream() {
        return icecreamRepository.findAll();
    }

    @PostMapping("/add")
    public Icecream add(@RequestBody Icecream newIcecream) {
        if (icecreamRepository.findById(newIcecream.getIcecreamId()).orElse(null) != null
                && icecreamRepository.findByName(newIcecream.getIcecreamName()) != null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_ALREADY_EXIST,
                    "Can't add. Icecream id: " + newIcecream.getIcecreamId()
                            + ", Icecream name: " + newIcecream.getIcecreamName()
                            + " already exist.");
        } else if (icecreamRepository.findById(newIcecream.getIcecreamId()).orElse(null) != null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_ID_ALREADY_EXIST,
                    "Can't add. Icecream id: " + newIcecream.getIcecreamId() + " already exist.");
        } else if (icecreamRepository.findByName(newIcecream.getIcecreamName()) != null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_NAME_ALREADY_EXIST,
                    "Can't add. Icecream name: " + newIcecream.getIcecreamName() + " already exist.");
        }
        return icecreamRepository.save(newIcecream);
    }

    @DeleteMapping("/delete/{icecream_id}")
    public List<Icecream> delete(@PathVariable Long icecream_id) {
        if (icecreamRepository.findById(icecream_id).orElse(null) == null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_ID_ALREADY_EXIST,
                    "Can't delete. Icecream id: " + icecream_id + " does not exist.");
        }
        icecreamRepository.deleteById(icecream_id);
        return icecreamRepository.findAll();
    }

    @PutMapping("/edit/{icecrem_id}")
    public Icecream edit(@RequestBody Icecream editIcecream) {
        if (icecreamRepository.findById(editIcecream.getIcecreamId()).orElse(null) == null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_DOES_NOT_EXIST,
                    "Can't edit. Icecream id: " + editIcecream.getIcecreamId() + " does not exist.");
        } else if (icecreamRepository.findByName(editIcecream.getIcecreamName()) != null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_NAME_ALREADY_EXIST,
                    "Can't edit. Icecream name: " + editIcecream.getIcecreamName() + " already exist.");
        }
        return icecreamRepository.save(editIcecream);
    }

    @GetMapping("/max-icecreamId")
    public long maxIcecreamId() {
        return icecreamRepository.getMaxIcecreamId();
    }

}

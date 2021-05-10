package sit.int221.coolcream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sit.int221.coolcream.exceptions.ExceptionResponse;
import sit.int221.coolcream.exceptions.IcecreamException;
import sit.int221.coolcream.models.Icecream;
import sit.int221.coolcream.models.IcecreamHasTopping;
import sit.int221.coolcream.repositories.IcecreamHasToppingRepository;
import sit.int221.coolcream.repositories.IcecreamRepository;
import sit.int221.coolcream.services.StorageService;

import java.util.List;

@RestController
public class IcecreamController {
    @Autowired
    private IcecreamRepository icecreamRepository;
    @Autowired
    private IcecreamHasToppingRepository icecreamHasToppingRepository;
    @Autowired
    StorageService storageService;

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
        Icecream icecreamNoTopping = new Icecream(newIcecream.getIcecreamId(), newIcecream.getIcecreamName(), newIcecream.getDescription(), newIcecream.getPrice(), newIcecream.getLastday(), newIcecream.getImage(), newIcecream.getBrand(), newIcecream.getSize());
        icecreamRepository.save(icecreamNoTopping);
        List<IcecreamHasTopping> icecreamHasToppings = newIcecream.getIcecreamHasToppings();
        for (IcecreamHasTopping iceHasTopping : icecreamHasToppings) {
            iceHasTopping.setIcecream(newIcecream);
            icecreamHasToppingRepository.save(iceHasTopping);
        }
        return icecreamRepository.save(newIcecream);
    }

    @PostMapping(value = "/add/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Icecream addIcecreamWithImage
            (@RequestParam(value = "image", required = false) MultipartFile imageFile, @RequestPart Icecream newIcecream) {
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
        } else if (imageFile == null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_IMAGE_NULL,
                    "Can't add. Icecream id: " + newIcecream.getIcecreamId());
        } else newIcecream.setImage(storageService.store(imageFile, newIcecream.getIcecreamId()));
        Icecream icecreamNoTopping = new Icecream(newIcecream.getIcecreamId(), newIcecream.getIcecreamName(), newIcecream.getDescription(), newIcecream.getPrice(), newIcecream.getLastday(), newIcecream.getImage(), newIcecream.getBrand(), newIcecream.getSize());
        icecreamRepository.save(icecreamNoTopping);
        List<IcecreamHasTopping> icecreamHasToppings = newIcecream.getIcecreamHasToppings();
        for (IcecreamHasTopping iceHasTopping : icecreamHasToppings) {
            iceHasTopping.setIcecream(newIcecream);
            icecreamHasToppingRepository.save(iceHasTopping);
        }
        return icecreamRepository.save(newIcecream);
    }

    @DeleteMapping("/delete/{icecream_id}")
    public void delete(@PathVariable Long icecream_id) {
        Icecream icecream = icecreamRepository.findById(icecream_id).orElse(null);
        if (icecream == null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_ID_ALREADY_EXIST,
                    "Can't delete. Icecream id: " + icecream_id + " does not exist.");
        } else storageService.delete(icecream.getImage());
        List<IcecreamHasTopping> beforeEditIcecream = icecream.getIcecreamHasToppings();
        for (IcecreamHasTopping iceHasTopping : beforeEditIcecream) {
            icecreamHasToppingRepository.deleteById(iceHasTopping.getHasToppingId());
        }
        icecreamRepository.deleteById(icecream_id);
    }

    @PutMapping("/edit")
    public Icecream edit(@RequestPart Icecream editIcecream) {
        Icecream icecreamId = icecreamRepository.findById(editIcecream.getIcecreamId()).orElse(null);
        Icecream icecreamName = icecreamRepository.findByName(editIcecream.getIcecreamName());
        if (icecreamId == null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_DOES_NOT_EXIST,
                    "Can't edit. Icecream id: " + editIcecream.getIcecreamId() + " does not exist.");
        } else if (icecreamName != null && icecreamId.getIcecreamId() != icecreamName.getIcecreamId()) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_NAME_ALREADY_EXIST,
                    "Can't edit. Icecream name: " + editIcecream.getIcecreamName() + " already exist.");
        }
        List<IcecreamHasTopping> beforeEditIcecream = icecreamId.getIcecreamHasToppings();
        for (IcecreamHasTopping iceHasTopping : beforeEditIcecream) {
            icecreamHasToppingRepository.deleteById(iceHasTopping.getHasToppingId());
        }
        List<IcecreamHasTopping> icecreamHasToppings = editIcecream.getIcecreamHasToppings();
        for (IcecreamHasTopping iceHasTopping : icecreamHasToppings) {
            iceHasTopping.setIcecream(editIcecream);
            icecreamHasToppingRepository.save(iceHasTopping);
        }
        return icecreamRepository.save(editIcecream);
    }

    @PutMapping("/edit/image")
    public Icecream editWithImage(@RequestParam(value = "image", required = false) MultipartFile imageFile, @RequestPart Icecream editIcecream) {
        Icecream icecreamId = icecreamRepository.findById(editIcecream.getIcecreamId()).orElse(null);
        Icecream icecreamName = icecreamRepository.findByName(editIcecream.getIcecreamName());
        if (icecreamId == null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_DOES_NOT_EXIST,
                    "Can't edit. Icecream id: " + editIcecream.getIcecreamId() + " does not exist.");
        } else if (icecreamName != null && icecreamId.getIcecreamId() != icecreamName.getIcecreamId()) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_NAME_ALREADY_EXIST,
                    "Can't edit. Icecream name: " + editIcecream.getIcecreamName() + " already exist.");
        } else if (imageFile == null) {
            throw new IcecreamException(ExceptionResponse.ERROR_CODE.ICECREAM_IMAGE_NULL,
                    "Can't add. Icecream id: " + editIcecream.getIcecreamId());
        }
        storageService.delete(icecreamId.getImage());
        editIcecream.setImage(storageService.store(imageFile, editIcecream.getIcecreamId()));
        List<IcecreamHasTopping> beforeEditIcecream = icecreamId.getIcecreamHasToppings();
        for (IcecreamHasTopping iceHasTopping : beforeEditIcecream) {
            icecreamHasToppingRepository.deleteById(iceHasTopping.getHasToppingId());
        }
        Icecream icecreamNoTopping = new Icecream(editIcecream.getIcecreamId(), editIcecream.getIcecreamName(), editIcecream.getDescription(), editIcecream.getPrice(), editIcecream.getLastday(), editIcecream.getImage(), editIcecream.getBrand(), editIcecream.getSize());
        icecreamRepository.save(icecreamNoTopping);
        List<IcecreamHasTopping> icecreamHasToppings = editIcecream.getIcecreamHasToppings();
        for (IcecreamHasTopping iceHasTopping : icecreamHasToppings) {
            iceHasTopping.setIcecream(editIcecream);
            icecreamHasToppingRepository.save(iceHasTopping);
        }
        return icecreamRepository.save(editIcecream);
    }

    @GetMapping("/max-icecreamId")
    public long maxIcecreamId() {
        return icecreamRepository.getMaxIcecreamId();
    }

}

package sit.int221.coolcream.services;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public interface StorageService {

    void init();

    String store(MultipartFile image, Long icecreamId);

    Stream<Path> loadAll();

    Path load(String imageName);

    Resource loadAsResource(String imageName);

    void deleteAll();

    void delete(String imageName);

}

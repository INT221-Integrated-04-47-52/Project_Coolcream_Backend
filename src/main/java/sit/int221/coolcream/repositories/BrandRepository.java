package sit.int221.coolcream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.coolcream.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {


}

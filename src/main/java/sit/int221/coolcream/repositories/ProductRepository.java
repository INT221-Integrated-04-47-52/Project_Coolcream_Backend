package sit.int221.coolcream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.coolcream.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

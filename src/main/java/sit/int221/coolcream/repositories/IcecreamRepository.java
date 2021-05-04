package sit.int221.coolcream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.coolcream.models.Icecream;

public interface IcecreamRepository extends JpaRepository<Icecream, Long> {


}

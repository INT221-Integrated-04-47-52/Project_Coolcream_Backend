package sit.int221.coolcream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.coolcream.models.IcecreamHasTopping;

public interface IcecreamHasToppingRepository extends JpaRepository<IcecreamHasTopping, Long> {

}

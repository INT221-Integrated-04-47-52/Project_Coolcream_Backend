package sit.int221.coolcream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int221.coolcream.models.Icecream;


public interface IcecreamRepository extends JpaRepository<Icecream, Long> {

    @Query(value = "SELECT max(icecreamId) FROM Icecream")
    Long getMaxIcecreamId();

    @Query(value = "SELECT i FROM Icecream i WHERE i.icecreamName = ?1")
    Icecream findByName(String icecreamName);
}

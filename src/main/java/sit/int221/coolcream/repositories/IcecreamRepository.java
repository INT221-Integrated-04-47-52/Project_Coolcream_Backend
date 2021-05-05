package sit.int221.coolcream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int221.coolcream.models.Icecream;

public interface IcecreamRepository extends JpaRepository<Icecream, Long> {

    @Query(value = "SELECT max(icecreamId) FROM Icecream")
    public Long getMaxIcecreamId();
}

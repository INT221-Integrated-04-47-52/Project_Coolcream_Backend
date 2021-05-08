package sit.int221.coolcream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int221.coolcream.models.IcecreamHasTopping;

public interface IcecreamHasToppingRepository extends JpaRepository<IcecreamHasTopping, Long> {

    @Query(value = "SELECT max(hasToppingId) FROM IcecreamHasTopping ")
    Long getMaxIcecreamId();

}

package grupo.cuatro.scanPAP.dao;

import grupo.cuatro.scanPAP.model.Center;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterDAO extends JpaRepository<Center, Long> {

    Center findByIdCenter(Long id);
    Center findByAddressCenter(String address);
    Center findByNameCenter(String name);
}

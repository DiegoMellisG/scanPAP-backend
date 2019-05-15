package grupo.cuatro.scanPAP.dao;

import grupo.cuatro.scanPAP.model.Center;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterDAO extends JpaRepository<Long, Center> {

    Center findById(long id);
    //Center findByName(String name);
}

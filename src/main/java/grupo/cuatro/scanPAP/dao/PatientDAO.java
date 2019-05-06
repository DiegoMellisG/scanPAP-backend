package grupo.cuatro.scanPAP.dao;

import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientDAO extends JpaRepository<Patient,Long> {

    Patient findByRun(String run);
}

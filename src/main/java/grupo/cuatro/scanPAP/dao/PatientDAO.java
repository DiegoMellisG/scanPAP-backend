package grupo.cuatro.scanPAP.dao;

import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDAO extends JpaRepository<Patient,Long> {

    Patient findByRun(String run);
}

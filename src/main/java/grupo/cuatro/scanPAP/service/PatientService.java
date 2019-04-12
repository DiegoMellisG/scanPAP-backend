package grupo.cuatro.scanPAP.service;

import grupo.cuatro.scanPAP.dao.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientDAO patientDAO;

    @Autowired
    public PatientService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }


}

package grupo.cuatro.scanPAP.service;

import grupo.cuatro.scanPAP.dao.PatientDAO;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {

    private final PatientDAO patientDAO;

    @Autowired
    public PatientService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }


    public Map<String, Object> verifyExpirationDate(Patient patient)
    {
        Map<String, Object> response = new HashMap<String, Object>();
        LocalDate expirationDate = LocalDate.of(patient.getExpirationDate().getYear(),
                patient.getExpirationDate().getMonth(),patient.getExpirationDate().getDayOfMonth()).minusDays(7);

        LocalDate today = LocalDate.now();

        Period difference = Period.between(expirationDate,today);
        int ages = difference.getYears();

        if (ages >= 1)
        {
            response.put("years", ages);
            response.put("validity", true);
            return response;
        }
        else
        {
            response.put("years", ages);
            response.put("validity",false);
            return response;
        }
    }


}

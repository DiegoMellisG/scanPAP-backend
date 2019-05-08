package grupo.cuatro.scanPAP.service;

import grupo.cuatro.scanPAP.dao.PatientDAO;
import grupo.cuatro.scanPAP.dto.PatientDTO;
import grupo.cuatro.scanPAP.mapper.PatientMapper;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.TemporalUnit;

@Service
public class PatientService {

    private final PatientDAO patientDAO;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientService(PatientDAO patientDAO, PatientMapper patientMapper) {
        this.patientDAO = patientDAO;
        this.patientMapper = patientMapper;
    }


    public PatientDTO getPatientInfo(String run)
    {

        Patient patient = patientDAO.findByRun(run);
        System.out.println(patient.getRun());
        LocalDate expirationDate = LocalDate.of(patient.getValidityDate().getYear(),
                patient.getValidityDate().getMonth(),patient.getValidityDate().getDayOfMonth()).minusDays(30);
        System.out.println(expirationDate);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        Period difference = Period.between(expirationDate,today);

        int diffYears = difference.getYears();
        int diffMonths = difference.getMonths();
        int diffDays = difference.getDays();



        if (diffYears>=1)
        {
            //FALSE: NO ESTÁ VIGENTE
            return patientMapper.toPatientDTO(patient,false, diffYears, diffMonths, diffDays);

        }
        else if (diffYears < 1 && difference.getMonths() > 0)
        {
            return patientMapper.toPatientDTO(patient, false, diffYears, diffMonths, diffDays);
        }

        else
            return patientMapper.toPatientDTO(patient, true, diffYears, diffMonths, diffDays);
    }



}

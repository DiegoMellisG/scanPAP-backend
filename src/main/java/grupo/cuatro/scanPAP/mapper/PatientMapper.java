package grupo.cuatro.scanPAP.mapper;


import grupo.cuatro.scanPAP.dto.PatientDTO;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
public class PatientMapper {

    public PatientDTO toPatientDTO(Patient patient)
    {
        PatientDTO patientDTO = new PatientDTO();
        BeanUtils.copyProperties(patient,patientDTO);
        patientDTO.setCenter(patient.getCenter());
        patientDTO.setBirthDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(patient.getBirthDate()));
        patientDTO.setLastPapDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(patient.getLastPapDate()));
        patientDTO.setValidityDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(patient.getValidityDate()));

        LocalDate expirationDate = LocalDate.of(patient.getValidityDate().getYear(),
                patient.getValidityDate().getMonth(),patient.getValidityDate().getDayOfMonth()).minusDays(30);
        System.out.println(expirationDate);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        Period difference = Period.between(expirationDate,today);

        Integer diffYears = difference.getYears();
        Integer diffMonths = difference.getMonths();
        Integer diffDays = difference.getDays();

        patientDTO.setDiffYears(diffYears);
        patientDTO.setDiffMonths(diffMonths);
        patientDTO.setDiffDays(diffDays);


        if (diffYears>=1)
        {
            //FALSE: NO ESTÁ VIGENTE
            patientDTO.setValidity(false);

        }
        else if (difference.getMonths() > 0)
        {
            patientDTO.setValidity(false);
        }

        else
            patientDTO.setValidity(true);

        return patientDTO;

    }
}

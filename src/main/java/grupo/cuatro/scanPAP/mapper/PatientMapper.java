package grupo.cuatro.scanPAP.mapper;


import grupo.cuatro.scanPAP.dto.PatientDTO;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class PatientMapper {

    public PatientDTO toPatientDTO(Patient patient, boolean validity, Integer years, Integer months, Integer days)
    {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName(patient.getName());
        patientDTO.setRun(patient.getRun());
        patientDTO.setAge(patient.getAge());
        patientDTO.setCenter(patient.getCenter());
        patientDTO.setBirthDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(patient.getBirthDate()));
        patientDTO.setLastPapDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(patient.getLastPapDate()));
        patientDTO.setValidityDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(patient.getValidityDate()));
        patientDTO.setValidity(validity);
        patientDTO.setDiffYears(years);
        patientDTO.setDiffMonths(months);
        patientDTO.setDiffDays(days);

        return patientDTO;

    }
}

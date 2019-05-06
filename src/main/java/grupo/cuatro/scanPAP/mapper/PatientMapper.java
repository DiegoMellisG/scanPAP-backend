package grupo.cuatro.scanPAP.mapper;


import grupo.cuatro.scanPAP.dto.PatientDTO;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientDTO toPatientDTO(Patient patient, boolean validity, Integer years)
    {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName(patient.getName());
        patientDTO.setRun(patient.getRun());
        patientDTO.setAge(patient.getAge());
        patientDTO.setBirthDate(patient.getBirthdate());
        patientDTO.setLastPapDate(patient.getLastPapDate());
        patientDTO.setValidityDate(patient.getValidityDate());
        patientDTO.setValidity(validity);
        patientDTO.setDiffYears(years);
        return patientDTO;

    }
}

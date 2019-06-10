package grupo.cuatro.scanPAP.service;

import grupo.cuatro.scanPAP.dao.PatientDAO;
import grupo.cuatro.scanPAP.dto.PatientDTO;
import grupo.cuatro.scanPAP.mapper.PatientMapper;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return patientMapper.toPatientDTO(patient);
    }

    public PatientDTO setAccessToken (Long idPatient, String token)
    {
        Patient patient = patientDAO.findByIdPatient(idPatient);
        patient.setAccessToken(token);
        patientDAO.save(patient);
        return patientMapper.toPatientDTO(patient);
    }

    



}

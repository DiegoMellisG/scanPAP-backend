package grupo.cuatro.scanPAP.controller;

import grupo.cuatro.scanPAP.dao.PatientDAO;
import grupo.cuatro.scanPAP.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController

public class PatientController {

    private final PatientService patientService;

    private final PatientDAO patientDAO;

    public PatientController(PatientService patientService, PatientDAO patientDAO) {
        this.patientService = patientService;
        this.patientDAO = patientDAO;
    }

    @RequestMapping(value = "consultation", method = RequestMethod.GET)
    public ResponseEntity getPatientConsultation(@RequestParam("rut") String rut)
    {
        return ResponseEntity.ok(patientService.getPatientInfo(rut));
    }




}

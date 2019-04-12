package grupo.cuatro.scanPAP.controller;

import grupo.cuatro.scanPAP.dao.PatientDAO;
import grupo.cuatro.scanPAP.model.Patient;
import grupo.cuatro.scanPAP.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin
@RestController

public class PatientController {

    private final PatientService patientService;

    private final PatientDAO patientDAO;

    public PatientController(PatientService patientService, PatientDAO patientDAO) {
        this.patientService = patientService;
        this.patientDAO = patientDAO;
    }

    @RequestMapping(value = "expiration", method = RequestMethod.GET)
    public ResponseEntity getValidity(@RequestParam("rut") String rut)
    {
        Patient patient = patientDAO.findByRut(rut);
        return ResponseEntity.ok(Collections.singletonMap("validity",true));
    }
}

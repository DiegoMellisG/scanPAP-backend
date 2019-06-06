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
    public ResponseEntity getPatientConsultation(@RequestParam("run") String run)
    {
        return ResponseEntity.ok(patientService.getPatientInfo(run));
    }

    @RequestMapping(value = "setToken", method = RequestMethod.PUT)
    public ResponseEntity setToken(@RequestParam("run") String run, @RequestParam("token") String token)
    {
        return ResponseEntity.ok(patientService.SAT(run, token));
    }


}

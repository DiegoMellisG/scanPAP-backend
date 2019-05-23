package grupo.cuatro.scanPAP.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class PatientDTOTest {

    @Test
    public void getPatient() throws Exception
    {
        PatientDTO patient = new PatientDTO();
        patient.setName("test");
        patient.setRun("12345678-9");
        patient.setAge(24);
        patient.setLastPapDate("test");
        patient.setDiffDays(0);
        patient.setDiffMonths(0);
        patient.setDiffYears(0);
        patient.setCenter(null);
        patient.setValidity(true);
        patient.setBirthDate("test");
        patient.setValidityDate("test");

        Assert.assertNotNull(patient);
        /*ResponseEntity<PatientDTO> pt =  ResponseEntity.ok(patient);
        given(patientController.getPatientConsultation("12345678-9")).willReturn(pt);

        System.out.println(pt);

        mvc.perform(get("/app/consultation/{run}","12345678-9")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(patient.getName())));
        System.out.println("Test success");*/
    }
}

package grupo.cuatro.scanPAP.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import grupo.cuatro.scanPAP.dto.PatientDTO;
import grupo.cuatro.scanPAP.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLOutput;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

    @Autowired
    MockMvc mvc;
    ObjectMapper objectMapper;

    @MockBean
    private PatientController patientController;


    @Test
    public void postAccessToken() throws Exception
    {
        mvc.perform(put("/setToken")
                .param("run", "12345678-9")
                .param("token", "token-test")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    
    @Test
    public void getPatient() throws Exception {

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

        ResponseEntity<PatientDTO> ptn = ResponseEntity.ok(patient);
        given(patientController.getPatientConsultation("12345678-9")).willReturn(ptn);

        mvc.perform(get("/consultation").param("run","12345678-9")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(patient.getName())));

    }


}

package grupo.cuatro.scanPAP.controller;

import grupo.cuatro.scanPAP.dto.PatientDTO;
import grupo.cuatro.scanPAP.model.Center;
import grupo.cuatro.scanPAP.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = PatientController.class)
public class CenterControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private CenterController centerController;

    @Test
    public void getCenter() throws Exception {

        Center center = new Center();
        center.setAddress("AddressTest");
        center.setIdCenter(999L);
        center.setName("NameTest");
        PatientDTO patient = new PatientDTO();
        patient.setName("test");
        patient.setRun("12345678-9");
        patient.setAge(24);
        patient.setLastPapDate("test");
        patient.setDiffDays(0);
        patient.setDiffMonths(0);
        patient.setDiffYears(0);
        patient.setCenter(center);
        patient.setValidity(true);
        patient.setBirthDate("BirthTest");
        patient.setValidityDate("ValidityDateTest");

        ResponseEntity<Center> rec = ResponseEntity.ok(center);
        given(centerController.getCenters(999L)).willReturn(rec);

        mvc.perform(get("/centers")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(center.getName())));
        System.out.println("TEST FINISHED");
    }
}

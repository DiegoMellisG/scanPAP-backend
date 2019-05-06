package grupo.cuatro.scanPAP.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PatientDTO {

    private String name;
    private String run;
    private Integer age;
    private ZonedDateTime birthDate;
    private ZonedDateTime lastPapDate;
    private ZonedDateTime validityDate;
    private boolean validity;
    private Integer diffYears;


}

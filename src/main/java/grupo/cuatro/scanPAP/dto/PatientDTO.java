package grupo.cuatro.scanPAP.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PatientDTO {

    private String name;
    private String run;
    private Integer age;
    private String birthDate;
    private String lastPapDate;
    private String validityDate;
    private boolean validity;
    private Integer diffYears;
    private Integer diffMonths;
    private Integer diffDays;


}

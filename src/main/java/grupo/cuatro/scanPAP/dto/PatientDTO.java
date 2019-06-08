package grupo.cuatro.scanPAP.dto;

import grupo.cuatro.scanPAP.model.Center;
import lombok.Data;

@Data
public class PatientDTO {

    private Long idPatient;
    private String name;
    private String run;
    private Integer age;
    private String birthDate;
    private String lastPapDate;
    private String validityDate;
    private Boolean validity;
    private Integer diffYears;
    private Integer diffMonths;
    private Integer diffDays;
    private Center center;
    private String accessToken;
}

package grupo.cuatro.scanPAP.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "PATIENT")
public class Patient {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "PATIENT_ID",
            unique = true,
            nullable = false
    )
    private Long idPatient;

    @Column(
            name = "RUN",
            unique = true,
            nullable = false
    )
    private String run;

    @Column(
            name = "ACCESS_TOKEN",
            unique = true
    )
    private String accessToken;

    @Column(
            name = "NAME",
            nullable = false
    )
    private String name;
    @Column(
            name = "AGE",
            nullable = false
    )
    private Integer age;

    @Column(
            name = "BIRTH_DATE",
            nullable = false
    )
    private ZonedDateTime birthDate;

    @Column(
            name = "PHONE_NUMBER",
            unique = true,
            nullable = false
    )
    private String phoneNumber;

    @Column(
            name = "LAST_PAP_DATE",
            nullable = false
    )
    private ZonedDateTime lastPapDate;
    @Column(
            name = "VALIDITY_DATE"
    )
    private ZonedDateTime validityDate;

    @ManyToOne
    @JoinColumn(name = "CENTER_ID")
    @JsonIgnore
    private Center center;

}

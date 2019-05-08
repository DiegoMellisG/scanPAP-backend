package grupo.cuatro.scanPAP.model;


import lombok.Data;
import org.hibernate.annotations.NaturalId;

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
            name = "NAME",
            nullable = false
    )
    private String name;

    @Column(
            name = "AGE",
            nullable = false
    )
    private int age;

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


}

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
            strategy = GenerationType.SEQUENCE
    )
    @Column(
            name = "PATIENT_ID",
            unique = true,
            nullable = false
    )
    private Long idPatient;


    @Column(
            name = "RUN",
            length = 10,
            unique = true,
            nullable = false
    )
    @NaturalId
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
    private ZonedDateTime birthdate;

    @Column(
            name = "PHONE_NUMBER",
            unique = true,
            nullable = false
    )
    private String phoneNumber;

    @OneToOne(mappedBy = "patient")
    private User user;

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

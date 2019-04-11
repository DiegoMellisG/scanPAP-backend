package grupo.cuatro.scanPAP.model;


import lombok.Data;

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
            name = "RUT",
            unique = true,
            nullable = false
    )
    private String rut;

    @Column(
            name = "EXPIRATION_DATE"
    )
    private ZonedDateTime expirationDate;
}

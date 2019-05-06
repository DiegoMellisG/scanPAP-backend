package grupo.cuatro.scanPAP.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "USER_ID",
            unique = true,
            nullable = false
    )
    private Long idUser;

    @Column(
            name = "TOKEN",
            unique = true
    )
    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PATIENT_RUN", referencedColumnName = "RUN")
    private Patient patient;
}

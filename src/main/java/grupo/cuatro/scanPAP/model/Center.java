package grupo.cuatro.scanPAP.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CENTER")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CENTER_ID", nullable = false, unique=true)
    private long idCenter;

    @Column(name="NAME", length=50)
    private String nameCenter;

    @Column(name="ADDRESS", length=50)
    private String addressCenter;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    private List<Patient> patients;
}

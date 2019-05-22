package grupo.cuatro.scanPAP.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long idCenter;

    @Column(name="NAME", length=50)
    private String name;

    @Column(name="ADDRESS", length=50)
    private String address;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Patient> patients;
}

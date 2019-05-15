package grupo.cuatro.scanPAP.model;


import lombok.Data;

import javax.persistence.*;

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
}

package it.academy.pojos;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanetSystem {

    @Id
    @GeneratedValue(generator = "native-generator")
    @GenericGenerator(name = "native-generator", strategy = "native")
    @Column
    private Long id;
    @Column
    @ElementCollection(targetClass=Planet.class)
    private List<Planet> planets;
    @Column
    private String name;
    @Column
    private String nameOfStar;
    @Column
    private Long distanceToGalacticCenterInLY;
    @Column
    private Integer hillSphereRadiusInLY;

}

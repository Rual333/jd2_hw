package by.it.academy.hw10.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Planet {


    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private double mass;

    @Column
    private double circumference;

    @Column
    private double accelerationOfGravity;



}

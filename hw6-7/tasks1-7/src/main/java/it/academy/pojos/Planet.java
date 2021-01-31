package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Planet {



    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Access(AccessType.FIELD)
    @Column
    private String id;

    @Access(AccessType.FIELD)
    private String name;

    private double mass;

    private double circumference;

    @Transient
    private double accelerationOfGravity;

    public Planet(String name) {
        super();
        this.name = name;
    }

    @Column
    @Access(AccessType.PROPERTY)
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getId() {
        return id;
    }
    @Column
    @Access(AccessType.PROPERTY)
    public double getCircumference() {
        return circumference;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public double getAccelerationOfGravity() {
        return accelerationOfGravity;
    }

    public void setAccelerationOfGravity(double accelerationOfGravity) {
        this.accelerationOfGravity = accelerationOfGravity;
    }

}

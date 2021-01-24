package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Integer age;
    @Column
    private String name;
    @Column
    private String surname;
}

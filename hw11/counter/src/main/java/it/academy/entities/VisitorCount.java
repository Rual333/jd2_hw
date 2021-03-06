package it.academy.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_VISITOR_COUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorCount implements Serializable {

    @Id
    private int visitorCountId;

    @Column(name = "VISITOR_COUNT")
    private int visitorCount;

}

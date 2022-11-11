package at.fhtw.swen3.persistence.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ErrorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String errorMessage;
}

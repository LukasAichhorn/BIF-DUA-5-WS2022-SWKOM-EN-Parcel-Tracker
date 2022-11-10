package at.fhtw.swen3.persistence.entities;


import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ErrorEntity {

    @Id
    long id;

    @Column
    private String errorMessage;
}

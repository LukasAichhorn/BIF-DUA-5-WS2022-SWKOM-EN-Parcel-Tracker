package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.ValidatorErrorMessages;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Entity
@Data
public class HopArrivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column
    @NotNull
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$",message = ValidatorErrorMessages.ERROR_MESSAGE_HOP_ARRIVALCODE)
    private String code;

    @Column
    private String description;

    @Column
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "parcels")
    private ParcelEntity parcel;
}
